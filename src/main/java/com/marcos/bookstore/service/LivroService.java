package com.marcos.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.marcos.bookstore.domain.Livro;
import com.marcos.bookstore.dtos.LivroDTO;
import com.marcos.bookstore.repositories.LivroRepository;
import com.marcos.bookstore.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LivroService {
    
    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + " , Tipo: " + Livro.class.getName()));    
    }

    public List<Livro> findAll(){
        return repository.findAll();
    }

    public Livro create(Livro obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Livro update(Integer id, LivroDTO objDTO){
        Livro obj = findById(id);
        obj.setTitulo(objDTO.getTitulo());
        obj.setTexto(objDTO.getTexto());
        obj.setNome_autor(objDTO.getNome_autor());

        return repository.save(obj);
    }

    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new com.marcos.bookstore.service.exceptions.DataIntegrityViolationException(
                "Livro não pode ser deletado! Pois está associados à alguma coisa.");
        }

    }


}
