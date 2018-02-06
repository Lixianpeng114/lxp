package lxp.dao;

import lxp.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studnetId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studnetId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}