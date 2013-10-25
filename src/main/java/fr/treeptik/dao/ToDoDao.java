package fr.treeptik.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.ToDo;

public interface ToDoDao extends JpaRepository<ToDo, Integer> {

	List<ToDo> findAllByName(@Param("name") String name) throws DAOException;
}
