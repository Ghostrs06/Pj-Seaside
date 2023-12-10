package com.example.seaside.service;

import com.example.seaside.model.Produtos;
import com.example.seaside.repository.produtosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class produtosService {
    
    @Autowired
    produtosRepository produtosRepository;
    
    public Produtos criar(Produtos pro) {
        pro.setId(null);
        produtosRepository.save(pro);
        return pro;
    }
    
    public List<Produtos> listarTodos() {
        return produtosRepository.findAll();
    }
    
    public Produtos buscarId(Integer id) {
        return produtosRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id) {
        Produtos produtoEncotrado = buscarId(id);
        produtosRepository.deleteById(produtoEncotrado.getId());
    }
    
    public Produtos atualizar(Integer id, Produtos produtoEnviado) {
        Produtos produtoEncotrado = buscarId(id);
        produtoEncotrado.setNome(produtoEnviado.getNome());
        produtoEncotrado.setCod(produtoEnviado.getCod());
        produtoEncotrado.setDataFabricacao(produtoEnviado.getDataFabricacao());
        produtoEncotrado.setDataVencimento(produtoEnviado.getDataVencimento());
        produtoEncotrado.setValor(produtoEnviado.getValor());
        produtoEncotrado.setVendido(produtoEnviado.getVendido());
        produtosRepository.save(produtoEnviado);
        return produtoEncotrado;
    }
}
