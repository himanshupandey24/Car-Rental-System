package org.himanshu.model.reservation;

import org.himanshu.model.common.Address;
import org.himanshu.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public class VehicleReservation {
    private String reservationId;
    private String usrId;
    private LocalDateTime reservationDate;
    private ReservationStatus reservationStatus;
    private LocalDateTime fromDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private Address pickUpLocation;
    private Address dropLocation;
    private double startMileage;
    private double endMileage;
    private String allocatedVehicleId;
    private VehicleType vehicleType;
    private String invoiceId;
    private List<VehicleAddOn> vehicleAddOns;
    private List<AddonService> addonServices;
    private VehicleReservationType vehicleReservationType;



}
