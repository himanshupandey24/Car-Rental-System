package org.himanshu.service;

import org.himanshu.model.account.User;
import org.himanshu.model.reservation.Invoice;
import org.himanshu.model.reservation.VehicleFixedCostRegister;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.HireableVehicle;
import org.himanshu.repository.HireableVehicleRepository;
import org.himanshu.repository.UserRepository;

import java.util.UUID;

public class InvoiceBuilderUtil {
    public static Invoice buildCancelledInvoice(VehicleReservation vehicleReservation){

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());
        User user = UserRepository.userIdRegister.get(vehicleReservation.getUsrId());
        invoice.setUserId(user.getEmail());

        HireableVehicle hireableVehicle = HireableVehicleRepository.vehicleRegister
                .get(vehicleReservation.getAllocatedVehicleId());

        double fixedCost = VehicleFixedCostRegister.vehhicleFixedCostRegister.get(hireableVehicle.getVehicleType());
        double taxes = fixedCost * .18;

        invoice.setUsageCharges(fixedCost);
        invoice.setTaxes(taxes);
        invoice.setTotal(fixedCost + taxes);
        return invoice;
    }
}
