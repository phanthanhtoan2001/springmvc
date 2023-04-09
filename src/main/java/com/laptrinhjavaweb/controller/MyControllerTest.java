package com.laptrinhjavaweb.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.mockito.plugins.MockMaker;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.laptrinhjavaweb.controller.Test.MyData;
import com.laptrinhjavaweb.controller.User.LoginController;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { LoginController.class })
public class MyControllerTest {

	private MockMvc mockMvc;
	@InjectMocks
	private LoginController loginController;

	@Before
	public void setup() {
		try {
			//mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		} catch (Exception ex) {
		}
	}

	

//    @Test
//    public void testValidLogin() throws Exception {
//        User user = new User("admin", "admin123");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(user);
//        
//        mockMvc.perform(post("/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Login successful"));
//    }
//    
	@Test
	public void testInvalidLogin() throws Exception {
//        User user = new User("admin", "wrongpassword");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(user);
		String json = "{ \"username\": \"myusername\", \"password\": \"mypassword\" }";
		mockMvc.perform(post("/user/login")
//                .contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isUnauthorized())
				.andExpect(content().string("Invalid username or password"));
	}

	@Test
	public void testAdd() {
		int result = add(2, 3);
		assertEquals(5, result);
		System.out.print(result);
	
	}
	@Test
	public void testFail() {
		int result = add(2, 4);
		assertEquals(5, result);
		System.out.print(result);
	
	}
	@Test
	public void testSubtract() {
		int result = subtract(5, 2);
		assertEquals(3, result);
		
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}


}
