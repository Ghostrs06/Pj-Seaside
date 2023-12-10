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
@Table(name = "Vendas")
public class Vendas {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Integer id;
   
   private String nome;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date dataVenda;
   
   private int cod;
   
   private String comprador;
   
   private float total;
   
}
