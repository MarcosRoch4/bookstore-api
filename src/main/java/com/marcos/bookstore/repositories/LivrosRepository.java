package com.marcos.bookstore.repositories;



import java.util.List;

import com.marcos.bookstore.domain.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livro,Integer>{
/*
    @Query("SELECT obj FROM Livro obj WHERE obj.categoria_id = :id_cat ORDER BY titulo")
    List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);
*/
}

/**
 * public interface LivroRepository extends JpaRepository<Livro,Integer>{

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria_id = :id_cat ORDER BY titulo")
    List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);
    
}

 */