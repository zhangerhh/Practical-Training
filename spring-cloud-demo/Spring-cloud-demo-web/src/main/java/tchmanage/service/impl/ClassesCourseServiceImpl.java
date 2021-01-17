package tchmanage.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.ClassesCourseBean;
import tchmanage.dao.ClassesCourseDao;
import tchmanage.service.ClassesCourseService;

import java.util.List;

@Service
public class ClassesCourseServiceImpl implements ClassesCourseService {
    @Autowired
    ClassesCourseDao classesCourseDao;

    @Override
    public List<ClassesCourseBean> Show(ClassesCourseBean classesCourseBean) {
        String classno = classesCourseBean.getClassno();
        String semester = classesCourseBean.getSemester();
        return classesCourseDao.show(classno,semester);
    }

    @Override
    public ClassesCourseBean ShowByScore(String classno, String cno) {
        return classesCourseDao.showByScore(classno, cno);
    }

    @Override
    public int Update(String classno, String cno, String semester, String stage) {
        return classesCourseDao.update(classno, cno, semester, stage);
    }

    @Override
    public int Add(String classno, String cno, String semester, String stage) {
        return classesCourseDao.add(classno, cno, semester, stage);
    }

    @Override
    public int Delete(String classno, String cno, String semester) {
        return classesCourseDao.delete(classno, cno, semester);
    }

    @Override
    public int DeleteByCourse(String cno) {
        return classesCourseDao.deleteByCourse(cno);
    }
}
