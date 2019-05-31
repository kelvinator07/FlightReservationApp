package com.geekykel.flightreservation.services;

import com.geekykel.flightreservation.dto.ReservationRequest;
import com.geekykel.flightreservation.entities.Flight;
import com.geekykel.flightreservation.entities.Passenger;
import com.geekykel.flightreservation.entities.Reservation;
import com.geekykel.flightreservation.repos.FlightRepository;
import com.geekykel.flightreservation.repos.PassengerRepository;
import com.geekykel.flightreservation.repos.ReservationRepository;
import com.geekykel.flightreservation.utilities.EmailUtil;
import com.geekykel.flightreservation.utilities.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GeekyKel on 5/27/2019
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Value("${com.geekykel.flightreservation.itinerary.dirpath}")
    public String ITINERARY_DIR;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    PDFGenerator pdfGenerator;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        // Make Payment using 3rd Party

        // Get Flight ID Using Request object
        Long flightId = request.getFlightId();
        Flight flight = flightRepository.findById(flightId).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        String filepath = ITINERARY_DIR + savedPassenger.getFirstName() +
                savedPassenger.getLastName() + savedReservation.getId() + ".pdf";

        pdfGenerator.generateItinerary(savedReservation, filepath);

        //emailUtil.sendItinerary(passenger.getEmail(), filepath);

        return savedReservation;
    }
}
