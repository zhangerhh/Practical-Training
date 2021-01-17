package tchmanage.dao;


import org.springframework.stereotype.Component;
import tchmanage.bean.ClassesCourseBean;

import java.util.List;

@Component
public interface ClassesCourseDao {
    List<ClassesCourseBean> show(String classno, String semester);

    ClassesCourseBean showByScore(String classno, String cno);

    int update (String classno,String cno,String semester,String stage);

    int add (String classno,String cno,String semester,String stage);

    int delete(String classno,String cno,String semester);

    int deleteByCourse(String cno);
}
