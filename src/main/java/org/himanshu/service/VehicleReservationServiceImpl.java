package org.himanshu.service;

import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.VehicleType;
import org.himanshu.repository.VehicleInventoryRepository;
import org.himanshu.repository.VehicleReservationRepository;

import java.time.LocalDateTime;
import java.util.List;

public class VehicleReservationServiceImpl implements VehicleReservationService{

    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();
    @Override
    public List<VehicleReservation> getReservations(VehicleType vehicleType) {
        return vehicleReservationRepository.getVehicleReservations(vehicleType);
    }

    @Override
    public boolean isVehicleBooked(String qrCode, LocalDateTime fromDate, LocalDateTime toDate) {
        return VehicleInventoryRepository.vehicleInventoryList
                .stream()
                .anyMatch(vehicleInventory -> vehicleInventory.getVehicle().getQrCode().equalsIgnoreCase(qrCode)
                                && vehicleInventory.getDueDate() != null
                                && fromDate.isBefore(vehicleInventory.getDueDate())
                                && vehicleInventory.getFromDate() != null
                                && toDate.isAfter(vehicleInventory.getFromDate())
                );
    }
}
