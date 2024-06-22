package com.upc.examenfinal20241.service;

import com.upc.examenfinal20241.model.Cuenta;
import com.upc.examenfinal20241.model.GastosViaje;
import com.upc.examenfinal20241.model.Importe;
import com.upc.examenfinal20241.repository.GastosViajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GastosViajeService {
    final GastosViajeRepository gastosViajeRepository;
    public GastosViajeService(GastosViajeRepository gastosViajeRepository) {
        this.gastosViajeRepository = gastosViajeRepository;
    }
    public List<GastosViaje> findAll() {
        return gastosViajeRepository.findAll();
    }

    public Optional<GastosViaje> findById(Long id) {
        return gastosViajeRepository.findById(id);
    }

    public GastosViaje save(GastosViaje gastosViaje) {
          return gastosViajeRepository.save(gastosViaje);
    }
    public void deleteById(Long id) {
        gastosViajeRepository.deleteById(id);
    }
    public List<Cuenta> countGastosViajeByUsuario() {
        List<Object[]> arreglo = gastosViajeRepository.countGastosViajeByUsuario();
        List<Cuenta> listaCuentas = new ArrayList<>();
        Cuenta cuenta = new Cuenta();
        for(var i=0;i<arreglo.size();i++){
            System.out.println(arreglo.get(i)[0]);

            cuenta = new Cuenta(arreglo.get(i)[0].toString(), (Long) arreglo.get(i)[1]);
            listaCuentas.add(cuenta);
        }

        return listaCuentas;
    }

    public List<Importe> sumImporteGastosViajeByUsuario() {
        List<Object[]> arreglo = gastosViajeRepository.sumImporteGastosViajeByUsuario();
        List<Importe> listaImportes = new ArrayList<>();
        Importe importe = new Importe();
        for(var i=0;i<arreglo.size();i++){
            System.out.println(arreglo.get(i)[0]);

            importe = new Importe(arreglo.get(i)[0].toString(), (double) arreglo.get(i)[1]);
            listaImportes.add(importe);
        }

        return listaImportes;

    }
}
