package com.example.seaside.repository;

import com.example.seaside.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vendasRepository extends JpaRepository<Vendas, Integer>{}
