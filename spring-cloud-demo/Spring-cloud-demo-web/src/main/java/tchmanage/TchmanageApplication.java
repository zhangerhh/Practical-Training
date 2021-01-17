package tchmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication
@SpringBootApplication
@MapperScan("tchmanage.dao")
public class TchmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TchmanageApplication.class, args);
    }
}
