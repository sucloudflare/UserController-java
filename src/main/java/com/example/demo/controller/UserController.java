package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Criar um novo usuário
    @PostMapping
    public ResponseEntity<User> criarUsuario(@RequestBody User usuario) {
        User novoUsuario = userRepository.save(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {
        List<User> usuarios = userRepository.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Buscar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<User> usuario = userRepository.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar um usuário
    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable Long id, @RequestBody User usuarioAtualizado) {
        Optional<User> usuarioExistente = userRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            User usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            userRepository.save(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}