package egovframework.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/api/hello")
	public String hello() {
		System.out.println("hello backend");
		return "hello backend";
	}
}
