package com.multicampus.springboot.service;

import com.multicampus.springboot.dao.ITodoDAO;
import com.multicampus.springboot.dto.TodoDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@SpringBootTest
@DisplayName("TodoList 서비스 테스트")
public class TodoServiceTest {

    @Autowired
    TodoService service;
    @Autowired
    ITodoDAO dao;

    @Nested
    @DisplayName("test!")
    class Test1 {
        @DisplayName("특정 한개 글 보기")
//    @Disabled("일시적으로 테스트 중단")
        @ParameterizedTest
        @CsvSource(value={"11","17"})
        void view(String tno) throws Exception {
//        String tno = "15";
            TodoDTO todoDTO = service.view(tno);
//        assertThat(todoDTO.getTitle()).isEqualTo("test10");
            Assertions.assertNotNull(todoDTO);
        }

        //@Test
        @RepeatedTest(10)
        @DisplayName("모든 글 출력")
        void selectAll() throws Exception{
            List<TodoDTO> list = dao.selectAllDAO();
//        list.forEach(todoDTO -> System.out.println());
            Assertions.assertNotNull(list);
        }
    }

//    @Test
//    @DisplayName("특정 한개 글 보기")
////    @Disabled("일시적으로 테스트 중단")
//    @ParameterizedTest
//    @CsvSource(value={"11","17"})
//    void view(String tno) throws Exception {
////        String tno = "15";
//        TodoDTO todoDTO = service.view(tno);
////        assertThat(todoDTO.getTitle()).isEqualTo("test10");
//        Assertions.assertNotNull(todoDTO);
//    }
//
//    //@Test
//    @RepeatedTest(10)
//    @DisplayName("모든 글 출력")
//    void selectAll() throws Exception{
//        List<TodoDTO> list = dao.selectAllDAO();
////        list.forEach(todoDTO -> System.out.println());
//        Assertions.assertNotNull(list);
//    }

    @Test
    @DisplayName("값이 정상적으로 들어올 때 게시글 작성")
    void insert() throws Exception{
        TodoDTO dto = new TodoDTO();
        service.insert(dto);
        Assertions.assertNotNull(dto);
    }

//    @Test
//    void modify() {
//    }
//
//    @Test
//    void remove() {
//    }
//
//    @Test
//    void search() {
//    }
//
//    @Test
//    void getList() {
//    }
}