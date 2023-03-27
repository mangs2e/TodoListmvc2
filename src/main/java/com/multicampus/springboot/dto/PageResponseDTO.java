package com.multicampus.springboot.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO<E> {

    private int page; // 현재 페이지
    private int size; // 한 페이지당 갯수
    private int total; // 전체 글 갯수

    //한그룹의 시작페이지 넘버
    private int start;

    //한그룹의 끝 페이지 넘버
    private int end;

    //이전 페이지그룹 존재여부
    private boolean prev;
    //다음 페이지그룹 존재여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();


        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page/10.0))*10;  // 31/10 -> 3.1 -> 4 -> 40
        this.start = this.end - 9; //31

        int last = (int)(Math.ceil((total/(double)size))); // 330/10  34(총페이지 수)

        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size; //40 * 10 = 400
    }


}
