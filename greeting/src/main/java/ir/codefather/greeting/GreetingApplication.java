package ir.codefather.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingApplication {

	@Autowired
	private GreetingProperties greetingProperties;

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

	@GetMapping("/{lang}")
	public String sayGreeting(@PathVariable String lang) {
		return greetingProperties.getGreetings().getOrDefault(lang, greetingProperties.getGreeting());
	}
}
