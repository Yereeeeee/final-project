package com.narxoz.kz.car.controller;

import com.narxoz.kz.car.model.Main;
import com.narxoz.kz.car.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    MainRepository repository;

    @GetMapping("/")
    public String showMainList(Model model) {
        List<Main> jewelry = repository.findAll();
        // Check if `param` is not empty
        model.addAttribute("jewelry", jewelry);
        return "index";
    }

    @PostMapping("/addmain")
    public String createMain(@ModelAttribute Main main) {
        addMain(main);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateMain(@PathVariable("id") long id, Main main) {
        updateMain(main);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteMain(@PathVariable("id") long id) {
        deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Main main) {
        return "add-car";
    }



    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Main main = repository.getById(id);
        model.addAttribute("main", main);
        return "update-car";
    }

    private void deleteById(long id) {
        repository.deleteById(id);
    }

    private void addMain(Main newMain) {
        repository.save(newMain);
    }

    private void updateMain(Main updateMain) {
        Main oldMain = repository.getById(updateMain.getId());

        oldMain.setName(updateMain.getName());
        oldMain.setMarka(updateMain.getMarka());
        oldMain.setWeight(updateMain.getWeight());
        oldMain.setPrice(updateMain.getPrice());

        repository.save(oldMain);
    }
}