package tchmanage.service;



import tchmanage.bean.MajorBean;
import tchmanage.bean.StudentArchivesBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentArchivesService {
    String StuNumByClassno(String classno);

    Map<String, Object> ShowStuByClassno(String classno,String cno,String stage);

    String FindClassnoBysno(String sno);

    //增加学生档案
    void insert(String college, String grade, String classno, String sno, String name, String sex, String pnum, String mail, String Political_outlook, String major);
    //修改学生档案
    void update(String college, String grade, String classno, String sno, String name, String sex, String pnum, String mail, String Political_outlook, String major);
    //删除学生档案
    void delete(String Student_number);
    //查询学生档案(可通过学院名以及学号进行查询)
    ArrayList<StudentArchivesBean> getStudent(String sno, String college);
    //显示所有的学院
    ArrayList<StudentArchivesBean> getcollege();
    //通过学院名显示所有专业
    //通过学院显示出学院的专业
    ArrayList<MajorBean> showmajor(String college);
    //根据学院年级专业查询班级编号
    String adminfindclasson(String college,String grade,String major);
}
