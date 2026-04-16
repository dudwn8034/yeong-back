package egovframework.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// annotationClass를 지정해 eGovFramework @Mapper가 붙은 인터페이스만 스캔 (Service 인터페이스 제외)
@MapperScan(basePackages = "egovframework.example", annotationClass = org.egovframe.rte.psl.dataaccess.mapper.Mapper.class)
@SpringBootApplication
public class EgovBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgovBootApplication.class, args);
	}

}
