package org.himanshu.model.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.himanshu.model.common.Coordinates;

@Getter
@Setter
public abstract class HireableVehicle {
    private String id;
    private String licensePlateNumber;
    private String qrCode;
    private String make;
    private String model;
    private int yearOfManufacture;
    private double meterReading;
    private double fuelCapacity;
    private double currentFuelMeasurement;
    private double mileage;
    private int numberOfSeats;
    private VehicleCategory vehicleCategory;
    private VehicleType vehicleType;
    private Location parkedLocation;
    private Coordinates currentLocation;
}
