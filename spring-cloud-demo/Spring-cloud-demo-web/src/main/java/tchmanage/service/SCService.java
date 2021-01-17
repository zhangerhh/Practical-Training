package tchmanage.service;



import tchmanage.bean.SCBean;
import tchmanage.bean.ScoreBean;

import java.util.List;
import java.util.Map;

public interface SCService {
    String Count_passNum(String cno, String semester);

    String Count_nopassNum(String cno, String semester);

    String Avg_score(String cno, String semester);

    SCBean Show(String sno, String cno);

    Map<String, Object>  Add(List<Map<String, Object>> stu_scoreBeans, String semester, String classno,  String cno, String stage, String ratio);

    Map<String, Object> Modify(List<Map<String, Object>> stu_scoreBeans , String semester, String cno,  String ratio);

    String Count_Num(String cno, String semester);

    List<ScoreBean> FindCnoBySno(String sno, String semester);

    List<SCBean> FindCno(String sno);

    Map<String, Object> Avg_Score_Stu(String sno);
    //统计100-90分人数
    String Count_num_90(String cno, String semester);
    //统计89-80分人数
    String Count_num_80(String cno, String semester);
    //统计79-70分人数
    String Count_num_70(String cno, String semester);
    //统计69-60分人数
    String Count_num_60(String cno, String semester);
    //统计60分以下人数
    String Count_num_59(String cno, String semester);



}
