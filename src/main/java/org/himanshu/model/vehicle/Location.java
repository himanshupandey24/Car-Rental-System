package org.himanshu.model.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.himanshu.model.common.Address;
import org.himanshu.model.common.Coordinates;

@Getter
@Setter
public class Location {
    private String locationId;
    private Address address;
    private Coordinates coordinates;
}
