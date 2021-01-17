package tchmanage.bean;

import lombok.*;

import java.io.Serializable;

@Data
public class StudentArchivesBean implements Serializable {
    private String college;          //学院
    private String grade;            //年级
    private String classno;     //班级编号
    private String sno;   //学号
    private String name;             //姓名
    private String sex;              //性别
    private String pnum;        //联系电话
    private String mail;         //电子邮箱
    private String Political_outlook;//政治面貌
    private String major;            //专业

}
