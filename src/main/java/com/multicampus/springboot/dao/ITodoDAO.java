package com.multicampus.springboot.dao;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.PageResponseDTO;
import com.multicampus.springboot.dto.TodoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITodoDAO {
    public List<TodoDTO> selectAllDAO();
    public int insertDAO(TodoDTO todoDTO);
    public TodoDTO viewDAO(String tno);
    public int modifyDAO(TodoDTO todoDTO);
    public int removeDAO(String tno);
    public List<TodoDTO> searchDAO(PageRequestDTO pageRequestDTO);
    public List<TodoDTO> selectList(PageRequestDTO pageRequestDTO);
    public int getCount(PageRequestDTO pageRequestDTO);
    public int searchCount(PageRequestDTO pageRequestDTO);
}
