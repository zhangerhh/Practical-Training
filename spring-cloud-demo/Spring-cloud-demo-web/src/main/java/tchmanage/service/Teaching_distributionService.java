package tchmanage.service;




import tchmanage.bean.TeacherCourseBean;
import tchmanage.bean.Teaching_distributionBean;
import tchmanage.bean.Teaching_distribution_informationBean;

import java.util.ArrayList;

public interface Teaching_distributionService {
    //按教职工号或学号查找
    ArrayList<Teaching_distributionBean> getbystafforcollege(String tno, String college);
    //按条件查询选中的课程
    ArrayList<Teaching_distribution_informationBean> getcoursebycondition(String tno, String college, String grade, String classno, String semester);
    //显示所有的年级
    ArrayList<Teaching_distribution_informationBean> getgrade();
    //显示所有班级
    ArrayList<Teaching_distribution_informationBean> getclassno();
    //显示所有的学期
    ArrayList<Teaching_distribution_informationBean> getsemester();
    //删除老师教学分配信息
    int delete(String tno, String cno);
    //增加老师教学分配信息
    int insert(String tno, String cno, String site, String week, String dj, String status, String classno);
    //显示所有可选的课程
    ArrayList<Teaching_distribution_informationBean> getbynotchoose(String college, String grade, String classno, String semester);
    //显示已经被选择的课程
    ArrayList<TeacherCourseBean> getbychoose();
    //在给老师分派教学任务时根据地点获取所有能选择的上课时间
    ArrayList<Teaching_distribution_informationBean> getchoosedtime(String site);
    ArrayList<Teaching_distribution_informationBean> getalltime(String site);

    int DeleteByCourse(String cno);
}
