package org.himanshu.service;

import org.himanshu.model.reservation.AddonService;
import org.himanshu.model.reservation.VehicleAddOn;
import org.himanshu.model.reservation.VehicleReservation;

public class AddonCostUtil {
    public static double computeEquipmentCost(VehicleReservation vehicleReservation){
        double vehicleAddOnCost = 0;
        if(vehicleReservation.getVehicleAddOns() != null && vehicleReservation.getVehicleAddOns().size() > 0){
            for(VehicleAddOn vehicleAddOn : vehicleReservation.getVehicleAddOns()){
                vehicleAddOnCost += vehicleAddOn.getCost();
            }
        }

        return vehicleAddOnCost;
    }

    public static double computeServiceCost(VehicleReservation vehicleReservation){
        double addOnServiceCost = 0;
        if(vehicleReservation.getAddonServices() != null && vehicleReservation.getAddonServices().size() >= 0){
            for(AddonService addonService : vehicleReservation.getAddonServices()){
                addOnServiceCost += addonService.getCost();
            }
        }
        return addOnServiceCost;
    }
}
