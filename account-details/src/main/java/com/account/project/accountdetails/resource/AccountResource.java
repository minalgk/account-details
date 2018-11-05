package com.account.project.accountdetails.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.project.accoundetails.dao.AccountRepository;
import com.account.project.accountdetails.domain.Account;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path = "/rest/account/json")
public class AccountResource {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> retrieveAllAccounts() {
		return accountRepository.findAll();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public Account saveAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}

	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable Long id) {
		accountRepository.deleteById(id);
		return "Account successfully deleted.";
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
}
