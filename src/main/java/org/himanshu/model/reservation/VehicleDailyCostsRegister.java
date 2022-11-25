package org.himanshu.model.reservation;

import org.himanshu.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleDailyCostsRegister {
    public static Map<VehicleType, Double> vehicleDailyCostRegister = new HashMap<>();

    static{
        vehicleDailyCostRegister.put(VehicleType.BICYCLE, 50.0);
        vehicleDailyCostRegister.put(VehicleType.MOTORCYCLE, 200.0);
        vehicleDailyCostRegister.put(VehicleType.HATCHBACK, 800.0);
        vehicleDailyCostRegister.put(VehicleType.SEDAN, 1000.0);
        vehicleDailyCostRegister.put(VehicleType.SUV, 1500.0);
        vehicleDailyCostRegister.put(VehicleType.TRUCK, 2500.0);
        vehicleDailyCostRegister.put(VehicleType.THREEWHEELER, 1000.0);
        vehicleDailyCostRegister.put(VehicleType.VAN, 1000.0);
    }
}
