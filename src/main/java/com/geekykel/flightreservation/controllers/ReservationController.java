package com.geekykel.flightreservation.controllers;

import com.geekykel.flightreservation.dto.ReservationRequest;
import com.geekykel.flightreservation.entities.Flight;
import com.geekykel.flightreservation.entities.Reservation;
import com.geekykel.flightreservation.repos.FlightRepository;
import com.geekykel.flightreservation.repos.ReservationRepository;
import com.geekykel.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by GeekyKel on 5/27/2019
 */
@Controller
public class ReservationController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("user")String user, @RequestParam("flightId")Long flightId,
                                          ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);
        modelMap.addAttribute("loggedUser", user);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation completed with id " + reservation.getId());
        //modelMap.addAttribute("loggedUser", user);
        return "reservationConfirmation";
    }
}
