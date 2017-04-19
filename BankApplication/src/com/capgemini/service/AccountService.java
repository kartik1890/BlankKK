package com.capgemini.service;

import com.capgemini.dto.Account;
import com.capgemini.exceptions.DuplicateAccountNumberException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalance;
import com.capgemini.exceptions.InvalidAccIdException;

public interface AccountService {

	Account createAccount(int accid,int balance) throws InsufficientInitialBalance, DuplicateAccountNumberException;
	boolean depositAccount(int accid, int amount) throws InvalidAccIdException;
	boolean withdrawAccount(int accid, int amount) throws InsufficientBalanceException, InvalidAccIdException;
	
}
