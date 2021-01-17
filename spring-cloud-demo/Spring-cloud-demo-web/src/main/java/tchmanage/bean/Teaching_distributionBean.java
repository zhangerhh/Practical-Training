package tchmanage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teaching_distributionBean implements Serializable {
    private String tno;                     //教职工号
    private String tname;                   //姓名
    private String college;                 //学院
    private String remarks;                 //备注

}
