package tchmanage.controller.admin;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tchmanage.bean.Teaching_distributionBean;
import tchmanage.bean.Teaching_distribution_informationBean;
import tchmanage.service.Teaching_distributionService;

import java.util.*;


//进入教学分配主页，显示所有的教师信息，同时可按教职工号或学院名查找教师档案信息
@CrossOrigin
@RestController
public class Teaching_distributionController {
    @Autowired
    Teaching_distributionService teaching_distributionService;


    //查询所有的教师名单
    @ResponseBody
    @RequestMapping(value = "/FindByStaffOrCollegeController",method = RequestMethod.POST)
    public Map<String, ArrayList> getTeacher_list(@RequestBody Map<String,String>data){
        Map<String,ArrayList> map = new HashMap(16);
        String college = data.get("college");
        String tno = data.get("tno");
        try {
            ArrayList<Teaching_distributionBean> list = teaching_distributionService.getbystafforcollege(tno,college);
            map.put("FindByStaffOrCollegeController",list);
            return map;
        }catch (Exception e){
            return map;
        }
    }


    /**
    * 在教学分配主页选中一个教师信息点击查看，
    * 进入该教师的任务分配查看界面，
    * 进入的同时要传入该教师的教职工号用以查找该教师的教学任务，
    * 进入后可看到该教师的所有教学任务，
    * 若要进行筛选，可选中筛选条件后将该条件和教职工号一起传给后端，
    * 可实现按条件查询，多个条件可同时进行
    */
    @ResponseBody
    @RequestMapping(value = "/FindByConditionController",method = RequestMethod.POST)
    public Map<String, ArrayList> getTeacher_task(@RequestBody Map<String,String>data ){
        Map<String,ArrayList> map = new HashMap(16);
        String  tno = data.get("tno");
        String  college = data.get("college");
        String  grade = data.get("grade");
        String  classno = data.get("classno");
        String  semester = data.get("semester");
        try {
            ArrayList<Teaching_distribution_informationBean> list = teaching_distributionService.getcoursebycondition(tno,college,grade,classno,semester);
            map.put("FindByConditionController",list);
            return map;
        }catch (Exception e){
            return map;
        }
    }

    //增加选中教师的教学任务
    @ResponseBody
    @RequestMapping(value = "/InsertinformationController", method = RequestMethod.POST)
    public int addTeacher_task(@RequestBody Map<String,String>data) {
        String tno = data.get("tno");
        String cno = data.get("cno");
        String classno = data.get("classno");
        String site = data.get("site");
        String week = data.get("week");
        String dj = data.get("dj");
        try {
            teaching_distributionService.insert(tno,cno,site,week,dj,"正常",classno);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    //删除选中教师的教学任务
    @ResponseBody
    @RequestMapping(value = "/DeleteinformationController", method = RequestMethod.POST)
    public int deleteTeacher_task(@RequestBody Map<String,String>data) throws Exception{
        String tno = data.get("tno");
        String cno = data.get("cno");
        try {
            teaching_distributionService.delete(tno,cno);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }


    //增加老师教学任务时，需列出所有的教学任务
    @ResponseBody
    @RequestMapping(value = "/GetAllNotChooseController",method = RequestMethod.POST)
    public Map<String, ArrayList> getNoTeacher_task(@RequestBody Map<String,String>data){
        Map<String,ArrayList> map = new HashMap(16);
        String  college = data.get("college");
        String  grade = data.get("grade");
        String  classno = data.get("classno");
        String  semester = data.get("semester");
        try {
            map.put("GetAllNotChooseController",teaching_distributionService.getbynotchoose(college,grade,classno,semester));
            return map;
        }catch (Exception e){
            return map;
        }
    }


    @RequestMapping(value = "/GetAllNotChoosetimeController",method = RequestMethod.POST)
    public Map<String,ArrayList> selection(@RequestBody Map<String,String>data){
        Map<String,ArrayList> map = new HashMap(16);
        String site = data.get("site");
        map.put("time",teaching_distributionService.getalltime(site));
        return map;
    }
}
