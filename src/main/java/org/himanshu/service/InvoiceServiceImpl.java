package org.himanshu.service;

import org.himanshu.model.reservation.Invoice;
import org.himanshu.model.reservation.ReservationStatus;
import org.himanshu.model.reservation.VehicleReservation;

public class InvoiceServiceImpl implements InvoiceService{

    InvoiceServiceFactory invoiceServiceFactory = new InvoiceServiceFactory();
    @Override
    public Invoice computeInvoice(VehicleReservation vehicleReservation) {
        if(vehicleReservation.getReservationStatus() == ReservationStatus.CANCELLED)
            return InvoiceBuilderUtil.buildCancelledInvoice(vehicleReservation);

        return invoiceServiceFactory.getInvoiceService(vehicleReservation.getVehicleReservationType())
                .computeInvoice(vehicleReservation);
    }
}
