package tchmanage.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.CourseBean;
import tchmanage.dao.CourseDao;
import tchmanage.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Override
    public List<CourseBean> ShowByCourse(String college) {
        return courseDao.showByCourse(college);
    }

    @Override
    public int AddByCourse(String cno,String cname,String college,String ctype,String credit,String scoreway,
                           String ratio,String dscb,String source,String class_hours,int begin_week,int end_week){
        return courseDao.addByCourse(cno,cname,college,ctype,credit,scoreway,ratio,dscb,source,class_hours,begin_week,end_week);
    }

    @Override
    public int UpdateByCourse(String cno, String cname, String college, String ctype, String credit, String scoreway, String ratio, String dscb,String source,String class_hours,int begin_week,int end_week) {
        return courseDao.modifyByCourse(cno,cname,college,ctype,credit,scoreway,ratio,dscb,source,class_hours,begin_week,end_week);
    }

    @Override
    public int DeleteByCourse(String cno) {
        return courseDao.deleteByCourse(cno);
    }

    @Override
    public CourseBean ShowByCno(String cno) {
        return courseDao.showByCno(cno);
    }

    @Override
    public int Update_Ratio(String cno, String ratio) {
        return courseDao.update_Ratio(cno, ratio);
    }


}
