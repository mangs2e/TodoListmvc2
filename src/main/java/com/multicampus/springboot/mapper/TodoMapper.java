package com.multicampus.springboot.mapper;

import com.multicampus.springboot.domain.TodoVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);
}
