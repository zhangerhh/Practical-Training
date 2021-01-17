package tchmanage.service;



import tchmanage.bean.ClassesCourseBean;

import java.util.List;

public interface ClassesCourseService {
    List<ClassesCourseBean> Show(ClassesCourseBean classesCourseBean);

    ClassesCourseBean ShowByScore(String classno, String cno);

    int Update (String classno,String cno,String semester,String stage);

    int Add (String classno,String cno,String semester,String stage);

    int Delete(String classno,String cno,String semester);

    int DeleteByCourse(String cno);
}
