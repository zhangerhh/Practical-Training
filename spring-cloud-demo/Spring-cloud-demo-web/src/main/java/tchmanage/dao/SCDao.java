package tchmanage.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tchmanage.bean.SCBean;

import java.util.List;

@Component
public interface SCDao {
    String count_passNum(String cno, String semester);

    String count_nopassNum(String cno, String semester);

    String avg_score(String cno, String semester);

    SCBean show(String sno, String cno);

    int add(@Param("sno")String sno, @Param("cno")String cno, @Param("pscore")String pscore,@Param("qscore") String qscore, @Param("score")Integer score, @Param("gradepoint")Double gradepoint,@Param("semester") String semester);

    int modify(@Param("sno")String sno, @Param("cno")String cno, @Param("pscore")String pscore,@Param("qscore") String qscore, @Param("score")Integer score, @Param("gradepoint")Double gradepoint,@Param("semester") String semester);

    String Count_Num(String cno, String semester);

    List<SCBean> findCnoBySno(String sno, String semester);

    List<SCBean> findCno(String sno);

    String avg_score_stu(String sno);

    //统计100-90分人数
    String count_num_90(String cno, String semester);
    //统计89-80分人数
    String count_num_80(String cno, String semester);
    //统计79-70分人数
    String count_num_70(String cno, String semester);
    //统计69-60分人数
    String count_num_60(String cno, String semester);
    //统计60分以下人数
    String count_num_59(String cno, String semester);
}
