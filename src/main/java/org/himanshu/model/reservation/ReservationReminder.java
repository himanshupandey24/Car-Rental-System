package org.himanshu.model.reservation;

import lombok.Getter;
import lombok.Setter;
import org.himanshu.model.common.NotificationStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationReminder {
    private LocalDateTime reservationDate;
    private String reservationId;
    private String userId;
    private LocalDateTime createdDate;
    private NotificationStatus notificationStatus;
}
