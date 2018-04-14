package com.ou.repository;

import com.ou.entity.Account;

public interface AccountRepository {

    Account findByUsername(String username);

    Account findById(long id);

    Account save(Account account);

}