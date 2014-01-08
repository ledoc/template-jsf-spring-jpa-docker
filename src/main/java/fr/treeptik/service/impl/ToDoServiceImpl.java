package fr.treeptik.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ToDoDao;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.ToDo;
import fr.treeptik.service.ToDoService;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ToDoDao toDoDao;

	@Override
	@Transactional
	public void add(ToDo toDo) throws ServiceException {
		try {
			toDoDao.save(toDo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<ToDo> getAll() throws ServiceException {

		List<ToDo> toDos = new ArrayList<>();
		try {
			toDos = toDoDao.findAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return toDos;
	}

	@Override
	public ToDo get(Integer id) throws ServiceException {
		try {
			return toDoDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) throws ServiceException {
		try {
			toDoDao.delete(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
