package com.geekykel.flightreservation.controllers;

import com.geekykel.flightreservation.entities.Flight;
import com.geekykel.flightreservation.repos.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by GeekyKel on 5/24/2019
 */
@Controller
public class FlightController {

    public static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/findFlights")
    public String findFlights(@RequestParam("user")String user, @RequestParam("from")String from, @RequestParam("to") String to,
                              ModelMap modelMap) {

        List<Flight> flights = flightRepository.findFlights(from, to);
        modelMap.addAttribute("flights", flights);
        modelMap.addAttribute("loggedUser", user);
        return "displayFlights";
    }

//    @RequestMapping("/showLogin")
//    public String showLoginPage(){
//        return "login/login";
//    }

    @RequestMapping("/viewAllFlights")
    public String viewAllFlights(@RequestParam("user")String user, ModelMap modelMap) {
        List<Flight> flights = flightRepository.findAll();
        modelMap.addAttribute("flights", flights);
        modelMap.addAttribute("loggedUser", user);
        return "viewAllFlights";
    }

    @RequestMapping("admin/showAddFlights")
    public String showAddFlights(@RequestParam("user")String user, ModelMap modelMap) {
        List<Flight> flights = flightRepository.findAll();
        modelMap.addAttribute("flights", flights);
        modelMap.addAttribute("loggedUser", user);
        return "addFlights";
    }

}
