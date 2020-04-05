package com.teo2.prediosservices.service;

import com.teo2.prediosservices.entity.Predio;

import java.util.List;

public interface PredioService {

    Predio guardarPredio(Predio predio);

    List<Predio> obtenerPredios();

    Predio obtenerPrediosPorId(Long id);

    List<Predio> obtenerPrediosDisponibles();

    void borrarPredio(Long id);
}
