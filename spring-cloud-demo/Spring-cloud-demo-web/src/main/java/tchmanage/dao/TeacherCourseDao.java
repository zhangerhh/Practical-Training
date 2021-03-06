package tchmanage.dao;

import org.springframework.stereotype.Component;
import tchmanage.bean.FindCourseBean;
import tchmanage.bean.ManagementClassBean;
import tchmanage.bean.TeacherCourseBean;

import java.util.ArrayList;
import java.util.List;

@Component
public interface TeacherCourseDao {

    List<TeacherCourseBean> showallby(String tno, String cno, String classno);

    String findTno(String cno, String classno);

    //查看教师周课表
    ArrayList<FindCourseBean> findWeekCourse(String tno, String semester, int week);
    //调停课管理
    ArrayList<ManagementClassBean> mgClass(String tno);

    //通过教师编号查找教师姓名
    String findTname(String tno);
    //教师调停课申请
    int ttk_Apply(String no, String semester, String college, String tname, String tno, String type, String reason, String status, String cno, String reason1);
    //修改调停课状态
    int ttk_status(String tno, String cno);
    //教师教室申请
    int classroom_Apply(String no, String semester, String college, String tno, String tname, String classno, String type, String reason, String status);

}
