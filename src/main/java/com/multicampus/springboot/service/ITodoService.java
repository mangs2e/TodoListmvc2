package com.multicampus.springboot.service;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.PageResponseDTO;
import com.multicampus.springboot.dto.TodoDTO;

import java.util.List;

public interface ITodoService {
    public List<TodoDTO> selectAll();
    public int insert(TodoDTO todoDTO);
    public TodoDTO view(String tno);
    public int modify(TodoDTO todoDTO);
    public int remove(String tno);
    public PageResponseDTO<TodoDTO> search(PageRequestDTO pageRequestDTO);
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
