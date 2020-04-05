package com.teo2.prediosservices.controller;

import com.teo2.prediosservices.entity.Predio;
import com.teo2.prediosservices.service.PredioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/predios")
public class PredioControllerImpl implements PredioController {

    private final PredioService predioService;

    public PredioControllerImpl(PredioService predioService) {
        this.predioService = predioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Predio guardar(@RequestBody Predio predio) {
        return predioService.guardarPredio(predio);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Predio> obtenerPredios() {
        return predioService.obtenerPredios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Predio obtenerPrediosPorId(@PathVariable("id") Long id) {
        return predioService.obtenerPrediosPorId(id);
    }

    @GetMapping("/disponibles")
    @ResponseStatus(HttpStatus.OK)
    public List<Predio> obtenerPrediosDisponibles() {
        return predioService.obtenerPrediosDisponibles();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        predioService.borrarPredio(id);
    }
}
