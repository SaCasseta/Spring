package com.example.demo.view;

import com.example.demo.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class ViewProduto {
    public static void main(String[] args) {
        SpringApplication.run(ViewProduto.class, args);
    }
}

@RestController
@RequestMapping("/produto")

class ProdutosView {


    private Produto p1;

    @GetMapping
    public String getProduto() {
        if (p1 != null) {
            return p1.toString();
        }
        return "Produto não encontado";
    }

    @PostMapping
    public String postProduto(@RequestBody Produto produto) {
        p1 = produto;
        return "Produto criado com sucesso" + p1.toString();
    }

    @PutMapping
    public String putProduto(@RequestBody Produto produto) {
        if (p1 == null) {
           return null;
        }
        p1.setNomeProduto(produto.getNomeProduto());
        p1.setIdProduto(produto.getIdProduto());
        p1.setPontoDeVenda(produto.getPontoDeVenda());
        p1.setQuantidade(produto.getQuantidade());
        p1.setDescricao(produto.getDescricao());
        p1.setPreco(produto.getPreco());
        return p1.toString();
    }

    @DeleteMapping
    public String deleteUsuario() {
        if (p1 != null) {
            p1 = null;
            return "produto deletado com sucesso";
        }
        return "produto não encontrado";
    }


}

