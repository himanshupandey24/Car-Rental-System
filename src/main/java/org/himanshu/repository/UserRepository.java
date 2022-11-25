package org.himanshu.repository;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;
import org.himanshu.model.account.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    }
}
