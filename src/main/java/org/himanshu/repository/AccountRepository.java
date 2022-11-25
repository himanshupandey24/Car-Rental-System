package org.himanshu.repository;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;

public interface AccountRepository {
    Account createAccount(Account account);
    void resetPassword(String userId, String password) throws AccountDoesNotExistsException;
}
