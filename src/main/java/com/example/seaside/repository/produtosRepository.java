package com.example.seaside.repository;

import com.example.seaside.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface produtosRepository extends JpaRepository<Produtos, Integer>{}
