package com.marcos.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.marcos.bookstore.domain.Livro;
import com.marcos.bookstore.dtos.LivroDTO;
import com.marcos.bookstore.repositories.CategoriaRepository;
import com.marcos.bookstore.repositories.LivroRepository;
import com.marcos.bookstore.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LivroService {
    
    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + " , Tipo: " + Livro.class.getName()));    
    }

    /* -- Como eu fiz
    public List<Livro> findAll(){
        return repository.findAll();
    }
*/

    // Como foi ensinado à fazer
    public List<Livro> findAll(Integer id_cat){
        categoriaService.findById(id_cat);

        return repository.findAllByCategoria(id_cat);
    }

    public Livro create(Livro obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Livro update(Integer id, Livro obj){
        Livro newObj = findById(id);
        updateData(newObj,obj);        

        return repository.save(newObj);
    }

private void updateData(Livro newObj,Livro obj){
    newObj.setTitulo(obj.getTitulo());
    newObj.setTexto(obj.getTexto());
    newObj.setNome_autor(obj.getNome_autor());
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
