package br.com.marcio.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcio.pedidos.model.Pedido;
import br.com.marcio.pedidos.service.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
    //Controller: Contém os controladores

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Pedido> salvaPedido(@RequestBody Pedido produto){

        return ResponseEntity.ok().body(pedidoService.save(produto));

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarProduto(@PathVariable Long id){

        return ResponseEntity.ok().body(pedidoService.findById(id));

    }

    @GetMapping(value = "/buscar-todos")
    public ResponseEntity<List<Pedido>> buscarTodosProdutos(){

        return ResponseEntity.ok().body(pedidoService.findAll());
    }
}
