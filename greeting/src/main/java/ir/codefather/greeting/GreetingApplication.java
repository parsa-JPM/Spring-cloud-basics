package ir.codefather.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingApplication {

	private static Logger logger = LoggerFactory.getLogger(GreetingApplication.class);

	@Autowired
	private GreetingProperties greetingProperties;

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

	@GetMapping("/{lang}")
	public String sayGreeting(@PathVariable String lang) {
		logger.info("we've generated greeting with lang " + lang);

		return greetingProperties.getGreetings().getOrDefault(lang, greetingProperties.getGreeting());
	}
}
