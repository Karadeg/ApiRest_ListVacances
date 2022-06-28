package com.listVacances.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.listVacances.api.model.Task;

@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{

}
