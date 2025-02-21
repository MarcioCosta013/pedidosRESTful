package br.com.marcio.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcio.pedidos.exception.ProductNullExcetion;
import br.com.marcio.pedidos.exception.ProductPriceException;
import br.com.marcio.pedidos.model.Produto;
import br.com.marcio.pedidos.repository.ProdutoRepository;


@Service
public class ProdutoService {
    //Service:Onde fica a Lógica de negócios.
   
    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) throws Exception{

        if (produto.getNome() == null || produto.getPreco() == null) {
            throw new ProductNullExcetion();

            //impede de salvar com nome e preço vazio/nulo.
        }
        if (produto.getPreco() < 0) {
            throw new ProductPriceException(); //Todo: falta criar...
        }

        return repository.save(produto);
    }

    public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}
}

