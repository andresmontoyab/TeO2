package com.teo2.prediosservices.service;

import com.teo2.prediosservices.dto.ImageDTO;
import com.teo2.prediosservices.entity.Predio;
import com.teo2.prediosservices.exceptions.PredioNoExisteException;

import java.util.List;

public interface ImagenService {

    Predio asignarImagenConPredio(ImageDTO imageDTO, String predioId) throws PredioNoExisteException;

}
