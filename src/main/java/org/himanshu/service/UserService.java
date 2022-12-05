package org.himanshu.service;

import org.himanshu.exceptions.InvalidVehicleException;
import org.himanshu.exceptions.ReservationNotFoundException;
import org.himanshu.exceptions.VehicleBookedExceptions;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.model.vehicle.VehicleLocation;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    VehicleReservation scanToResercve(String qrCode, String userId) throws InvalidVehicleException, VehicleBookedExceptions;

    VehicleReservation remoteReserve(VehicleReservation vehicleReservation);

    VehicleReservation cancel(String reservationId);

    HireableVehicle pickupVehicle(VehicleReservation vehicleReservation);

    void returnVehicle(String reservationId, VehicleLocation vehicleLocation) throws ReservationNotFoundException;

    List<HireableVehicle> getHiredVehicles(String userId);

    List<HireableVehicle> getHiredVehicles(String userId, LocalDateTime startDate, LocalDateTime endDate);

}
