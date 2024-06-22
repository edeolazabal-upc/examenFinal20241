package com.upc.examenfinal20241.repository;

import com.upc.examenfinal20241.model.GastosViaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GastosViajeRepository extends JpaRepository<GastosViaje, Long> {
    @Query("SELECT u.username as nombre, COUNT(g.id) as cuenta FROM GastosViaje g JOIN g.usuario u GROUP BY u.username")
    List<Object[]> countGastosViajeByUsuario();

    @Query("SELECT u.username as nombre, SUM(g.importe) as importe FROM GastosViaje g JOIN g.usuario u GROUP BY u.username")
    List<Object[]> sumImporteGastosViajeByUsuario();
}
