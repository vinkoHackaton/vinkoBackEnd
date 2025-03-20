package dev.team4.vinko.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.repositories.ElderlyUserRepository;

@RestController
@RequestMapping("/api/elderly-users")
public class ElderlyUserController {

}
