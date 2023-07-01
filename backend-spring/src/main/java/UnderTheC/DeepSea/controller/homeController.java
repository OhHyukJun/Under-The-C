package UnderTheC.DeepSea.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @RequestMapping("/")
    public String home(Model model) {
        return "Hello guys!\n" +
                "Welcome to the deep C!";
    }
}
