package com.example.seaside.cotroller;

import com.example.seaside.model.Produtos;
import com.example.seaside.service.produtosService;
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
@RequestMapping("/produtos")
public class produtosController {
    @Autowired
    produtosService produtosService;
    
    @PostMapping("/adicionar")
    public ResponseEntity<Produtos> addProduto(@RequestBody Produtos pro) {
        var novoProduto = produtosService.criar(pro);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Produtos> produto = produtosService.listarTodos();
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Produtos> pesquisar(@PathVariable Integer id) {
        Produtos produtoEncontrado = produtosService.buscarId(id);
        return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
    }
    
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Produtos> editProduto(@PathVariable Integer id, @RequestBody Produtos pro) {
        var atualizarProduto = produtosService.atualizar(id, pro);
        return new ResponseEntity<>(atualizarProduto, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        produtosService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
