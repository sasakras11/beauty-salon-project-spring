package com.salon.service.impl;

import com.salon.entity.Procedure;
import com.salon.entity.Reservation;
import com.salon.entity.User;
import com.salon.exception.NotValidParameterException;
import com.salon.repository.ProcedureRepository;
import com.salon.repository.ReservationRepository;
import com.salon.repository.UserRepository;
import com.salon.service.DataParser;
import com.salon.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationServiceImpl implements ReservationService {

  private final DataParser dataParser;
  private final ReservationRepository reservationRepository;
  private final ProcedureRepository procedureRepository;
  private final UserRepository userRepository;

  @Override
  public List<Reservation> findAllByMasterId(String masterId) {
    return dataParser
        .parseInt(masterId)
        .map(reservationRepository::findAllByBeautyMaster_Id)
        .orElseThrow(
            () ->
                new NotValidParameterException(
                    String.format("request param masterId - [%s] is noy valid", masterId)));
  }

  @Override
  public void save(String date, String hour, User client, int masterId, Procedure procedure) {

    Optional<Integer> validatedHour = dataParser.parseWorkHour(hour, 9, 18);
    Optional<Date> validatedDate = dataParser.parseDate(date);
    if (validatedDate.isPresent() && validatedHour.isPresent()) {
      reservationRepository.save(
          Reservation.builder()
              .end(getEndDate(validatedDate.get(), procedure))
              .start(validatedDate.get())
              .beautyMaster(
                  userRepository
                      .findById(masterId)
                      .orElseThrow(
                          () ->
                              new NotValidParameterException(
                                  String.format(
                                      "request param masterId - [%s] is noy valid", masterId))))
              .client(client)
              .procedure(procedure)
              .build());
    }
  }

  private Date getEndDate(Date startDate, Procedure procedure) {

    Calendar cal = Calendar.getInstance();
    cal.setTime(startDate);
    cal.add(Calendar.HOUR_OF_DAY, procedure.getDurationHours());
    return cal.getTime();
  }
}
