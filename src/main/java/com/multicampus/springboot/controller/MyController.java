package com.multicampus.springboot.controller;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.TodoDTO;
import com.multicampus.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @Autowired
    ITodoService service;

    @RequestMapping("/")
    public @ResponseBody
    String root() {
        return "mvc_todo Project";
    }

//    @GetMapping("list")
//    public String list(Model model) {
//        model.addAttribute("list",service.selectAll());
//        System.out.println("select 성공");
//        return "list";
//    }

    @GetMapping("view")
    public String view(HttpServletRequest req, Model model) {
        String tno = req.getParameter("tno");
        model.addAttribute("dto",service.view(tno));
        System.out.println("view 성공");
        return "view";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("registerProcess")
    public String registerProcess(TodoDTO dto) throws Exception{
        int rResult = service.insert(dto);
        System.out.println("insert 성공");
        return "redirect:list";
    }

    @GetMapping("modify")
    public String modify(HttpServletRequest req, Model model){
        String tno = req.getParameter("tno");
        model.addAttribute("dto",service.view(tno));
        return "modify";
    }

    @PostMapping("modifyProcess")
    public String modifyProcess(TodoDTO dto) throws Exception
    {
        if(dto.getFinished() == null) {
            dto.setFinished("0");
        }else{
            dto.setFinished("1");
        }

        int nResult = service.modify(dto);
        System.out.println("modify 성공");
        System.out.println("수정 count: "+nResult);
        return "redirect:list";
    }

    @GetMapping("remove")
    public String remove(HttpServletRequest req) throws Exception {
        String tno = req.getParameter("tno");
        int nResult = service.remove(tno);
        System.out.println("Delete: "+nResult);
        System.out.println("delete 성공");
        return "redirect:list";
    }

    @GetMapping("search")
    public String search(Model model, PageRequestDTO pageRequestDTO) {

        model.addAttribute("responseDTO",service.search(pageRequestDTO));
        System.out.println("search 성공");
        System.out.println(pageRequestDTO.getStartDate());
        System.out.println(pageRequestDTO.getEndDate());
        System.out.println(pageRequestDTO.getSearchContent());
        return "list";
    }

    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()) {
//            pageRequestDTO = PageRequestDTO.builder().build();
//        }
        model.addAttribute("responseDTO",service.getList(pageRequestDTO));
        System.out.println("Paging list");
        System.out.println(pageRequestDTO.getPage());
        System.out.println(pageRequestDTO.getSize());
//        return "list";
    }
}
