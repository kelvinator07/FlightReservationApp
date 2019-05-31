package com.geekykel.flightreservation.controllers;

import com.geekykel.flightreservation.entities.User;
import com.geekykel.flightreservation.repos.UserRepository;
import com.geekykel.flightreservation.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by GeekyKel on 5/24/2019
 */
@Controller
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/showReg")
    public String showRegistrationPage(){
        return "login/registerUser";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage(){

        LOGGER.error("ERROR LOGGED");
        LOGGER.warn("WARN LOGGED");
        LOGGER.info("INFO LOGGED");
        LOGGER.debug("DEBUG LOGGED");
        LOGGER.trace("TRACE LOGGED");

        return "login/login";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){

        // encode password using Spring Security BCryptPasswordEncoder
        user.setPassword(encoder.encode(user.getPassword()));

        // save user to database
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        ModelMap modelMap){
        boolean loginResponse = securityService.login(email, password);

        User user = userRepository.findByEmail(email);

        LOGGER.warn("NOW IN {} LOGIN PAGE", user.getFirstName());

        // if (user != null && user.getPassword().equals(password)) {
        if (loginResponse) {
            modelMap.addAttribute("loggedUser", user.getFirstName() + " " + user.getLastName());
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid user name or password, please try again");
        }

        return "login/login";
    }
}
