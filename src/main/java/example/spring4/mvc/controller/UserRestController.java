package example.spring4.mvc.controller;

import example.spring4.mvc.model.User;
import example.spring4.mvc.service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    @Autowired
    UserCrudService userCrudService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> listUser(
            @RequestParam(value = "max", defaultValue = "100") int max,
            @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {
        List<User> userList = userCrudService.findAllUsers(max, offset, new HashMap<>());
        return userList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User showUser(
            @PathVariable long id
    ) {
        return userCrudService.findUser(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userCrudService.addUser(user);
    }


}
