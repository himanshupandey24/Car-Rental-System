package org.himanshu.service;

import org.himanshu.exceptions.VehicleNotExitsException;
import org.himanshu.model.vehicle.HireableVehicle;

public interface VehicleService {

    HireableVehicle addVehicle(HireableVehicle hireableVehicle);
    HireableVehicle getVehicleById(String id);
    HireableVehicle getVehicleByQrCode(String qrCode);
    void updateQrCode(String vehicleId, String qrCode) throws VehicleNotExitsException;
    void removeVehicle(String vehicleId) throws VehicleNotExitsException;
}
