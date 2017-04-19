package com.capgemini.repoimpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.dto.Account;
import com.capgemini.exceptions.DuplicateAccountNumberException;
import com.capgemini.exceptions.InvalidAccIdException;
import com.capgemini.repo.AccountRepo;

public class AccountRepoImpl implements AccountRepo {

	List<Account> accList = new LinkedList<>();

	@Override
	public boolean save(Account acc) throws DuplicateAccountNumberException {

		if (acc != null ) {
			
			if(existAccount(acc.getAccountId()))
					{
				throw new DuplicateAccountNumberException();
					}
			accList.add(acc);
		}
		return false;
	}

	public boolean existAccount(int accid) {
		for (Iterator iterator = accList.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			if (account.getAccountId() == accid)
				return true;

		}
		return false;

	}
	
	public Account searchAccount(int accid) throws InvalidAccIdException {
		for (Iterator iterator = accList.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			if (account.getAccountId() == accid)
				return account;

		}
		throw new InvalidAccIdException();

	}
	
	public void displayRepo()
	{
		for (Iterator iterator = accList.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			System.out.println(account.getAccountId());
			System.out.println(account.getBalance());
		}
		
	}
}
