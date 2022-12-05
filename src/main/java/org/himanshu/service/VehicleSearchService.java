package org.himanshu.service;

import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleSearchService {

    List<HireableVehicle> searchByType(VehicleType vehicleType, String city, LocalDateTime fromDate, LocalDateTime toDate);
    List<HireableVehicle> searchByModel(String make, String city, LocalDateTime fromDate, LocalDateTime toDate);
    List<HireableVehicle> searchBySeats(int seats, String city, LocalDateTime fromDate, LocalDateTime toDate);

}
