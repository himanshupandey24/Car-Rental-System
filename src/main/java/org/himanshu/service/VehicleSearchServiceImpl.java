package org.himanshu.service;

import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.model.vehicle.VehicleType;
import org.himanshu.repository.VehicleInventoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleSearchServiceImpl implements VehicleSearchService{

    @Override
    public List<HireableVehicle> searchByType(VehicleType vehicleType, String city, LocalDateTime fromDate, LocalDateTime toDate) {
        List<HireableVehicle> hireableVehicles = VehicleInventoryRepository.vehicleInventoryList
                .stream().filter(
                        vehicleInventory -> vehicleInventory.getVehicle().getVehicleType() == vehicleType
                                && vehicleInventory.getVehicle().getParkedLocation().getAddress().getCity().equalsIgnoreCase(city)
                                && !(vehicleInventory.getDueDate() != null && fromDate.isBefore(vehicleInventory.getDueDate()))
                                && (vehicleInventory.getFromDate() != null && toDate.isAfter(vehicleInventory.getFromDate()))
                ).map(vehicleInventory -> vehicleInventory.getVehicle()).collect(Collectors.toList());

        return hireableVehicles;
    }

    @Override
    public List<HireableVehicle> searchByModel(String make, String city, LocalDateTime fromDate, LocalDateTime toDate) {
        List<HireableVehicle> hireableVehicles = VehicleInventoryRepository.vehicleInventoryList
                .stream().filter(
                        vehicleInventory -> vehicleInventory.getVehicle().getMake().equalsIgnoreCase(make)
                                && vehicleInventory.getVehicle().getParkedLocation().getAddress().getCity().equalsIgnoreCase(city)
                                && !(vehicleInventory.getDueDate() != null && fromDate.isBefore(vehicleInventory.getDueDate()))
                                && (vehicleInventory.getFromDate() != null && toDate.isAfter(vehicleInventory.getFromDate()))
                ).map(vehicleInventory -> vehicleInventory.getVehicle()).collect(Collectors.toList());

        return hireableVehicles;
    }

    @Override
    public List<HireableVehicle> searchBySeats(int seats, String city, LocalDateTime fromDate, LocalDateTime toDate) {
        List<HireableVehicle> hireableVehicles = VehicleInventoryRepository.vehicleInventoryList
                .stream().filter(
                        vehicleInventory -> vehicleInventory.getVehicle().getNumberOfSeats() >= (seats)
                                && vehicleInventory.getVehicle().getParkedLocation().getAddress().getCity().equalsIgnoreCase(city)
                                && !(vehicleInventory.getDueDate() != null && fromDate.isBefore(vehicleInventory.getDueDate()))
                                && (vehicleInventory.getFromDate() != null && toDate.isAfter(vehicleInventory.getFromDate()))
                ).map(vehicleInventory -> vehicleInventory.getVehicle()).collect(Collectors.toList());

        return hireableVehicles;
    }
}
