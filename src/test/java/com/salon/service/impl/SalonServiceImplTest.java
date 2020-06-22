package com.salon.service.impl;

import com.salon.entity.Salon;
import com.salon.repository.SalonRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class SalonServiceImplTest {

  @Mock private SalonRepository salonRepository;

  @InjectMocks private SalonServiceImpl salonService;


  public static final List<Salon> salons = new ArrayList<>(){{
    add(Salon.builder().id(1).build());
    add(Salon.builder().id(2).build());
    add(Salon.builder().id(3).build());
    add(Salon.builder().id(4).build());
    add(Salon.builder().id(5).build());
    add(Salon.builder().id(6).build());

  }};
  @After
  public void resetMocks() {
    reset(salonRepository);
  }

  @Test
  void findAll() {
    when(salonRepository.findAll()).thenReturn(salons);

    assertEquals(salons,salonService.findAll());

    verify(salonRepository,times(1)).findAll();

  }
}
