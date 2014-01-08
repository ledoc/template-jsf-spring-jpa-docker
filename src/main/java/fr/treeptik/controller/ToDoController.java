package fr.treeptik.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.ToDo;
import fr.treeptik.service.ToDoService;

@ManagedBean()
@SessionScoped
public class ToDoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{toDoService}")
	private ToDoService toDoService;

	private ToDo toDo = new ToDo();

	private ListDataModel<ToDo> toDos = new ListDataModel<ToDo>();
	
	private Boolean ListEmpty;

	public String save() throws ServiceException {
		getToDoService().add(toDo);
		toDo = new ToDo();
		return "list";
	}

	public String delete() throws ServiceException {
		toDo = toDos.getRowData();
		getToDoService().delete(toDo.getId());
		toDo = new ToDo();
		return "list";

	}

	public ListDataModel<ToDo> getToDos() throws ServiceException {
		toDos = new ListDataModel<ToDo>(toDoService.getAll());
		return toDos;
	}

	public void setToDos(ListDataModel<ToDo> toDos) {
		this.toDos = toDos;
	}

	public ToDo getToDo() {
		return toDo;
	}

	public void setToDo(ToDo toDo) {
		this.toDo = toDo;
	}

	public ToDoService getToDoService() {
		return toDoService;
	}

	public void setToDoService(ToDoService toDoService) {
		this.toDoService = toDoService;
	}

	public Boolean getListEmpty() {
		return ListEmpty;
	}

	public void setListEmpty(Boolean listEmpty) {
		ListEmpty = listEmpty;
	}
}
