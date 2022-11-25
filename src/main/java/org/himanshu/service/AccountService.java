package org.himanshu.service;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;
import org.himanshu.model.account.AccountType;

public interface AccountService {
    Account createAccount(Account account, AccountType accountType);

    void resetPassword(String userId, String password, AccountType accountType) throws AccountDoesNotExistsException;


}
