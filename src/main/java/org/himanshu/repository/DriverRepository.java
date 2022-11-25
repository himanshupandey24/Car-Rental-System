package org.himanshu.repository;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;
import org.himanshu.model.account.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRepository implements AccountRepository{
    public static Map<String, Driver> driverRegister = new HashMap<>();
    public static List<Driver> drivers = new ArrayList<>();
    @Override
    public Account createAccount(Account account) {
        driverRegister.putIfAbsent(account.getEmail(), (Driver) account);
        return account;
    }

    @Override
    public void resetPassword(String userId, String password) throws AccountDoesNotExistsException {

    }
}
