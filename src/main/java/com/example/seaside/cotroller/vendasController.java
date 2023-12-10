package com.example.seaside.cotroller;

import com.example.seaside.model.Vendas;
import com.example.seaside.service.vendasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class vendasController {
    
    @Autowired
    vendasService vendasservice;
    
    @PostMapping("/adicionar")
    public ResponseEntity<Vendas> addVenda(@RequestBody Vendas ven) {
        var novaVenda = vendasservice.criar(ven);
        return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Vendas> venda = vendasservice.listarTodos();
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Vendas> pesquisar(@PathVariable Integer id) {
        Vendas vendaEncontrado = vendasservice.buscarId(id);
        return new ResponseEntity<>(vendaEncontrado, HttpStatus.OK);
    }
    
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Vendas> editProduto(@PathVariable Integer id, @RequestBody Vendas ven) {
        var atualizarVenda = vendasservice.atualizar(id, ven);
        return new ResponseEntity<>(atualizarVenda, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        vendasservice.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
