package com.geekykel.flightreservation.controllers;

import com.geekykel.flightreservation.dto.ReservationRequest;
import com.geekykel.flightreservation.dto.ReservationUpdateRequest;
import com.geekykel.flightreservation.entities.Reservation;
import com.geekykel.flightreservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GeekyKel on 5/28/2019
 */
@RestController
public class ReservationRestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        return reservationRepository.findById(id).get();
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        return reservationRepository.save(reservation);
    }
}
