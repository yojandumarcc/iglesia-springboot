package com.arqui.ufps.freelancer.controller;

import com.arqui.ufps.freelancer.model.entities.User;
import com.arqui.ufps.freelancer.repository.dao.IUserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
public class LoginController {

    @Autowired
    private IUserDao userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    protected final Log logger = LogFactory.getLog(this.getClass());

    @GetMapping("/login")
    public @ResponseBody
    String login(Principal principal) {

        if (principal != null) {
            logger.info("ENTRO AL LOGIN CONTROLLER");
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping({"/signup", "/"})
    public User save(@RequestBody User user) {              
        return userService.save(user);
    }
}
