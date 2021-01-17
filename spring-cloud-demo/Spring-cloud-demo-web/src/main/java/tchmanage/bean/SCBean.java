package tchmanage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SCBean implements Serializable {
    private String sno;
    private String cno;
    private String pscore;
    private String qscore;
    private Integer score;
    private String semester;
    private double gradepoint;
}
