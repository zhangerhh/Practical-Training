package tchmanage.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.TeacherBean;
import tchmanage.dao.TeacherDao;
import tchmanage.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public TeacherBean Show(String tno) {
        return teacherDao.show(tno);
    }
}
