package com.listVacances.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.listVacances.api.model.Task;
import com.listVacances.api.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tasks")
	public Iterable<Task> getTasks(){
		return taskService.getTasks();
	}
	
	/**
	 * Retrieve the task with the desire id
	 * @author Karadeg Daucé
	 * @param id
	 * @return Task
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/task/{id}")
	public Task getTask(@PathVariable("id") final Long id) {
		Optional<Task> task = taskService.getTask(id);
		if (task.isPresent()) {
			return task.get();
		} else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/task/{id}")
	public Task updateTask(@PathVariable("id") final Long id, @RequestBody Task task) {
		Optional<Task> t = taskService.getTask(id);
		if (t.isPresent()) {
			
			Task currentTask = t.get();
			
			if (task.getName() != null) {
				currentTask.setName(task.getName());
			}
			if (task.getDescription() != null) {
				currentTask.setDescription(task.getDescription());
			}
			if(task.getDone() != null) {
				currentTask.setDone(task.getDone());
			}
			if (task.getIdUser() != null) {
				currentTask.setIdUser(task.getIdUser());
			}
			
			taskService.saveTask(currentTask);
			return currentTask;
		} else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/task/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		taskService.deleteTask(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/task")
	public void createTask(@RequestBody Task task) {
		taskService.saveTask(task);
	}
}
