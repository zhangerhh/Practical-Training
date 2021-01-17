package tchmanage.dao;


import org.springframework.stereotype.Component;
import tchmanage.bean.TeacherBean;

@Component
public interface TeacherDao {
    TeacherBean show(String tno);
}
