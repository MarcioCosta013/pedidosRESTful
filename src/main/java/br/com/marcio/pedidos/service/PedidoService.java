package br.com.marcio.pedidos.service;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcio.pedidos.model.Pedido;
import br.com.marcio.pedidos.model.Produto;
import br.com.marcio.pedidos.repository.PedidoRepository;
import br.com.marcio.pedidos.repository.ProdutoRepository;

@Service
public class PedidoService {
    //Service:Onde fica a Lógica de negócios.

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(Pedido pedido){
        Set<Produto> produtos = new HashSet<>();
        /*
         * Set--> representa uma coleção de elementos únicos, ou seja, não permite elementos duplicados.
         *
         * <Produto> --> define que esse Set armazenará apenas objetos do tipo Produto.
         *
         * new HashSet<>() --> implementação concreta da interface 'Set', Ele não garante ordem dos elementos,
         * pois a ordem pode mudar conforme os objetos são adicionados ou removidos.
         */

        pedido.setDataPedido(LocalDateTime.now());
        pedido.getProdutos().forEach(produto -> {
            produtos.add(produtoRepository.getById(produto.getId()));
        });
        pedido.setProdutos(produtos);

        return pedidoRepository.save(pedido);
    }

    public Pedido findById(Long id){
        return pedidoRepository.findById(id).orElse(null);

        /*
         * '.orElse(null)' --> Como findById(id) retorna um Optional<Pedido>, usamos .orElse(null) para dizer:
         *     - Se o Optional contiver um valor, retorna esse valor (Pedido).
         *       -Se o Optional estiver vazio (ou seja, não encontrou o Pedido), retorna null.
         *
         *   'Optional<>'--> Optional<T> é uma classe genérica usada para evitar problemas com valores null,
         *   ajudando a lidar com situações onde um valor pode ou não estar presente.
         */
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

}
