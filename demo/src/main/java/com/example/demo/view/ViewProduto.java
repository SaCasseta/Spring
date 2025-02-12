package com.example.demo.view;

import com.example.demo.controller.ProdutoController;
import com.example.demo.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class ViewProduto {
    public static void main(String[] args) {
        SpringApplication.run(ViewProduto.class, args);
    }
}

@RestController
@RequestMapping("/produto")

class ProdutosView {


    ProdutoController pc = new ProdutoController();;

    @GetMapping
    public List<Produto> getAllProdutos(){
        return pc.pegarTodosOsProdutos();
    }
    @PostMapping
    public String postNovoProduto(@RequestBody Produto p){
        pc.inserirNoBanco(p);
        return "Sucesso";
    }

    @PutMapping
    public String putAtualizaProduto(@RequestBody Produto p) {
        pc.atualizarNoBanco(p);
        return "Att Feita";
    }

        @DeleteMapping
        public String deleteProduto (@RequestBody Produto p) {
        pc.deletarNoBanco(p.getIdProduto());
        return "deletado" + p.getIdProduto();

    }
}

