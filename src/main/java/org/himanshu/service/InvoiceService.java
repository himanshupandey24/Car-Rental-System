package org.himanshu.service;

import org.himanshu.model.reservation.Invoice;
import org.himanshu.model.reservation.VehicleReservation;

public interface InvoiceService {
    Invoice computeInvoice(VehicleReservation vehicleReservation);
}
