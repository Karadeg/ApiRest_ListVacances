package com.listVacances.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.listVacances.api.service.TaskService;

@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaskService taskService;

	@Test
	void testGetTasks() throws Exception {
		mockMvc.perform(get("/tasks"))
		.andExpect(status().isOk());
	}
	
	@Test
	void testGetTask() throws Exception {
		mockMvc.perform(get("/task/1"))
		.andExpect(status().isOk());
	}

}
