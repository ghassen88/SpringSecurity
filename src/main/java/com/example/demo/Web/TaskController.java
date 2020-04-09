package com.example.demo.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entites.Task;
import com.example.demo.repositories.TaskRepository;


@RestController
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(value = "tasks",method = RequestMethod.GET)
	public List<Task> getTasks(){
		return taskRepository.findAll();
	}
	

	@RequestMapping(value ="tasks",method = RequestMethod.POST)
	public Task saveTask(@RequestBody Task task)
	{
		return taskRepository.save(task);
	}
}
