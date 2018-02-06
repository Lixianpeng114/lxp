package lxp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lxp
 * @date 2018年2月2日 下午2:49:59
 * @param
 * @return
 */
@SpringBootApplication
@MapperScan("lxp.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
