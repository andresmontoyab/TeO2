package com.teo2.prediosservices.service;

import com.teo2.prediosservices.entity.Predio;
import com.teo2.prediosservices.repository.PredioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredioServiceImpl implements PredioService{

    private final PredioRepository predioRepository;

    public PredioServiceImpl(PredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    @Override
    public Predio guardarPredio(Predio predio) {
        return predioRepository.save(predio);
    }

    @Override
    public List<Predio> obtenerPredios() {
        return predioRepository.findAll();
    }


    @Override
    public Predio obtenerPrediosPorId(Long id) {
        return predioRepository.findById(id).get();
    }

    @Override
    public List<Predio> obtenerPrediosDisponibles() {
        return predioRepository.findByDisponible(true);
    }

    @Override
    public void borrarPredio(Long id) {
        predioRepository.deleteById(id);
    }
}
