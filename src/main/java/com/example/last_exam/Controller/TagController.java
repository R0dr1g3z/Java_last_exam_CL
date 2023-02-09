package com.example.last_exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.last_exam.Class.Tag;
import com.example.last_exam.Service.TagRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;
    
    @GetMapping("/add")
    public String addTagGet(Model model){
        model.addAttribute("tag", new Tag());
        return "Tag/add";
    }

    @PostMapping("/add")
    public String addTagPost(@Valid Tag tag, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "Tag/add";
        }
        tagRepository.save(tag);
        return "redirect:/tag/add";
    }
}
