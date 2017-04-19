package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.dto.Account;
import com.capgemini.exceptions.DuplicateAccountNumberException;
import com.capgemini.exceptions.InsufficientInitialBalance;
import com.capgemini.serviceimpl.AccountServiceImpl;

public class AccountServiceTestCase {
	
	AccountServiceImpl accImpl= new AccountServiceImpl();
	
	/*
	 * Testcase for Initial amount less than expected amount 
	 */
	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialBalance.class)
	public void insufficientInitialBalanceException() throws InsufficientInitialBalance, DuplicateAccountNumberException {
		accImpl.createAccount(10, 400);
	}
	
	/*
	 * Testcase for valid create account
	 */
	
	@Test
	public void successCreatAccount() throws InsufficientInitialBalance, DuplicateAccountNumberException {
		Account acc= new Account();
		acc.setAccountId(10);            
		acc.setBalance(600);
		
		assertEquals(acc, accImpl.createAccount(10, 600));
		;
	}

	/*
	 * Testcase for account number alreday exists
	 */
	@Test(expected=DuplicateAccountNumberException.class)
	public void duplicateAccountNumber() throws InsufficientInitialBalance, DuplicateAccountNumberException
	{
				
		accImpl.createAccount(101, 600);
		accImpl.createAccount(101, 600);
		
	}
}
