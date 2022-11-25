package org.himanshu.repository;

import org.himanshu.model.vehicle.HireableVehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HireableVehicleRepository {
    public static Map<String, HireableVehicle> vehicleRegister = new HashMap<>();
    public static List<HireableVehicle> vehicles = new ArrayList<>();

    public HireableVehicle addVehicle(HireableVehicle hireableVehicle){
        vehicleRegister.putIfAbsent(hireableVehicle.getId(),hireableVehicle);
        vehicles.add(hireableVehicle);
        return hireableVehicle;
    }
}
