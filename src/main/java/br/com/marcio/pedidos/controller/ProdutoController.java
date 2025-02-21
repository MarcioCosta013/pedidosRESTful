package br.com.marcio.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcio.pedidos.model.Produto;
import br.com.marcio.pedidos.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    //Controller: Contém os controladores

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) throws Exception {
        
        return ResponseEntity.ok().body(produtoService.save(produto));

    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {

        return ResponseEntity.ok().body(produtoService.findById(id));

    }

    @GetMapping(value = "/buscar-todos")
    public ResponseEntity<List<Produto>> buscarTodosProdutos( ) {

        return ResponseEntity.ok().body(produtoService.findAll());

    }

}
