package tchmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tchmanage.bean.CourseBean;

import java.util.List;

@Component
public interface CourseDao {
    List<CourseBean> showByCourse(String college);
    int addByCourse(@Param("cno")String cno, @Param("cname")String cname, @Param("college")String college, @Param("ctype")String ctype, @Param("credit")String credit, @Param("scoreway")String scoreway, @Param("ratio")String ratio, @Param("dscb")String dscb, @Param("source")String source, @Param("class_hours")String class_hours, @Param("begin_week")int begin_week, @Param("end_week")int end_week);
    int modifyByCourse(@Param("cno")String cno, @Param("cname")String cname, @Param("college")String college, @Param("ctype")String ctype, @Param("credit")String credit, @Param("scoreway")String scoreway, @Param("ratio")String ratio, @Param("dscb")String dscb, @Param("source")String source, @Param("class_hours")String class_hours, @Param("begin_week")int begin_week, @Param("end_week")int end_week);
    int deleteByCourse(String cno);
    CourseBean showByCno(String cno);
    int update_Ratio(String cno, String ratio);

}
