package tchmanage.bean;
import lombok.*;

import java.io.Serializable;

@Data
public class ClassesCourseBean implements Serializable {
    private String classno;
    private String cno;
    private String semester;
    private String stage;

}
