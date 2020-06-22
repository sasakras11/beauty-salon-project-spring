package com.salon.controller;


import com.salon.entity.Reservation;
import com.salon.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationController {

    private final ReservationService reservationService;
    private final SessionBean sessionBean;

    @GetMapping(value="/reservations")
    public @ResponseBody
    List<Reservation> getReservationsInJSON() {

        return reservationService.findAllByMasterId("3");

    }

    @GetMapping(value = "/reserve")
    public ModelAndView reserveMasterSession(@RequestParam("hour") String hour,@RequestParam("date") String date){

   reservationService.save(date,hour,sessionBean.getUser(),sessionBean.getMasterId(),sessionBean.getProcedure());

        return new ModelAndView();
    }
}
