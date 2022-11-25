package org.himanshu.repository;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;
import org.himanshu.model.account.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminRepository implements AccountRepository{

    public static Map<String, Admin> adminRegister = new HashMap<>();
    public static List<Admin> admins = new ArrayList<>();

    @Override
    public Account createAccount(Account account) {
        adminRegister.putIfAbsent(account.getEmail(), (Admin) account);
        return account;
    }

    @Override
    public void resetPassword(String userId, String password) throws AccountDoesNotExistsException {

    }
}
