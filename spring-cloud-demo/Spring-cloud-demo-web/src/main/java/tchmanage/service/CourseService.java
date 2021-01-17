package tchmanage.service;

import tchmanage.bean.CourseBean;

import java.util.List;

public interface CourseService {
    List<CourseBean> ShowByCourse(String college);
    int AddByCourse(String cno,String cname,String college,String ctype,String credit,String scoreway,String ratio,String dscb,String source,String class_hours,int begin_week,int end_week);
    int UpdateByCourse(String cno,String cname,String college,String ctype,String credit,String scoreway,String ratio,String dscb,String source,String class_hours,int begin_week,int end_week);
    int DeleteByCourse(String cno);
    CourseBean ShowByCno(String cno);
    int Update_Ratio(String cno, String ratio);


}
