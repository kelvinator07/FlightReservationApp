package com.geekykel.flightreservation.services;

import com.geekykel.flightreservation.dto.ReservationRequest;
import com.geekykel.flightreservation.entities.Reservation;

/**
 * Created by GeekyKel on 5/27/2019
 */
public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
