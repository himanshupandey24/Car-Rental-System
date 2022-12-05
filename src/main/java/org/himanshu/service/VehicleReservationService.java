package org.himanshu.service;

import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleReservationService {
    List<VehicleReservation> getReservations(VehicleType vehicleType);

    boolean isVehicleBooked(String qrCode, LocalDateTime fromDate, LocalDateTime toDate);
}
