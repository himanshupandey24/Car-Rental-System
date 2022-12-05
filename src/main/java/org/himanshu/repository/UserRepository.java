package org.himanshu.repository;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;
import org.himanshu.model.account.User;
import org.himanshu.model.reservation.VehicleReservation;
import org.himanshu.model.vehicle.HireableVehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository implements AccountRepository{

    public static Map<String, User> userRegister = new HashMap<>();
    public static Map<String, User> userIdRegister = new HashMap<>();
    public static List<User> users = new ArrayList<>();

    @Override
    public Account createAccount(Account account) {
        userRegister.putIfAbsent(account.getEmail(), (User)account);
        userIdRegister.putIfAbsent(account.getId(), (User) account);
        return account;
    }

    @Override
    public void resetPassword(String userId, String password) throws AccountDoesNotExistsException {
        if(userRegister.get(userId) ==null)
            throw new AccountDoesNotExistsException("Account does not exist");

        userRegister.get(userId).setPassword(password);
    }

    public List<HireableVehicle> getHiredVehicles(String userId){
        List<VehicleReservation> vehicleReservationList = VehicleReservationRepository.vehicleReservations
                .stream().filter(vehicleReservation -> vehicleReservation.getUsrId().equalsIgnoreCase(userId))
                .collect(Collectors.toList());

        return vehicleReservationList.stream().map(vehicleReservation -> HireableVehicleRepository.vehicleRegister
                .get(vehicleReservation.getAllocatedVehicleId())).collect(Collectors.toList());
    }
 

}
