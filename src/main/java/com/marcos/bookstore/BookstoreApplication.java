package com.marcos.bookstore;

import java.util.Arrays;


import com.marcos.bookstore.repositories.CategoriaRepository;
import com.marcos.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication{

	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
