package com.invillia.acme.storeservice.validator;

import com.invillia.acme.storeservice.model.Store;
import com.invillia.acme.storeservice.service.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
  public class StoreValidator {

    @Autowired
    StoreRepository storeRepository;

    List<String> erros = new ArrayList();

    public void  validate(Long id, Store store){

        if(Objects.isNull(id)){
            erros.add("O id é obrigatório.");
        }

        if(Objects.isNull(store)){
            erros.add("Loja não é válida.");
        }

        Optional<Store> opt = storeRepository.findById(id);

        if(!opt.isPresent()){
            erros.add("Loja "+ id +" não encontrada no cadastro.");
        }
    }

    public boolean hasErrors(){
        return !erros.isEmpty();
    }

    public List<String> getErros(){
        return erros;
    }
}
