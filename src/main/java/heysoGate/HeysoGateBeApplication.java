package heysoGate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("heysoGate.mapper")
public class HeysoGateBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeysoGateBeApplication.class, args);
	}

}
