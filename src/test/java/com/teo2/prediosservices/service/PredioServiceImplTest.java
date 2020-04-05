package com.teo2.prediosservices.service;


import com.teo2.prediosservices.entity.Predio;
import com.teo2.prediosservices.repository.PredioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredioServiceImplTest {

    private PredioService predioService;
    private PredioRepository predioRepositoryMock;


    @Before
    public void setUp() throws Exception {
        predioRepositoryMock = Mockito.mock(PredioRepository.class);
        predioService = new PredioServiceImpl(predioRepositoryMock);
    }

    @Test
    public void traerPredios() {
        //given
        List<Predio> prediosMock = crearPrediosMock();
        Mockito.when(predioRepositoryMock.findAll()).thenReturn(new ArrayList<>(prediosMock));

        //when
        List<Predio> predios = predioService.obtenerPredios();

        //then
        Assert.assertTrue(predios.size() > 0 );
        Mockito.verify(predioRepositoryMock, Mockito.times(1)).findAll();
    }

    private List<Predio> crearPrediosMock() {
        Predio predio1 = new Predio();
        predio1.setId(1L);
        Predio predio2 = new Predio();
        predio2.setId(2L);
        return Arrays.asList(predio1, predio2);
    }
}