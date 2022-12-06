package org.himanshu.service;

import org.himanshu.model.account.User;
import org.himanshu.model.reservation.Invoice;
import org.himanshu.model.reservation.VehicleDailyCostsRegister;
import org.himanshu.model.reservation.VehicleFixedCostRegister;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.repository.UserRepository;

import java.time.Duration;
import java.util.UUID;

public class DayInvoiceService implements InvoiceService {
    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        return null;
    }

    private Invoice buildInvoice(VehicleReservation vehicleReservation){

        User user = UserRepository.userRegister.get(vehicleReservation.getUsrId());
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());
        invoice.setUserId(user.getEmail());

        Duration rentedDuration;

        if(vehicleReservation.getReturnDate() == null){
            rentedDuration = Duration.between(vehicleReservation.getFromDate(), vehicleReservation.getFromDate().plusDays(1));
        }
        else{
            rentedDuration = Duration.between(vehicleReservation.getFromDate(), vehicleReservation.getReturnDate());
        }

        double hours = Math.ceil(rentedDuration.toHours());
        double days = Math.ceil(hours/24) + hours % 24;

        double dailyCost = VehicleDailyCostsRegister.vehicleDailyCostRegister.get(vehicleReservation.getVehicleType());
        double fixedCost = VehicleFixedCostRegister.vehhicleFixedCostRegister.get(vehicleReservation.getVehicleType());

        double vehicleAddOnCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        double addOnServiceCost = AddonCostUtil.computeServiceCost(vehicleReservation);

        double rentalCost = days * dailyCost + fixedCost + vehicleAddOnCost + addOnServiceCost;
        double taxes = rentalCost * 0.18;

        invoice.setUsageCharges(rentalCost);
        invoice.setTaxes(taxes);
        invoice.setTotal(rentalCost + taxes);

        return invoice;
    }
}
