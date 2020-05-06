package com.teo2.prediosservices.service;

import com.teo2.prediosservices.dto.ImageDTO;
import com.teo2.prediosservices.entity.Imagen;
import com.teo2.prediosservices.entity.Predio;
import com.teo2.prediosservices.exceptions.PredioNoExisteException;
import com.teo2.prediosservices.repository.AwsS3Repository;
import com.teo2.prediosservices.repository.PredioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagenServiceImpl implements ImagenService{

    private final AwsS3Repository awsS3Repository;
    private final PredioRepository predioRepository;

    public ImagenServiceImpl(AwsS3Repository awsS3Repository, PredioRepository predioRepository) {
        this.awsS3Repository = awsS3Repository;
        this.predioRepository = predioRepository;
    }

    @Override
    public Predio asignarImagenConPredio(ImageDTO imageDTO, String predioId) throws PredioNoExisteException {
        String imageUrl = awsS3Repository.guardarImagen(imageDTO, predioId);
        return asignarImagenAPredio(imageDTO, predioId, imageUrl);
    }

    private Predio asignarImagenAPredio(ImageDTO imageDTO, String predioId, String imageUrl) throws PredioNoExisteException {
        Optional<Predio> optionalPredio = predioRepository.findById(Long.valueOf(predioId));
        Imagen imagen = new Imagen(imageDTO.getImageName(), imageUrl, imageDTO.getPrincipal());
        if (optionalPredio.isPresent()) {
            Predio predio = optionalPredio.get();
            imagen.setPredio(predio);
            predio.getImagenes().add(imagen);
            return predioRepository.save(predio);
        }
        throw new PredioNoExisteException("El predio con identificador " + predioId + " no existe");
    }
}
