package org.himanshu.service;

import org.himanshu.exceptions.InvalidVehicleException;
import org.himanshu.exceptions.ReservationNotFoundException;
import org.himanshu.exceptions.VehicleBookedExceptions;
import org.himanshu.model.common.NotificationStatus;
import org.himanshu.model.reservation.*;
import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.model.vehicle.VehicleInventory;
import org.himanshu.model.vehicle.VehicleLocation;
import org.himanshu.model.vehicle.VehicleStatus;
import org.himanshu.repository.HireableVehicleRepository;
import org.himanshu.repository.UserRepository;
import org.himanshu.repository.VehicleInventoryRepository;
import org.himanshu.repository.VehicleReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService{

    UserRepository userRepository = new UserRepository();
    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();
    VehicleReservationService vehicleReservationService = new VehicleReservationServiceImpl();
    InvoiceService invoiceService = new InvoiceServiceImpl();
    InvoiceNotificationService invoiceNotificationService = new InvoiceNotificationServiceImpl();

    VehicleInventoryRepository vehicleInventoryRepository = new VehicleInventoryRepository();

    private VehicleReservation buildQucikReservation(String qrCode, String userId){
        HireableVehicle vehicle = HireableVehicleRepository.vehicleRegister.get(userId);
        vehicle.setVehicleStatus(VehicleStatus.BOOKED);

        VehicleReservation vehicleReservation = new VehicleReservation();
        vehicleReservation.setUsrId(userId);
        vehicleReservation.setReservationId(UUID.randomUUID().toString());
        vehicleReservation.setFromDate(LocalDateTime.now());
        vehicleReservation.setDueDate(LocalDateTime.now().plusHours(2));
        vehicleReservation.setReservationStatus(ReservationStatus.ACTIVE);
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);
        vehicleReservation.setVehicleType(vehicle.getVehicleType());
        vehicleReservation.setStartMileage(vehicle.getMileage());
        vehicleReservation.setPickUpLocation(vehicle.getParkedLocation().getAddress());

        HireableVehicle hireableVehicle = HireableVehicleRepository.vehicleRegister.get(userId);
        vehicleReservation.setAllocatedVehicleId(hireableVehicle.getId());
        vehicleReservation.setVehicleReservationType(VehicleReservationType.HOURLY);
        return vehicleReservation;
    }

    private InvoiceNotification buildInvoiceNotification(Invoice invoice){
        InvoiceNotification invoiceNotification = new InvoiceNotification();
        invoiceNotification.setReservationID(invoice.getReservationId());
        invoiceNotification.setUserId(invoice.getUserId());
        invoiceNotification.setCreatedDate(LocalDateTime.now());
        invoiceNotification.setNotificationStatus(NotificationStatus.PENDING);
        return invoiceNotification;
    }

    private VehicleInventory buildVehicleInventory(VehicleReservation vehicleReservation){
        HireableVehicle hireableVehicle = HireableVehicleRepository.vehicleRegister
                .get(vehicleReservation.getAllocatedVehicleId());

        VehicleInventory vehicleInventory = new VehicleInventory(vehicleReservation, hireableVehicle);
        return vehicleInventory;
    }

    private void updateVehicleInventory(VehicleReservation vehicleReservation) {
        VehicleInventory vehicleInventory = buildVehicleInventory(vehicleReservation);
        vehicleInventoryRepository.addToInventory(vehicleInventory);
    }

    @Override
    public VehicleReservation scanToResercve(String qrCode, String userId) throws InvalidVehicleException, VehicleBookedExceptions {
        if(HireableVehicleRepository.vehicleRegister.get(userId) == null)
            throw new InvalidVehicleException("Invalid Vehicle Id");

        if(vehicleReservationService.isVehicleBooked(qrCode,LocalDateTime.now(), LocalDateTime.now().plusHours(2)))
            throw new VehicleBookedExceptions("Vehicle already booked try other vehicle");

        VehicleReservation vehicleReservation = vehicleReservationRepository.reserve(buildQucikReservation(qrCode, userId));
        updateVehicleInventory(vehicleReservation);
        return vehicleReservation;
    }

    @Override
    public VehicleReservation remoteReserve(VehicleReservation vehicleReservation) {
        return null;
    }

    @Override
    public VehicleReservation cancel(String reservationId) {
        return null;
    }

    @Override
    public HireableVehicle pickupVehicle(VehicleReservation vehicleReservation) {
        return null;
    }

    @Override
    public void returnVehicle(String reservationId, VehicleLocation vehicleLocation) throws ReservationNotFoundException {

    }

    @Override
    public List<HireableVehicle> getHiredVehicles(String userId) {
        return userRepository.getHiredVehicles(userId);
    }

    @Override
    public List<HireableVehicle> getHiredVehicles(String userId, LocalDateTime startDate, LocalDateTime endDate) {
        return userRepository.getHiredVehicle(userId,startDate,endDate);
    }
}
