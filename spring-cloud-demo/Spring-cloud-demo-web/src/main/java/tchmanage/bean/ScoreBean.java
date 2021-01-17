package tchmanage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScoreBean implements Serializable {
    private String semester;
    private String college;
    private String ctype;
    private String cno;
    private String cname;
    private String tname;
    private String classno;
    private String credit;
    private String num;
    private String enter_num;
    private String scoreway;
    private String ratio;
    private String stage;
    private String pass_rate;
    private String nopass_num;
    private String pass_num;
    private String avg_score;
    private Integer score;
    private Double gradepoint;
}
