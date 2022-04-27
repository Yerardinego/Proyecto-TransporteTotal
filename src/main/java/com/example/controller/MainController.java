/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

/**
 *
 * @author yeral
 */
import com.example.Repositorio.VehiculoRepository;
import com.example.model.Vehiculo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired //traer el repo

    VehiculoRepository vehiculorepository; //crear una Variable de tipo Vehiculorepository

    @GetMapping("/Vehiculo")
    public List<Vehiculo> findAll() {
        return vehiculorepository.findAll();

    }

    @GetMapping("/servicios/{id}")
    public Optional<Vehiculo> findById(@PathVariable Long id) {
        return vehiculorepository.findById(id);
    }

    @PostMapping("/servicios")
    public String savePost(@RequestBody Vehiculo vehiculo) {
        vehiculorepository.save(vehiculo);
        return "ok";
    }

    @DeleteMapping("/servicios/{id}")
    public String delete(@PathVariable Long id) {
        vehiculorepository.deleteById(id);
        return "ok";
    }

}
