package org.himanshu.service;

import org.himanshu.model.account.User;
import org.himanshu.model.common.NotificationStatus;
import org.himanshu.model.reservation.InvoiceNotification;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.repository.UserRepository;
import org.himanshu.repository.VehicleReservationRepository;

public class InvoiceNotificationServiceImpl implements InvoiceNotificationService{
    @Override
    public void notifyUser(InvoiceNotification invoiceNotification) {
        VehicleReservation vehicleReservation = VehicleReservationRepository
                .vehicleReservationRegister.get(invoiceNotification.getReservationID());

        User user = UserRepository.userRegister.get(vehicleReservation.getUsrId());
        System.out.println("Notification sent " + user.getContact().getEmail());
        invoiceNotification.setNotificationStatus(NotificationStatus.SENT);
    }
}
