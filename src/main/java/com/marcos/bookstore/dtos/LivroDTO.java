package com.marcos.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.marcos.bookstore.domain.Livro;

import org.hibernate.validator.constraints.Length;

public class LivroDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;

    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 3, max = 50,message = "Campo TITULO deve ter entre 3 e 50 caracteres")
    private String titulo;
    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 50,message = "Campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
    private String nome_autor;
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 10, max = 2000000,message = "Campo TITULO deve ter entre 10 e 2.000.000 caracteres")
    private String texto;

    public LivroDTO(){
        super();
    }

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.nome_autor = obj.getNome_autor();
        this.texto = obj.getTexto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

        
}
