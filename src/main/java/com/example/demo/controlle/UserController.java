package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    private List<User> usuarios = new ArrayList<>();
    private Long proximoId = 1L;

    // Criar um novo usuário
    @PostMapping
    public ResponseEntity<User> criarUsuario(@RequestBody User usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Buscar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<User> usuario = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar um usuário
    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable Long id, @RequestBody User usuarioAtualizado) {
        Optional<User> usuarioExistente = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (usuarioExistente.isPresent()) {
            User usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        boolean removido = usuarios.removeIf(u -> u.getId().equals(id));
        return removido ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}