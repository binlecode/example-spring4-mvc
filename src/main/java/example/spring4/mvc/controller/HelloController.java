package example.spring4.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getIndex() {
        log.debug(" >> getIndex action is called");
        return "Hello Spring 4 mvc!";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getGreeting(ModelMap model) {
        model.addAttribute("name", "World");
        return "greeting";
    }


}
