package org.himanshu.service;

import org.himanshu.model.account.User;
import org.himanshu.model.common.NotificationStatus;
import org.himanshu.model.reservation.ReservationReminder;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.repository.UserRepository;
import org.himanshu.repository.VehicleReservationRepository;

public class BookingReminderServiceImpl implements BookingReminderService{

    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();


    @Override
    public void notifyUser(ReservationReminder reservationReminder) {
        VehicleReservation vehicleReservation = vehicleReservationRepository
                .getVehicleReservation(reservationReminder.getReservationId());

        User user = UserRepository.userRegister.get(vehicleReservation.getUsrId());

        System.out.println("Notified User : " + user.getContact().getEmail());
        reservationReminder.setNotificationStatus(NotificationStatus.SENT);
    }
}
