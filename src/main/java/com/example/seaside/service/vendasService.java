package com.example.seaside.service;

import com.example.seaside.model.Vendas;
import com.example.seaside.repository.vendasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vendasService {
    
    @Autowired
    vendasRepository vendasRepository;
    
    public Vendas criar(Vendas ven) {
        ven.setId(null);
        vendasRepository.save(ven);
        return ven;
    }
    
    public List<Vendas> listarTodos() {
        return vendasRepository.findAll();
    }
    
    public Vendas buscarId(Integer id) {
        return vendasRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id) {
        Vendas vendaEncotrado = buscarId(id);
        vendasRepository.deleteById(vendaEncotrado.getId());
    }
    
    public Vendas atualizar(Integer id, Vendas vendaEnviado) {
        Vendas vendaEncotrado = buscarId(id);
        vendaEncotrado.setNome(vendaEnviado.getNome());
        vendaEncotrado.setDataVenda(vendaEnviado.getDataVenda());
        vendaEncotrado.setCod(vendaEnviado.getCod());
        vendaEncotrado.setComprador(vendaEnviado.getComprador());
        vendaEncotrado.setTotal(vendaEnviado.getTotal());
        vendasRepository.save(vendaEnviado);
        return vendaEncotrado;
    }
    
}
