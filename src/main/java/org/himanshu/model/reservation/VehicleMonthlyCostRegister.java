package org.himanshu.model.reservation;

import org.himanshu.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleMonthlyCostRegister {
    public static Map<VehicleType, Double> vehicleMonthlyCostRegister = new HashMap<>();

    static {
        vehicleMonthlyCostRegister.put(VehicleType.BICYCLE, 800.0);
        vehicleMonthlyCostRegister.put(VehicleType.MOTORCYCLE, 4000.0);
        vehicleMonthlyCostRegister.put(VehicleType.HATCHBACK, 10000.0);
        vehicleMonthlyCostRegister.put(VehicleType.SEDAN, 15000.0);
        vehicleMonthlyCostRegister.put(VehicleType.SUV, 20000.0);
        vehicleMonthlyCostRegister.put(VehicleType.TRUCK, 40000.0);
        vehicleMonthlyCostRegister.put(VehicleType.THREEWHEELER, 20000.0);
        vehicleMonthlyCostRegister.put(VehicleType.VAN, 20000.0);
    }
}
