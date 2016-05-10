package tw.wee.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {
    @RequestMapping("/health")
    public static String checkHealth(){
        return "up";
    }
}
