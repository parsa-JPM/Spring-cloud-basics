package ir.codefather.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueControler {

    @Value("${my.var}")
    private String envVar;

    @GetMapping("/value")
    public String getValue() {
        return envVar;
    }
}
