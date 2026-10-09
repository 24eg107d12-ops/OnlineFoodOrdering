package onlinefoofordering;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping("/api/status")
    public Map<String, String> status() {
        return Map.of(
            "status", "UP",
            "message", "Online Food Ordering API is running successfully!"
        );
    }
}
