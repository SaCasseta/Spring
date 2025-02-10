package com.example.demo.view;

import com.example.demo.model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

@RestController

class Endpoint {


    private Usuario usuario;

    @GetMapping
    public String getUsuario() {
        if (usuario != null) {
            return usuario.toString();
        }
        return "Usuário não encontrado";
    }

    @PostMapping
    public String postUsuario(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone) {
        usuario = new Usuario(nome, cpf, telefone);
        return "Usuário criado com sucesso";
    }

    @PutMapping
    public String putUsuario(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf, @RequestParam(required = false) String telefone) {
        if (usuario != null) {
            if (nome != null) usuario.setNome(nome);
            if (cpf != null) usuario.setCpf(cpf);
            if (telefone != null) usuario.setTelefone(telefone);
            return "Usuário atualizado com sucesso";
        }
        return "Usuário não encontrado";
    }

    @DeleteMapping
    public String deleteUsuario() {
        if (usuario != null) {
            usuario = null;
            return "Usuário deletado com sucesso";
        }
        return "Usuário não encontrado";
    }


}

