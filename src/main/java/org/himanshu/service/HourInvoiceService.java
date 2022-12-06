package org.himanshu.service;

import org.himanshu.model.account.User;
import org.himanshu.model.reservation.*;
import org.himanshu.repository.UserRepository;

import java.time.Duration;
import java.util.UUID;

public class HourInvoiceService implements InvoiceService{
    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        return buildInvoice(vehicleReservation);
    }

    private Invoice buildInvoice(VehicleReservation vehicleReservation){

        User user = UserRepository.userRegister.get(vehicleReservation.getUsrId());

        Invoice invoice = new Invoice();

        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());
        invoice.setUserId(user.getEmail());


        Duration rentedDuration;

        if(vehicleReservation.getReturnDate() == null){
            rentedDuration = Duration.between(vehicleReservation.getFromDate(),
                    vehicleReservation.getDueDate().plusHours(1));
        }
        else{
            rentedDuration = Duration.between(vehicleReservation.getFromDate(), vehicleReservation.getReturnDate());
        }

        double hours = Math.ceil(rentedDuration.toHours());

        if(hours == 0) hours = 1;

        double hourlyCost = VehicleHourlyCostRegister.vehicleHourlyCostRegister.get(vehicleReservation.getVehicleType());
        double fixedCost = VehicleFixedCostRegister.vehhicleFixedCostRegister.get(vehicleReservation.getVehicleType());

        double vehicleAddOnCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        double addOnServiceCost = AddonCostUtil.computeServiceCost(vehicleReservation);

        double rentalCost = hours * hourlyCost + fixedCost + vehicleAddOnCost + addOnServiceCost;
        double taxes = rentalCost * 0.18;


        invoice.setAddonCost(vehicleAddOnCost);
        invoice.setAddonServiceCost(addOnServiceCost);
        invoice.setUsageCharges(rentalCost);
        invoice.setTaxes(taxes);
        invoice.setTotal(rentalCost + taxes);

        return invoice;
    }
}
