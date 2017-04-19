package com.capgemini.repo;

import com.capgemini.dto.Account;
import com.capgemini.exceptions.DuplicateAccountNumberException;
import com.capgemini.exceptions.InvalidAccIdException;

public interface AccountRepo {

	boolean save(Account acc) throws DuplicateAccountNumberException;
	public boolean existAccount(int accid);
	public Account searchAccount(int accid) throws InvalidAccIdException;
	
}
