package tchmanage.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tchmanage.bean.TeacherCourseBean;
import tchmanage.bean.Teaching_distributionBean;
import tchmanage.bean.Teaching_distribution_informationBean;
import tchmanage.dao.Teaching_distributionDao;
import tchmanage.service.Teaching_distributionService;

import java.util.ArrayList;

@Service
public class Teaching_distributionServiceImpl implements Teaching_distributionService {
    //将DAO注入Service层
    @Autowired
    private Teaching_distributionDao teachingDistributionDao;

    @Override
    public ArrayList<Teaching_distributionBean> getbystafforcollege(String tno, String college) {
        return teachingDistributionDao.getbystafforcollege(tno,college);
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getcoursebycondition(String tno, String college, String grade, String classno, String semester) {
        return teachingDistributionDao.getcoursebycondition(tno,college,grade,classno,semester);
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getgrade() {
        return teachingDistributionDao.getgrade();
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getclassno() {
        return teachingDistributionDao.getclassno();
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getsemester() {
        return teachingDistributionDao.getsemester();
    }

    @Override
    public int delete(String tno, String cno) {
        return teachingDistributionDao.delete(tno,cno);
    }

    @Override
    public int insert(String tno, String cno, String site, String week, String dj, String status,String classno) {
        return teachingDistributionDao.insert(tno,cno,site,week,dj,status,classno);
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getbynotchoose(String college, String grade, String classno, String semester) {
        ArrayList<Teaching_distribution_informationBean> list =  teachingDistributionDao.getbynotchoose(college,grade,classno,semester);
        ArrayList<TeacherCourseBean> list1 = getbychoose();
        ArrayList<Teaching_distribution_informationBean> list2 = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            for (int j = 0;j<list1.size();j++){
                if (list.get(i).getClassno().equals(list1.get(j).getClassno()) && list.get(i).getCno().equals(list1.get(j).getCno())) {
                    list.remove(i);
                    i=-1;
                    break;
                }
            }
        }
        return list;
    }

    @Override
    public ArrayList<TeacherCourseBean> getbychoose() {
        return teachingDistributionDao.getbychoose();
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getchoosedtime(String site) {
        return teachingDistributionDao.getchoosedtime(site);
    }

    @Override
    public ArrayList<Teaching_distribution_informationBean> getalltime(String site) {
        ArrayList<Teaching_distribution_informationBean> list1 = teachingDistributionDao.getalltime();
        ArrayList<Teaching_distribution_informationBean> list = getchoosedtime(site);
        for (int i = 0;i<list1.size();i++){
            for (int j = 0;j<list.size();j++){
                if (list.get(j).getWeek().equals(list1.get(i).getWeek()) && list.get(j).getDj().equals(list1.get(i).getDj())) {
                    list1.remove(i);
                    i=-1;
                    break;
                }
            }
        }
        return list1;
    }

    @Override
    public int DeleteByCourse(String cno) {
        return teachingDistributionDao.deleteByCourse(cno);
    }

}
