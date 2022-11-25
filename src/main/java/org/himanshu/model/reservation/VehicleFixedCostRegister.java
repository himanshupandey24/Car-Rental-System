package org.himanshu.model.reservation;

import org.himanshu.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleFixedCostRegister {
    public static Map<VehicleType, Double> vehhicleFixedCostRegister = new HashMap<>();

    static{
        vehhicleFixedCostRegister.put(VehicleType.BICYCLE, 5.0);
        vehhicleFixedCostRegister.put(VehicleType.MOTORCYCLE, 20.0);
        vehhicleFixedCostRegister.put(VehicleType.HATCHBACK, 50.0);
        vehhicleFixedCostRegister.put(VehicleType.SEDAN, 100.0);
        vehhicleFixedCostRegister.put(VehicleType.SUV, 100.0);
        vehhicleFixedCostRegister.put(VehicleType.TRUCK, 250.0);
        vehhicleFixedCostRegister.put(VehicleType.THREEWHEELER, 50.0);
        vehhicleFixedCostRegister.put(VehicleType.VAN, 100.0);

    }
}
