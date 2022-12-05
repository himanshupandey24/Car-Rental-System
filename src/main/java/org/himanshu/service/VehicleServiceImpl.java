package org.himanshu.service;

import org.himanshu.exceptions.VehicleNotExitsException;
import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.model.vehicle.VehicleInventory;
import org.himanshu.repository.HireableVehicleRepository;
import org.himanshu.repository.VehicleInventoryRepository;

public class VehicleServiceImpl implements VehicleService{

    HireableVehicleRepository hireableVehicleRepository = new HireableVehicleRepository();

    private void addToInventory(HireableVehicle hireableVehicle){
        VehicleInventory vehicleInventory = new VehicleInventory(hireableVehicle);
        VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();
        vehicleInventoryRepository.addToInventory(vehicleInventory);
    }
    @Override
    public HireableVehicle addVehicle(HireableVehicle hireableVehicle) {
        addToInventory(hireableVehicle);
        return hireableVehicleRepository.addVehicle(hireableVehicle);
    }

    @Override
    public HireableVehicle getVehicleById(String id) {
        return HireableVehicleRepository.vehicleRegister.get(id);
    }

    @Override
    public HireableVehicle getVehicleByQrCode(String qrCode) {
        return HireableVehicleRepository.vehicles
                .stream()
                .filter(hireableVehicle -> hireableVehicle.getQrCode().equalsIgnoreCase(qrCode))
                .findAny()
                .get();
    }

    @Override
    public void updateQrCode(String vehicleId, String qrCode) throws VehicleNotExitsException {
        HireableVehicle hireableVehicle = HireableVehicleRepository.vehicleRegister.get(vehicleId);
        if(hireableVehicle == null)
            throw new VehicleNotExitsException("Vehicle with id " + vehicleId + " not found");

        hireableVehicle.setQrCode(qrCode);
    }

    @Override
    public void removeVehicle(String vehicleId) throws VehicleNotExitsException {
        HireableVehicle hireableVehicle = HireableVehicleRepository.vehicleRegister.get(vehicleId);
        if(hireableVehicle == null)
            throw new VehicleNotExitsException("Vehicle with id " + vehicleId + " not found");
        HireableVehicleRepository.vehicleRegister.remove(vehicleId);
        VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();
        vehicleInventoryRepository.removeFromInventory(new VehicleInventory(hireableVehicle));
    }
}
