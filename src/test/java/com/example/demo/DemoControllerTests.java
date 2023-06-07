package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DemoControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPreflightCorsRequest() throws Exception {
		this.mockMvc.perform(
						options("/api/demo")
								.header("Access-Control-Request-Method", "GET")
								.header("Origin", "http://cors:5000")
				)
				.andExpect(status().isOk())
				.andExpect(header().string("Access-Control-Allow-Origin", "*"))
				.andExpect(header().string("Access-Control-Max-Age", "1800"));
	}

}
