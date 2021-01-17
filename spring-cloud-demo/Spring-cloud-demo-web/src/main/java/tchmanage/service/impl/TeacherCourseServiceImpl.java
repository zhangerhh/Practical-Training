package tchmanage.service.impl;


import com.google.inject.internal.cglib.proxy.$Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.*;
import tchmanage.dao.TeacherCourseDao;
import tchmanage.service.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
    @Autowired
    TeacherCourseDao teacherCourseDao;

    @Autowired
    SCService scService;

    @Autowired
    StudentArchivesService studentArchivesService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassesCourseService classesCourseService;



    @Override
    public Map<String, Object> ShowAllBy(String tno, String cno_, String classno_) {
        Map<String, Object> map = new HashMap<>();
        List<ScoreBean> scoreBeans = new ArrayList<>();
        String semester;
        DecimalFormat df = new DecimalFormat("0.00");

        List<TeacherCourseBean> teacherCourseBeans = teacherCourseDao.showallby(tno,cno_,classno_);

        TeacherBean teacherBean = teacherService.Show(tno);
        for(TeacherCourseBean teacherCourseBean: teacherCourseBeans){
            ScoreBean scoreBean = new ScoreBean();
            String cno = teacherCourseBean.getCno();
            String classno = teacherCourseBean.getClassno();
            scoreBean.setClassno(classno);

            CourseBean courseBean = courseService.ShowByCno(cno);
            ClassesCourseBean classesCourseBean = classesCourseService.ShowByScore(classno,cno);

            scoreBean.setCollege(courseBean.getCollege());
            scoreBean.setCtype(courseBean.getCtype());
            scoreBean.setCno(courseBean.getCno());
            scoreBean.setCname(courseBean.getCname());
            scoreBean.setCredit(courseBean.getCredit());
            scoreBean.setScoreway(courseBean.getScoreway());
            scoreBean.setRatio(courseBean.getRatio());

            semester = classesCourseBean.getSemester();
            scoreBean.setSemester(semester);
            scoreBean.setStage(classesCourseBean.getStage());

            scoreBean.setTname(teacherBean.getTname());

            if(studentArchivesService.StuNumByClassno(classno) != null){
                scoreBean.setNum(studentArchivesService.StuNumByClassno(classno));
            }else {
                scoreBean.setNum("0");
            }

            if(scService.Count_passNum(cno, semester) != null){
                scoreBean.setPass_num(scService.Count_passNum(cno,semester));
            }else {
                scoreBean.setPass_num("0");
            }

            if(scService.Count_nopassNum(cno, semester) != null){
                scoreBean.setNopass_num(scService.Count_nopassNum(cno,semester));
            }else {
                scoreBean.setNopass_num("0");
            }

            if (scService.Count_Num(cno, semester) != null){
                scoreBean.setEnter_num(scService.Count_Num(cno, semester));
            }else{
                scoreBean.setEnter_num("0");
            }

            if(scService.Count_Num(cno, semester) != null && scService.Count_passNum(cno, semester) != null){
                scoreBean.setPass_rate(df.format((float)Integer.parseInt(scService.Count_passNum(cno, semester))/Integer.parseInt(scService.Count_Num(cno, semester))));
            }else {
                scoreBean.setPass_rate("0");
            }

            if(scService.Avg_score(cno,semester) != null){
                scoreBean.setAvg_score(df.format(Float.parseFloat(scService.Avg_score(cno,semester))));
            }else {
                scoreBean.setAvg_score("0");
            }

            scoreBeans.add(scoreBean);
        }
        map.put("data",scoreBeans);
        return map;
    }

    @Override
    public String FindTno(String cno, String classno) {
        return teacherCourseDao.findTno(cno, classno);
    }

    @Override
    public ArrayList<FindCourseBean> findWeekCourse(String tno, String semester, int week) {
        return teacherCourseDao.findWeekCourse(tno,semester,week);
    }

    @Override
    public ArrayList<ManagementClassBean> mgClass(String tno) {
        return teacherCourseDao.mgClass(tno);
    }

    @Override
    public String findTname(String tno) {
        return teacherCourseDao.findTname(tno);
    }

    @Override
    public int ttk_Apply(String no, String semester, String college, String tname, String tno, String type, String reason,String status,String cno,String reason1) {
        return teacherCourseDao.ttk_Apply(no,semester,college,tname,tno,type,reason,status,cno,reason1);
    }

    @Override
    public int classroom_Apply(String no, String semester, String college, String tno, String tname, String classno, String type, String reason,String status) {
        return teacherCourseDao.classroom_Apply(no,semester,college,tno,tname,classno,type,reason,status);
    }



    @Override
    public int ttk_status(String tno, String cno) {
        return teacherCourseDao.ttk_status(tno, cno);
    }




}
