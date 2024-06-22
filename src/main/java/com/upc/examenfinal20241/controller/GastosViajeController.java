package com.upc.examenfinal20241.controller;


import com.upc.examenfinal20241.model.Cuenta;
import com.upc.examenfinal20241.model.GastosViaje;
import com.upc.examenfinal20241.model.Importe;
import com.upc.examenfinal20241.service.GastosViajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense/gastos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GastosViajeController {

    final GastosViajeService gastosViajeService;

    public GastosViajeController(GastosViajeService gastosViajeService) {
        this.gastosViajeService = gastosViajeService;
    }


    @GetMapping
    public List<GastosViaje> findAll() {
        return gastosViajeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<GastosViaje> findById(@PathVariable Long id) {
        return gastosViajeService.findById(id);
    }

    @PostMapping
    public GastosViaje save(@RequestBody GastosViaje gastosViaje) {
        return gastosViajeService.save(gastosViaje);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        gastosViajeService.deleteById(id);
    }
    @GetMapping("/cuenta")
    public List<Cuenta> countGastosViajeByUsuario() {
        return gastosViajeService.countGastosViajeByUsuario();
    }

    @GetMapping("/importe")
    public List<Importe> sumImporteGastosViajeByUsuario() {
        return gastosViajeService.sumImporteGastosViajeByUsuario();
    }
}