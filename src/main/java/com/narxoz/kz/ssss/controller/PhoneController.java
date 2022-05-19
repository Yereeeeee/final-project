package com.narxoz.kz.ssss.controller;
import com.narxoz.kz.ssss.model.Car;
import com.narxoz.kz.ssss.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @GetMapping("category")
    public List<Car> getAll() {
        return phoneRepository.findAll();
    }
}
