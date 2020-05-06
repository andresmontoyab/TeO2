package com.teo2.prediosservices.controller;

import com.teo2.prediosservices.dto.ImageDTO;
import com.teo2.prediosservices.entity.Predio;
import com.teo2.prediosservices.service.ImagenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagenControllerImpl implements ImagenController{

    private final ImagenService imagenService;

    public ImagenControllerImpl(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @PostMapping("/predios/{predioId}/imagenes")
    @ResponseStatus(HttpStatus.CREATED)
    public Predio guardar(@RequestBody ImageDTO imageDTO, @PathVariable String predioId) {
        return imagenService.asignarImagenConPredio(imageDTO, predioId);
    }
}
