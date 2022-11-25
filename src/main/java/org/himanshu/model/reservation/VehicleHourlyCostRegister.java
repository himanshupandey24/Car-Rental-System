package org.himanshu.model.reservation;

import org.himanshu.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleHourlyCostRegister {
    public static Map<VehicleType, Double> vehicleHourlyCostRegister = new HashMap<>();

    static {
        vehicleHourlyCostRegister.put(VehicleType.BICYCLE, 5.0);
        vehicleHourlyCostRegister.put(VehicleType.MOTORCYCLE, 20.0);
        vehicleHourlyCostRegister.put(VehicleType.HATCHBACK, 50.0);
        vehicleHourlyCostRegister.put(VehicleType.SEDAN, 150.0);
        vehicleHourlyCostRegister.put(VehicleType.SUV, 200.0);
        vehicleHourlyCostRegister.put(VehicleType.TRUCK, 250.0);
        vehicleHourlyCostRegister.put(VehicleType.THREEWHEELER, 100.0);
        vehicleHourlyCostRegister.put(VehicleType.VAN, 100.0);
    }
}
