package com.multicampus.springboot.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private String tno;
    private String title;
    private String dueDate;
    private String writer;
    private String finished;
}
