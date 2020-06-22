package com.salon.service;

import com.salon.entity.Procedure;
import com.salon.entity.Reservation;
import com.salon.entity.User;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAllByMasterId(String masterId);


    public void save(String date, String hour, User client, int masterId, Procedure procedure);
}
