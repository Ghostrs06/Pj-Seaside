package com.example.seaside.cotroller;

import com.example.seaside.model.Produtos;
import com.example.seaside.model.Vendas;
import com.example.seaside.service.produtosService;
import com.example.seaside.service.vendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class seasideController {
    @Autowired
    produtosService produtosService;
    
    @Autowired
    vendasService vendasService;
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
    @GetMapping("/listagem")
    public String lista(Model model) {
        model.addAttribute("lista", produtosService.listarTodos());
        model.addAttribute("listavenda", vendasService.listarTodos());
        return "listagem";
    }
    
    @GetMapping("/cadastro")
    public String cadastroProduto(Model model) {
        model.addAttribute("produto", new Produtos());
        return "cadastro";
    }
    
    @GetMapping("/venda")
    public String vendaProduto(Model model) {
        model.addAttribute("venda", new Vendas());
        return "venda";
    }
    
    @PostMapping("/gravarvenda")
    public String processarFormVenda(@ModelAttribute Vendas venda, Model model) {
        vendasService.criar(venda);
        return "redirect:/listagem";
    }
    
    @PostMapping("/gravar")
    public String processarFormProduto(@ModelAttribute Produtos produto, Model model) {
        produtosService.criar(produto);
        return "redirect:/listagem";
    }
    
    @GetMapping("/excluir")
    public String excluirProduto(Model model, @RequestParam String id) {
        Integer idProduto = Integer.parseInt(id);
        produtosService.excluir(idProduto);
        return "redirect:/listagem";
    }
    
    @GetMapping("/alterar")
    public String alterarProduto(Model model, @RequestParam String id){    
        Integer idFilme = Integer.parseInt(id);
        Produtos produtoEncontrado = produtosService.buscarId(idFilme);
        model.addAttribute("produto", produtoEncontrado);
        return "alterar";
    }
    
    @GetMapping("/excluirVenda")
    public String excluirVenda(Model model, @RequestParam String id) {
        Integer idVenda = Integer.parseInt(id);
        vendasService.excluir(idVenda);
        return "redirect:/listagem";
    }
    
    @GetMapping("/alterarVenda")
    public String alterarAvaliacao(Model model, @RequestParam String id){    
        Integer idVenda = Integer.parseInt(id);
        Vendas vendaEncontrado = vendasService.buscarId(idVenda);
        model.addAttribute("venda", vendaEncontrado);
        return "alterarVenda";
    }
}
