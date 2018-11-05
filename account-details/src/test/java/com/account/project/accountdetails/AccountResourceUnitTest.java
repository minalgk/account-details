package com.account.project.accountdetails;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.project.accoundetails.dao.AccountRepository;
import com.account.project.accountdetails.domain.Account;
import com.account.project.accountdetails.resource.AccountResource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceUnitTest {

    private AccountResource accountResource;
    private AccountRepository mockAccountRepository;

    @Before
    public void setUp() {
    	mockAccountRepository = mock(AccountRepository.class);
        accountResource = new AccountResource();
        accountResource.setAccountRepository(mockAccountRepository);
    }

    @Test
    public void getAllAccountDetailsTest() throws Exception {
        // Given
        List<Account> sampleAccountDetails = new ArrayList<>();
        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("Unit");
        account.setLastName("Test");
		sampleAccountDetails.add(account);
		
		given(mockAccountRepository.findAll()).willReturn(sampleAccountDetails);
        // When
		List<Account> allAccountDetails = accountResource.retrieveAllAccounts();

        // Then
        assertNotNull(allAccountDetails);
        assertEquals(account.getFirstName(), allAccountDetails.get(0).getFirstName());
        verify(mockAccountRepository).findAll();
    }
    
    @Test
    public void saveAccountTest() throws Exception {
        // Given
        List<Account> sampleAccountDetails = new ArrayList<>();
        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("Unit");
        account.setLastName("Test");
		sampleAccountDetails.add(account);
		
		given(mockAccountRepository.save(any(Account.class))).willReturn(any(Account.class));
        // When
		accountResource.saveAccount(account);

        // Then
        verify(mockAccountRepository).save(any(Account.class));
    }
    
    @Test
    public void deleteAccountTest() throws Exception {
        // Given
        List<Account> sampleAccountDetails = new ArrayList<>();
        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("Unit");
        account.setLastName("Test");
		sampleAccountDetails.add(account);
		
		given(mockAccountRepository.findAll()).willReturn(sampleAccountDetails);
        // When
		List<Account> allAccountDetails = accountResource.retrieveAllAccounts();

        // Then
        assertNotNull(allAccountDetails);
        assertEquals(account.getFirstName(), allAccountDetails.get(0).getFirstName());
        verify(mockAccountRepository).deleteById(any(Long.class));
    }
}