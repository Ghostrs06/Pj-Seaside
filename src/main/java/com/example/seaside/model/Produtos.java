package com.example.seaside.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cadastro")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    
    private String nome;
    
    private int cod;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFabricacao;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimento;
    
    private float valor;
    
    private String vendido;
}
