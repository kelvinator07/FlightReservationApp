package com.geekykel.flightreservation.services;

import org.springframework.stereotype.Service;

/**
 * Created by GeekyKel on 5/29/2019
 */
@Service
public interface SecurityService {
    boolean login(String username, String password);
}
