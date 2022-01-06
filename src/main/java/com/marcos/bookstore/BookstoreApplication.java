package com.marcos.bookstore;

import java.util.Arrays;

import com.marcos.bookstore.domain.Categoria;
import com.marcos.bookstore.domain.Livro;
import com.marcos.bookstore.repositories.CategoriaRepository;
import com.marcos.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática","Livros de TI");
		

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
}
