package org.himanshu.model.reservation;

import lombok.Getter;
import lombok.Setter;
import org.himanshu.model.common.Address;
import org.himanshu.model.common.Coordinates;

@Getter
@Setter
public class RentalLocation {
    private String id;
    private Address address;
    private Coordinates coordinates;
}
