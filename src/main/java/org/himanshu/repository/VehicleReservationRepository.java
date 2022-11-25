package org.himanshu.repository;

import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleReservationRepository {

    public static Map<String, VehicleReservation> vehicleReservationRegister = new HashMap<>();
    public static List<VehicleReservation> vehicleReservations = new ArrayList<>();

    public static List<VehicleReservation> getVehicleByType(String type, LocalDateTime fromDate, LocalDateTime toDate){
        return null;
    }

    public List<VehicleReservation> getVehicleReservations(VehicleType vehicleType) {
        return vehicleReservations.stream().filter(vehicleReservation ->
                        vehicleReservation.getVehicleType() == vehicleType)
                .collect(Collectors.toList());
    }

    public VehicleReservation reserve(VehicleReservation vehicleReservation) {

       vehicleReservationRegister.put(vehicleReservation.getReservationId(), vehicleReservation);
       vehicleReservations.add(vehicleReservation);

       return vehicleReservation;
    }

    public VehicleReservation getVehicleReservation(String reservationId) {
        return vehicleReservationRegister.get(reservationId);
    }
}
