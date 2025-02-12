package com.example.demo.controller;
import com.example.demo.database.BancoDeProdutos;
import com.example.demo.model.Produto;
import java.util.List;
public class ProdutoController {
    BancoDeProdutos bc = new BancoDeProdutos();
    public void inserirNoBanco(Produto p) {
        bc.insert(p);
    }
    public List<Produto> pegarTodosOsProdutos() {
        return bc.findAll();
    }

    public void atualizarNoBanco(Produto p){
        bc.update(p);
    }

    public void deletarNoBanco(int p){
        bc.delete(p);
    }
}