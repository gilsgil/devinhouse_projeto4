package com.vila.devinhouse.projeto4.controller;

import com.vila.devinhouse.projeto4.model.User;
import com.vila.devinhouse.projeto4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public void setHabitanteRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Cadastra um habitante através da URL
    @PostMapping(value = "/habitante/create")
    public ResponseEntity<User> createHabitante(@RequestBody User newUser, Model model) {
        model.addAttribute("habitante", new User());
        User user = userRepository.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Exclui um habitante através da URL
    @DeleteMapping(value = "/habitante/delete/{id}")
    public void deleteHabitante(@PathVariable(value = "id") Long id) {
        userRepository.deleteById(id);
    }

    // Lista todos os habitantes
    @GetMapping(value = "/habitantes")
    public List getHabitantes() {
        return userRepository.findAllBy();
    }

    // Lista todos os habitantes por nome
    @GetMapping(value = "/habitantes/nome/{nome}")
    public List getHabitantesByName(@PathVariable(value = "nome") String nome) {
        return userRepository.findALlByNomeIgnoreCase(nome);
    }

    // Lista um habitante por ID
    @GetMapping(value = "/habitante/{id}")
    public Optional getHabitanteById(@PathVariable(value = "id") Long id) {
        return userRepository.findFirstById(id);
    }

    // Lista todos os habitantes por mês de nascimento
    @GetMapping(value = "/habitantes/mes/{mes}")
    public List getHabitantesByBirth(@PathVariable(value = "mes") int mes) {
        return userRepository.findAllByMesNascimento(mes);
    }

    // Lista todos os habitantes com idade superior ao valor informado

    @GetMapping(value = "/habitantes/idade/{idade}")
    public List getHabitantesByIdade(@PathVariable(value = "idade") int idade) {
        return userRepository.findAllOrderByIdadeGreaterThan(idade);
    }
}
