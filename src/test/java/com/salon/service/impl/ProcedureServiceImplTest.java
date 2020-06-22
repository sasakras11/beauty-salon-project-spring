package com.salon.service.impl;

import com.salon.entity.Procedure;
import com.salon.repository.ProcedureRepository;
import com.salon.service.DataParser;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProcedureServiceImplTest {

  @Mock private ProcedureRepository procedureRepository;

  @Mock private DataParser dataParser;

  @InjectMocks private ProcedureServiceImpl procedureService;

  @After
  public void resetMocks() {
    reset(procedureRepository, dataParser);
  }

  @Test
  public void getPagesCountMethodShouldWorkProperly() {
    when(procedureRepository.count()).thenReturn((long) 11);
    assertEquals(3, procedureService.pagesCount());
  }


}
