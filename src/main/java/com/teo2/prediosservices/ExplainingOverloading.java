package com.teo2.prediosservices;

public class ExplainingOverloading {

}

class calcularSalario {

    // Prestacion por servicion
    public Integer calcular(Integer sumaPorMes) {
        return sumaPorMes * 12;
    }

    public Integer calcular(Integer sumarPorMes, Integer deducciones) {
        return (sumarPorMes - deducciones) * 12;
    }
}

class calcularSalarioPrestacion extends calcularSalario {

    @Override
    public Integer calcular(Integer sumarPorMes, Integer deducciones) {
        return (sumarPorMes - deducciones + 10) *12;
    }
}
