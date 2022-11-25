package org.himanshu.model.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class VehicleAddOn {
    private String id;
    private String name;
    private String description;
    private double cost;
}
