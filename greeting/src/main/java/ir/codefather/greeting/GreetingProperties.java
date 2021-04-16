package ir.codefather.greeting;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties
@Setter
@Getter
public class GreetingProperties {
    private String greeting;
    private Map<String, String> greetings;
}
