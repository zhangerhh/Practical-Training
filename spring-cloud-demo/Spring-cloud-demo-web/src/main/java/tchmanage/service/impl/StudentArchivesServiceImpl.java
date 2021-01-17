package tchmanage.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.MajorBean;
import tchmanage.bean.SCBean;
import tchmanage.bean.Stu_ScoreBean;
import tchmanage.bean.StudentArchivesBean;
import tchmanage.dao.StudentArchivesDao;
import tchmanage.service.SCService;
import tchmanage.service.StudentArchivesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentArchivesServiceImpl implements StudentArchivesService {
    @Autowired
    StudentArchivesDao studentArchivesDao;

    @Autowired
    SCService scService;

    @Autowired
    StudentArchivesService studentArchivesService;

    @Override
    public String StuNumByClassno(String classno) {
        return studentArchivesDao.stuNumByClassno(classno);
    }

    @Override
    public Map<String, Object> ShowStuByClassno(String classno,String cno,String stage) {
        Map<String, Object> map = new HashMap<>();
        List<Stu_ScoreBean> stu_scoreBeans = new ArrayList<>();
        List<StudentArchivesBean> studentArchivesBeans = studentArchivesDao.showStuByClassno(classno);
        if (stage.equals("待录入")){
            for (StudentArchivesBean studentArchivesBean: studentArchivesBeans){
                Stu_ScoreBean stu_scoreBean = new Stu_ScoreBean();
                stu_scoreBean.setSno(studentArchivesBean.getSno());
                stu_scoreBean.setName(studentArchivesBean.getName());
                stu_scoreBean.setGrade(studentArchivesBean.getGrade());
                stu_scoreBean.setCollege(studentArchivesBean.getCollege());
                stu_scoreBean.setMajor(studentArchivesBean.getMajor());
                stu_scoreBean.setClassno(studentArchivesBean.getClassno());

                stu_scoreBean.setPscore("");
                stu_scoreBean.setQscore("");


                stu_scoreBeans.add(stu_scoreBean);
            }
        }else {
            for (StudentArchivesBean studentArchivesBean: studentArchivesBeans){
                Stu_ScoreBean stu_scoreBean = new Stu_ScoreBean();
                SCBean scBean = scService.Show(studentArchivesBean.getSno(),cno);

                stu_scoreBean.setSno(studentArchivesBean.getSno());
                stu_scoreBean.setName(studentArchivesBean.getName());
                stu_scoreBean.setGrade(studentArchivesBean.getGrade());
                stu_scoreBean.setCollege(studentArchivesBean.getCollege());
                stu_scoreBean.setMajor(studentArchivesBean.getMajor());
                stu_scoreBean.setClassno(studentArchivesBean.getClassno());

                stu_scoreBean.setPscore(scBean.getPscore());
                stu_scoreBean.setQscore(scBean.getQscore());
                stu_scoreBean.setScore(scBean.getScore());

                stu_scoreBeans.add(stu_scoreBean);
            }
        }

        map.put("data",stu_scoreBeans);
        return map;
    }

    @Override
    public String FindClassnoBysno(String sno) {
        return studentArchivesDao.findClassnoBysno(sno);
    }

    @Override
    public void insert(String college, String grade, String classno, String sno, String name, String sex, String pnum, String mail, String Political_outlook, String major) {
        studentArchivesDao.insert(college, grade, classno, sno, name, sex, pnum, mail, Political_outlook, major);
    }

    @Override
    public void update(String college, String grade, String classno, String sno, String name, String sex, String pnum, String mail, String Political_outlook, String major) {
        studentArchivesDao.update(college, grade, classno, sno, name, sex, pnum, mail, Political_outlook, major);
    }

    @Override
    public void delete(String sno) {
        studentArchivesDao.delete(sno);
    }


    @Override
    public ArrayList<StudentArchivesBean> getStudent(String sno, String college) {
        return studentArchivesDao.getStudent(sno, college);
    }

    @Override
    public ArrayList<StudentArchivesBean> getcollege() {
        return studentArchivesDao.getcollege();
    }

    @Override
    public ArrayList<MajorBean> showmajor(String college) {
        return studentArchivesDao.showmajor(college);
    }

    @Override
    public String adminfindclasson(String college, String grade, String major) {
        return studentArchivesDao.adminfindclasson(college,grade,major);
    }
}
