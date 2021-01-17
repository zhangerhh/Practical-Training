package tchmanage.bean;

import lombok.Data;

import java.io.Serializable;


@Data
public class Teaching_distribution_informationBean implements Serializable {
    private String college;         //学院
    private String ctype;           //课程类别
    private String cno;             //课程代码
    private String cname;           //课程姓名
    private String classno;         //教学班
    private String tname;           //行课教师
    private String credit;          //学分
    private String scoreway;        //计分方式
    private String ratio;           //卷面比例
    private String site;            //上课地点
    private String week;            //上课时间1
    private String dj;              //上课时间2
    private String grade;           //年级
    private String semester;        //学期
}
