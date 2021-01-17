package tchmanage.bean;

import java.io.Serializable;
import lombok.*;

@Data
public class TeacherCourseBean implements Serializable {
    private String tno;
    private String cno;
    private String site;
    private String week;
    private String dj;
    private String status;
    private String classno;


}
