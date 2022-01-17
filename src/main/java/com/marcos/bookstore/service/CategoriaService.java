package com.marcos.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.marcos.bookstore.domain.Categoria;
import com.marcos.bookstore.dtos.CategoriaDTO;
import com.marcos.bookstore.repositories.CategoriaRepository;
import com.marcos.bookstore.service.exceptions.DataIntegrityViolationException;
import com.marcos.bookstore.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.spi.ThrowableProxyUtil;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;
    
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update (Integer id,CategoriaDTO objDTO){
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {

            //throw new com.marcos.bookstore.service.exceptions.DataIntegrityViolationException(
             //   "Categoria não pode ser deletada! Possui livros associados.");

             throw (e);
        }


    }

}
