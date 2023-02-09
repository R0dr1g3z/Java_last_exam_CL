package com.example.last_exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.last_exam.Class.Tag;
import com.example.last_exam.Service.PostRepository;
import com.example.last_exam.Service.TagRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private PostRepository postRepository;
    
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

    @GetMapping("/all")
    public String allTag(Model model){
        model.addAttribute("tags", tagRepository.findAll());
        return "Tag/all";
    }

    @GetMapping("/{id}/change")
    public String activeChange(@PathVariable int id){
        Tag tag = tagRepository.findById(id);
        if (tag.isActive() == true){
            tag.setActive(false);
        } else {
            tag.setActive(true);
        }
        tagRepository.save(tag);
        return "redirect:/tag/all";
    }

    @GetMapping("/{id}/posts")
    public String tagPosts(Model model, @PathVariable int id){
        model.addAttribute("posts", postRepository.findByTagsId(id));
        return "Tag/tagPosts";
    }
}
