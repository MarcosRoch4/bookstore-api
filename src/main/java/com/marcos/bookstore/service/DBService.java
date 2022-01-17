package com.marcos.bookstore.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

import com.marcos.bookstore.config.DevConfig;
import com.marcos.bookstore.domain.Categoria;
import com.marcos.bookstore.domain.Livro;
import com.marcos.bookstore.repositories.CategoriaRepository;
import com.marcos.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Service
public class DBService {

    @Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

    public void instaciaBaseDeDados(){

        Categoria cat1 = new Categoria(null,"Informática","Livros de TI");
		Categoria cat2 = new Categoria(null,"Ficção Científica","Livros de Ficção Científica");
		Categoria cat3 = new Categoria(null,"Biografia","Livros de Biografia");
		Categoria cat4 = new Categoria(null,"Romance","Livros de Romance");
		

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H. G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The War Of the Worlds", "H. G. Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat3);
		Livro l6 = new Livro(null, "End Of Eternity", "Isaac Asimov", "Lorem ipsum", cat3);
		

		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4));
		cat3.getLivros().addAll(Arrays.asList(l5,l6));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
    }

    @Bean
    public boolean instaciaBaseDeDados(DevConfig devConfig){
        if(devConfig.strategy.equals("create"))
            instaciaBaseDeDados();
    
        return false;
    }
    
}
