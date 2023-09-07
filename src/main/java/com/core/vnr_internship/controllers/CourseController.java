package com.core.vnr_internship.controllers;

import com.core.vnr_internship.daos.KhoaHocDAO;
import com.core.vnr_internship.daos.MonHocDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CourseController {
    @Autowired
    KhoaHocDAO khDAO;
    @Autowired
    MonHocDAO mhDAO;
    @GetMapping({"/index","/home"})
    public String renderHome(Model model){
        model.addAttribute("danhSachMonHoc",null);
        model.addAttribute("danhSachKhoaHoc",khDAO.findAll());
        return "index";
    }

    @GetMapping("/khoahoc/{id}")
    public String renderMonHoc(Model model, @PathVariable("id") Optional<Integer> id){
        model.addAttribute("danhSachMonHoc",mhDAO.findByKhoaHocId(id.orElse(1)));
        model.addAttribute("danhSachKhoaHoc",khDAO.findAll());
        return "index";
    }
}
