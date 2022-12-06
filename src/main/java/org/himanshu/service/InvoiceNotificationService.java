package org.himanshu.service;

import org.himanshu.model.reservation.InvoiceNotification;

public interface InvoiceNotificationService {
    void notifyUser(InvoiceNotification invoiceNotification);
}
