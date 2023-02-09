package com.example.last_exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.last_exam.Class.Post;
import com.example.last_exam.Service.PostRepository;
import com.example.last_exam.Service.TagRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/add")
    public String addPostGet(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("tags", tagRepository.findAll());
        return "Post/add";
    }

    @PostMapping("/add")
    public String addPostPost(@Valid Post post, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
        model.addAttribute("tags", tagRepository.findAll());
            return "Post/add";
        }
        postRepository.save(post);
        return "redirect:/post/add";
    }
}
