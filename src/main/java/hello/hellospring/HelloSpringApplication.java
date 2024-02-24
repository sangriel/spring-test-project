package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // -> 애가 선언되어 있는 디렉토리 아래로만 어노테이션을 붙였을때 컴포넌트 스캔을 지원함.
public class HelloSpringApplication {

	// 스프링 부트는 톰캣을 내장하고 있기 때문에, 자체적을 띄워주면서 스프링 부트가 같이 올라온다.
	// 보통 프로젝트가 그래들을 사용해서 빌드를 하는 경우가 있는데, 이때 설정에서 ide를 쓰도록 하면 빌드속도가 빨라진다.
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
