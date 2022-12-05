package org.himanshu.service;

import org.himanshu.model.reservation.ReservationReminder;

public interface BookingReminderService {
    void notifyUser(ReservationReminder reservationReminder);
}
