package org.himanshu.service;

import org.himanshu.model.account.User;
import org.himanshu.model.reservation.Invoice;
import org.himanshu.model.reservation.VehicleFixedCostRegister;
import org.himanshu.model.reservation.VehicleMonthlyCostRegister;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.repository.HireableVehicleRepository;
import org.himanshu.repository.UserRepository;

import java.time.Duration;
import java.util.UUID;

public class MonthInvoiceService implements InvoiceService{
    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        return null;
    }

    private Invoice buildInvoice(VehicleReservation vehicleReservation){
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());
        User user = UserRepository.userRegister.get(vehicleReservation.getUsrId());
        invoice.setUserId(user.getEmail());

        Duration rentedDuration;
        if (vehicleReservation.getReturnDate() == null)
            rentedDuration = Duration.between(vehicleReservation.getFromDate(),
                    vehicleReservation.getFromDate().plusMonths(1));
        else
            rentedDuration = Duration.between(vehicleReservation.getFromDate(),
                    vehicleReservation.getReturnDate());

        double hours = Math.ceil(rentedDuration.toHours());
        double days = Math.ceil(hours / 24) + hours % 24;
        double months = Math.ceil(days / 30);

        HireableVehicle hireableVehicle = HireableVehicleRepository.vehicleRegister
                .get(vehicleReservation.getAllocatedVehicleId());

        double monthlyCost = VehicleMonthlyCostRegister.vehicleMonthlyCostRegister.get(hireableVehicle.getVehicleType());
        double fixedCost = VehicleFixedCostRegister.vehhicleFixedCostRegister.get(hireableVehicle.getVehicleType());

        double vehicleAddonCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        double addonServiceCost = AddonCostUtil.computeEquipmentCost(vehicleReservation);
        double rentalCost = months * monthlyCost + fixedCost + vehicleAddonCost + addonServiceCost;
        double taxes = rentalCost * .18;

        invoice.setAddonCost(vehicleAddonCost);
        invoice.setAddonServiceCost(addonServiceCost);
        invoice.setUsageCharges(rentalCost);
        invoice.setTaxes(taxes);
        invoice.setTotal(rentalCost + taxes);

        return invoice;
    }
}
