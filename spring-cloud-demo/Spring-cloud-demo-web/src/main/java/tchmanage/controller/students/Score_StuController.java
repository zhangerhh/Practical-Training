package tchmanage.controller.students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tchmanage.bean.SCBean;
import tchmanage.service.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Score_StuController {
    @Autowired
    SCService scService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentArchivesService studentArchivesService;

    @Autowired
    TeacherCourseService teacherCourseService;

    @Autowired
    TeacherService teacherService;


    //展示学生课程成绩
    @ResponseBody
    @RequestMapping(value = "/score_stu/show", method = RequestMethod.POST)
    public Map<String, Object> Show(@RequestBody Map<String, Object> data) {
        System.out.println(2);
        Map<String, Object> map = new HashMap<>();
        String sno = (String) data.get("sno");
        String semester = (String) data.get("semester");
        map.put("data", scService.FindCnoBySno(sno, semester));
        return map;
    }

    //学生首页
    @ResponseBody
    @RequestMapping(value = "/score_stu/showall", method = RequestMethod.POST)
    public Map<String, Object> ShowAll(@RequestBody Map<String, Object> data) {
        System.out.println(2);
        String sno = (String) data.get("sno");
        return scService.Avg_Score_Stu(sno);
    }
}


