package com.geekykel.flightreservation.repos;

import com.geekykel.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by GeekyKel on 5/24/2019
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity")
    List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to);
}
