package lxp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lxp.dao.StudentMapper;
import lxp.entity.Student;

@RestController
public class text {
    
	
	@Autowired
	private StudentMapper studentMapper;
	
	@RequestMapping("/ll")
	public Object mas() {
		Student selectByPrimaryKey = studentMapper.selectByPrimaryKey(1);
		return selectByPrimaryKey;
	}
	
	@RequestMapping("/lt")
	public Object m() {
		Student selectByPrimaryKey = studentMapper.selectByPrimaryKey(1);
		return selectByPrimaryKey;
	}
	
}
