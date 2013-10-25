package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.ToDo;

public interface ToDoService {

	public void add(ToDo toDo) throws ServiceException;

	public List<ToDo> getAll() throws ServiceException;

	public ToDo get(Integer id) throws ServiceException;

	public void delete(Integer id) throws ServiceException;
}
