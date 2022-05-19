package com.narxoz.kz.ssss.controller;

import com.narxoz.kz.ssss.model.Car;
import com.narxoz.kz.ssss.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    PhoneRepository repository;

    @GetMapping("")
    public String showPhoneList(Model model) {
        List<Car> cars = repository.findAll();
        // Check if `param` is not empty
        model.addAttribute("cars", cars);
        return "index";
    }

    @PostMapping("/addphone")
    public String createPhone(@ModelAttribute Car car) {
        addPhone(car);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updatePhone(@PathVariable("id") long id, Car car) {
        updatePhone(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePhone(@PathVariable("id") long id) {
        deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Car car) {
        return "add-phone";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Car car = repository.getById(id);
        model.addAttribute("car", car);
        return "update-phone";
    }

    private void deleteById(long id) {
        repository.deleteById(id);
    }

    private void addPhone(Car newCar) {
        repository.save(newCar);
    }

    private void updatePhone(Car updateCar) {
        Car oldCar = repository.getById(updateCar.getId());

        oldCar.setName(updateCar.getName());
        oldCar.setMarka(updateCar.getMarka());
        oldCar.setMemory(updateCar.getMemory());
        oldCar.setRam(updateCar.getRam());
        oldCar.setCountry(updateCar.getCountry());
        oldCar.setPrice(updateCar.getPrice());

        repository.save(oldCar);
    }
}