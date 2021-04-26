package ir.codefather.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.Tracer;

@RestController
public class SayHelloToUsersController {

    private static Logger logger = LoggerFactory.getLogger(SayHelloToUsersController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Tracer tracer;

    private Map<String, String> users = new HashMap<>();

    {
        users.put("Ali", "fa");
        users.put("Chris", "en");
        users.put("Kloze", "de");
    }

    @GetMapping("/hello/{user}")
    public String hello(@PathVariable String user) {
        logger.info("we've said hello to " + user);
        logger.info("traceId is " + tracer.currentSpan().context().traceIdString());

        String lang = users.getOrDefault(user, "en");
        String result = restTemplate.getForObject("http://localhost:8080/" + lang, String.class);

        return result + " " + user;
    }
}
