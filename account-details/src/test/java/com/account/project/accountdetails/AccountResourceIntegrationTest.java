/**
 * PROTECTIVELY MARKED: IL2 - PROTECT
 * Copyright (C) 2017, MOPAC (Mayor's Officer for Policing and Crime), All Rights Reserved
 * <p>
 * Author: Narayana Rao
 */
package com.account.project.accountdetails;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.project.accountdetails.domain.Account;
import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AccountResourceIntegrationTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/account-project/rest/account/json");
    }

    @Test
    public void testGetDeviceIdFromLookupTable() throws URISyntaxException, JsonProcessingException {
        // Given

        // When
    	ResponseEntity<Account[]> responseEntity = template.getForEntity(base.toString(), Account[].class);

    	//System.out.println("MINALLLLL"+responseEntity.get);
        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals(3, responseEntity.getBody().length);



    }

}
