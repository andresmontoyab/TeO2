package com.teo2.prediosservices.controller;

import com.teo2.prediosservices.dto.ImageDTO;
import com.teo2.prediosservices.entity.Predio;

public interface ImagenController {

    Predio guardar(ImageDTO imageDTO, String predioId);
}
