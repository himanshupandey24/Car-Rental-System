package org.himanshu.model.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.himanshu.model.reservation.ReservationStatus;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.reservation.VehicleReservationType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter

public class VehicleInventory {
    private String id;
    private String reservationId;
    private LocalDateTime reservationDate;
    private ReservationStatus status;
    private LocalDateTime fromDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private double startMileage;
    private double endMileage;
    private HireableVehicle vehicle;
    private VehicleReservationType vehicleReservationType;

    public VehicleInventory(){}

    public VehicleInventory(HireableVehicle hireableVehicle){
        this.id = UUID.randomUUID().toString();
        this.startMileage = hireableVehicle.getMileage();
        this.endMileage = hireableVehicle.getMileage();
        this.vehicle = hireableVehicle;
    }
    public VehicleInventory(VehicleReservation vehicleReservation,
                            HireableVehicle hireableVehicle){
        this.id = UUID.randomUUID().toString();
        this.reservationId = vehicleReservation.getReservationId();
        this.reservationDate = vehicleReservation.getReservationDate();
        this.status = vehicleReservation.getReservationStatus();
        this.fromDate = vehicleReservation.getFromDate();
        this.dueDate = vehicleReservation.getDueDate();
        this.returnDate = vehicleReservation.getReturnDate();
        this.startMileage = vehicleReservation.getStartMileage();
        this.endMileage = vehicleReservation.getEndMileage();
        this.vehicle = hireableVehicle;
        this.vehicleReservationType = vehicleReservation.getVehicleReservationType();
    }
}
