package tchmanage.bean;
import lombok.*;

import java.io.Serializable;

@Data
public class FindCourseBean implements Serializable {
    private String cname;
    private String tname;
    private String site;
    private String week;
    private String dj;

}
