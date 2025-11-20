package com.example.APP.Repository;

import com.example.APP.Model.AccesoVehicular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccesoVehicularRepository extends JpaRepository<AccesoVehicular, Long> {
    List<AccesoVehicular> findByPlacaVehiculo(String placaVehiculo);
}
