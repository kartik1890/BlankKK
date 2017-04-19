package com.capgemini.serviceimpl;

import com.capgemini.dto.Account;
import com.capgemini.exceptions.DuplicateAccountNumberException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalance;
import com.capgemini.exceptions.InvalidAccIdException;
import com.capgemini.repo.AccountRepo;
import com.capgemini.repoimpl.AccountRepoImpl;
import com.capgemini.service.AccountService;

public class AccountServiceImpl implements AccountService{

	AccountRepo repo=new AccountRepoImpl();
	@Override
	public Account createAccount(int accid,int balance) throws InsufficientInitialBalance, DuplicateAccountNumberException {
		
		Account acc= new Account();
		acc.setAccountId(accid);
		
		if(balance<500) 
				throw new InsufficientInitialBalance();
		acc.setBalance(balance);
				
		
		repo.save(acc);
		return acc;
	}

	@Override
	public boolean depositAccount(int accid, int amount) throws InvalidAccIdException {
		int updatedBalance;
		updatedBalance =repo.searchAccount(accid).getBalance()+amount;
		repo.searchAccount(accid).setBalance(updatedBalance);
		return true;
		
	}

	@Override
	public boolean withdrawAccount(int accid, int amount) throws InsufficientBalanceException, InvalidAccIdException {
		int updatedBalance;
		int oldBalance=repo.searchAccount(accid).getBalance();
		if(oldBalance<amount)
			throw new InsufficientBalanceException();
		else
		{
			updatedBalance=oldBalance-amount;
			repo.searchAccount(accid).setBalance(updatedBalance);
		
		return true;
		}
	}
	
	

}
