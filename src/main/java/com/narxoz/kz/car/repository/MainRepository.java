package com.narxoz.kz.car.repository;
import com.narxoz.kz.car.model.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainRepository extends JpaRepository<Main, Long> {
}