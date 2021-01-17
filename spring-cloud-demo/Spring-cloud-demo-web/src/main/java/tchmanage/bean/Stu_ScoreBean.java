package tchmanage.bean;
import lombok.*;

import java.io.Serializable;

@Data
public class Stu_ScoreBean implements Serializable {
    private String sno;
    private String name;
    private String grade;
    private String college;
    private String major;
    private String classno;
    private String pscore;
    private String qscore;
    private Integer score;

}
