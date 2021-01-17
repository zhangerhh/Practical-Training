package tchmanage.service.impl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.SCBean;
import tchmanage.bean.ScoreBean;
import tchmanage.dao.SCDao;
import tchmanage.service.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SCServiceImpl implements SCService {
    @Autowired
    SCDao scDao;

    @Autowired
    StudentArchivesService studentArchivesService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherCourseService teacherCourseService;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassesCourseService classesCourseService;


    @Override
    public String Count_passNum(String cno, String semester) {
        return scDao.count_passNum(cno, semester);
    }

    @Override
    public String Count_nopassNum(String cno, String semester) {
        return scDao.count_nopassNum(cno, semester);
    }

    @Override
    public String Avg_score(String cno, String semester) {
        return scDao.avg_score(cno,semester);
    }

    @Override
    public SCBean Show(String sno, String cno) {
        return scDao.show(sno, cno);
    }

    @Autowired
    SCService scService;

    @Override
    public Map<String, Object>  Add(List<Map<String, Object>> stu_scoreBeans, String semester, String classno,  String cno, String stage, String ratio) {
        Map<String, Object> map = new HashMap<>();
        DecimalFormat df = new DecimalFormat("0.0");

        float r = Float.parseFloat(ratio);
        String r_ = String.valueOf(Math.round(r*100));
        int score;
        double gradepoint;

        for(Map<String, Object> stu_scoreBean: stu_scoreBeans){
            String sno = (String) stu_scoreBean.get("sno");
            String pscore = (String) stu_scoreBean.get("pscore");
            String qscore = (String) stu_scoreBean.get("qscore");
            float p;
            float q;

            if(!pscore.equals("") && !qscore.equals("")){
                p = Float.parseFloat(pscore);
                q = Float.parseFloat(qscore);
            }
            else if(pscore.equals("") && !qscore.equals("")){
                p = 0;
                q = Float.parseFloat(qscore);
            }
            else if (!pscore.equals("") && qscore.equals("")){
                p = Float.parseFloat(pscore);
                q = 0;
            }
            else {
                p = 0;
                q = 0;
            }

            score = Math.round(p*(1-r)+q*r);
            if (score < 60){
                gradepoint = 0;
            }else {
                gradepoint = Double.parseDouble(df.format((double) score/10-5));
            }

            try {
                if (pscore.equals("") && qscore.equals("")){
                    scDao.add(sno,cno,pscore,qscore,null,gradepoint,semester);
                }else {
                    scDao.add(sno,cno,pscore,qscore,score,gradepoint,semester);
                }
            }catch (Exception e){
                map.put("code","500");
                map.put("msg","加入学生成绩失败");
                return map;
            }
        }
        classesCourseService.Update(classno,cno,semester,stage);
        courseService.Update_Ratio(cno,r_);
        map.put("code","200");
        map.put("msg","加入学生成绩成功");
        map.put("code","200");
        map.put("msg","加入学生成绩成功");
        return map;
    }

    @Override
    public Map<String, Object> Modify(List<Map<String, Object>> stu_scoreBeans , String semester, String cno,  String ratio) {
        Map<String, Object> map = new HashMap<>();
        DecimalFormat df = new DecimalFormat("0.0");
        float r = Float.parseFloat(ratio);
        String r_ = String.valueOf(Math.round(r*100));
        int score;
        double gradepoint;

        for(Map<String, Object> stu_scoreBean: stu_scoreBeans){
            String sno = (String) stu_scoreBean.get("sno");
            String pscore = (String) stu_scoreBean.get("pscore");
            String qscore = (String) stu_scoreBean.get("qscore");
            float p;
            float q;

            if(!pscore.equals("") && !qscore.equals("")){
                p = Float.parseFloat(pscore);
                q = Float.parseFloat(qscore);
            }
            else if(pscore.equals("") && !qscore.equals("")){
                p = 0;
                q = Float.parseFloat(qscore);
            }
            else if (!pscore.equals("") && qscore.equals("")){
                p = Float.parseFloat(pscore);
                q = 0;
            }
            else {
                p = 0;
                q = 0;
            }

            score = Math.round(p*(1-r)+q*r);
            if (score < 60){
                gradepoint = 0;
            }else {
                gradepoint = Double.parseDouble(df.format((double) score/10-5));
            }

            try {
                if (pscore.equals("") && qscore.equals("")){
                    scDao.modify(sno,cno,pscore,qscore,null,gradepoint,semester);
                }else {
                    scDao.modify(sno,cno,pscore,qscore,score,gradepoint,semester);
                }
            }catch (Exception e){
                map.put("code","500");
                map.put("msg","修改学生成绩失败");
                return map;
            }
        }
        courseService.Update_Ratio(cno,r_);
        map.put("code","200");
        map.put("msg","修改学生成绩成功");
        return map;
    }

    @Override
    public String Count_Num(String cno, String semester) {
        return scDao.Count_Num(cno, semester);
    }

    @Override
    public List<ScoreBean> FindCnoBySno(String sno, String semester) {
        List<ScoreBean> scoreBeans = new ArrayList<>();
        List<SCBean> scBeans =  scDao.findCnoBySno(sno, semester);
        String classno = studentArchivesService.FindClassnoBysno(sno);
        for(SCBean scBean:scBeans){
            ScoreBean scoreBean = new ScoreBean();
            String tno = teacherCourseService.FindTno(scBean.getCno(), classno);
            scoreBean.setSemester(semester);
            scoreBean.setCollege(courseService.ShowByCno(scBean.getCno()).getCollege());
            scoreBean.setCtype(courseService.ShowByCno(scBean.getCno()).getCtype());
            scoreBean.setCno(scBean.getCno());
            scoreBean.setCname(courseService.ShowByCno(scBean.getCno()).getCname());
            scoreBean.setTname(teacherService.Show(tno).getTname());
            scoreBean.setCredit(courseService.ShowByCno(scBean.getCno()).getCredit());
            scoreBean.setScoreway(courseService.ShowByCno(scBean.getCno()).getScoreway());
            scoreBean.setRatio(courseService.ShowByCno(scBean.getCno()).getRatio());
            scoreBean.setScore(scBean.getScore());
            scoreBean.setGradepoint(scBean.getGradepoint());
            scoreBeans.add(scoreBean);
        }
        return scoreBeans;
    }

    @Override
    public List<SCBean> FindCno(String sno) {
        return scDao.findCno(sno);
    }

    @Override
    public Map<String, Object> Avg_Score_Stu(String sno) {

        Map<String, Object> map = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        float sum_credit = 0;
        String avg_score;
        double sum_gradepoint_credit = 0;
        double s = 0;
        double avg_gradepoint_credit = 0;

        List<SCBean> scBeans = FindCno(sno);
        for (SCBean scBean : scBeans) {
            String credit = courseService.ShowByCno(scBean.getCno()).getCredit();
            sum_credit = sum_credit + Float.parseFloat(credit);
        }
        avg_score = scDao.avg_score_stu(sno);
        if (avg_score == null) {
            avg_score = "0";
        }
        for (SCBean scBean : scBeans) {
            s = scBean.getGradepoint() * Double.parseDouble(courseService.ShowByCno(scBean.getCno()).getCredit());
            sum_gradepoint_credit = sum_gradepoint_credit + s;
        }
        if (sum_credit != 0) {
            avg_gradepoint_credit = sum_gradepoint_credit / sum_credit;
        } else {
            avg_gradepoint_credit = 0;
        }


        String sum_credit_s = decimalFormat.format(sum_credit);
        String avg_score_s = decimalFormat.format(Float.parseFloat(avg_score));
        String avg_gradepoint_credit_s = decimalFormat.format(avg_gradepoint_credit);
        map.put("sum_credit", sum_credit_s);
        map.put("avg_score", avg_score_s);
        map.put("avg_gradepoint_credit", avg_gradepoint_credit_s);
        return map;
    }

    @Override
    public String Count_num_90(String cno, String semester) {
        return scDao.count_num_90(cno, semester);
    }

    @Override
    public String Count_num_80(String cno, String semester) {
        return scDao.count_num_80(cno, semester);
    }

    @Override
    public String Count_num_70(String cno, String semester) {
        return scDao.count_num_70(cno, semester);
    }

    @Override
    public String Count_num_60(String cno, String semester) {
        return scDao.count_num_60(cno, semester);
    }

    @Override
    public String Count_num_59(String cno, String semester) {
        return scDao.count_num_59(cno, semester);
    }


}
