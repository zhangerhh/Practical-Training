package tchmanage.controller.teachers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tchmanage.service.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Score_TeacherController {
    @Autowired
    TeacherCourseService teacherCourseService;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassesCourseService classesCourseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentArchivesService studentArchivesService;

    @Autowired
    SCService scService;

    //展示该老师可以录成绩的所有课
    @ResponseBody
    @RequestMapping(value = "/score/show", method = RequestMethod.POST)
    public Map<String, Object> Show(@RequestBody Map<String, Object> data){
        System.out.println(2);
        String tno = (String) data.get("tno");
        String cno_ = (String) data.get("cno");
        String classno_ = (String) data.get("classno");

        return teacherCourseService.ShowAllBy(tno,cno_,classno_);
    }

    //展示选中课程的所有学生
    @ResponseBody
    @RequestMapping(value = "/score/showstu", method = RequestMethod.POST)
    public Map<String, Object> ShowStu(@RequestBody Map<String, Object> data){
        System.out.println(2);
        String cno = (String) data.get("cno");
        String classno = (String) data.get("classno");
        String stage = (String) data.get("stage");

        return studentArchivesService.ShowStuByClassno(classno,cno,stage);
    }

    //为学生录入成绩
    @ResponseBody
    @RequestMapping(value = "/score/add", method = RequestMethod.POST)
    public Map<String, Object> AddStuScore(@RequestBody Map<String, Object> data){
        List<Map<String, Object>> stu_scoreBeans = (List<Map<String, Object>>) data.get("Stu_Score");
        String semester = (String) data.get("semester");
        String classno = (String) data.get("classno");
        String cno = (String) data.get("cno");
        String stage = (String) data.get("stage");
        String ratio = (String) data.get("ratio");

        return scService.Add(stu_scoreBeans,semester,classno,cno,stage,ratio);
    }

    //修改学生成绩
    @ResponseBody
    @RequestMapping(value = "/score/modify", method = RequestMethod.POST)
    public Map<String, Object> ModifyStuScore(@RequestBody Map<String, Object> data){
        List<Map<String, Object>> stu_scoreBeans = (List<Map<String, Object>>) data.get("Stu_Score");
        String semester = (String) data.get("semester");
        String cno = (String) data.get("cno");
        String ratio = (String) data.get("ratio");

        return scService.Modify(stu_scoreBeans,semester,cno,ratio);
    }



    //成绩分析

    @ResponseBody
    @RequestMapping(value = "/score/analysis", method = RequestMethod.POST)
    public Map<String, Object> Analysis(@RequestBody Map<String, Object> data){
        Map<String, Object> map = new HashMap<>();
        DecimalFormat df = new DecimalFormat("0.00");
        List<String> list = new ArrayList<>();
        String num_total;
        String num_input;
        String score_avg;
        String num_pass;
        String num_nopass;
        String ratio_pass;
        String num_1;
        String num_2;
        String num_3;
        String num_4;
        String num_5;

        String cno = (String) data.get("cno");
        String classno = (String) data.get("classno");
        String semester = (String) data.get("semester");

        //班级总人数
        if(studentArchivesService.StuNumByClassno(classno) != null){
            num_total = studentArchivesService.StuNumByClassno(classno);
        }else {
           num_total = "0";
        }

        //及格人数
        if(scService.Count_passNum(cno, semester) != null){
            num_pass = scService.Count_passNum(cno,semester);
        }else {
            num_pass = "0";
        }

        //不及格人数
        if(scService.Count_nopassNum(cno, semester) != null){
            num_nopass = scService.Count_nopassNum(cno,semester);
        }else {
            num_nopass = "0";
        }

        //已录入人数
        if (scService.Count_Num(cno, semester) != null){
            num_input = scService.Count_Num(cno, semester);
        }else{
            num_input = "0";
        }

        //及格率
        if(scService.Count_Num(cno, semester) != null && scService.Count_passNum(cno, semester) != null){
            ratio_pass = df.format((float)Integer.parseInt(scService.Count_passNum(cno, semester))/Integer.parseInt(scService.Count_Num(cno, semester)));
        }else {
            ratio_pass = "0";
        }

        //平均分
        if(scService.Avg_score(cno,semester) != null){
            score_avg = df.format(Float.parseFloat(scService.Avg_score(cno,semester)));
        }else {
            score_avg = "0";
        }

        //90
        if (scService.Count_num_90(cno,semester)!= null){
            num_1 = scService.Count_num_90(cno,semester);
        }else {
            num_1 = "0";
        }

        //80
        if (scService.Count_num_80(cno,semester)!= null){
            num_2 = scService.Count_num_80(cno,semester);
        }else {
            num_2 = "0";
        }

        //70
        if (scService.Count_num_70(cno,semester)!= null){
            num_3 = scService.Count_num_70(cno,semester);
        }else {
            num_3 = "0";
        }

        //60
        if (scService.Count_num_60(cno,semester)!= null){
            num_4 = scService.Count_num_60(cno,semester);
        }else {
            num_4 = "0";
        }

        //60以下
        if (scService.Count_num_59(cno,semester)!= null){
            num_5 = scService.Count_num_59(cno,semester);
        }else {
            num_5 = "0";
        }

        list.add(num_total);
        list.add(num_input);
        list.add(score_avg);
        list.add(num_pass);
        list.add(num_nopass);
        list.add(ratio_pass);
        list.add(num_1);
        list.add(num_2);
        list.add(num_3);
        list.add(num_4);
        list.add(num_5);
        map.put("data",list);
        return map;
    }
}
