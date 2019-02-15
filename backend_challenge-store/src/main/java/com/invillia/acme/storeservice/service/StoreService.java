package com.invillia.acme.storeservice.service;

import com.invillia.acme.storeservice.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public Store findOneById(Long id){
        return storeRepository.findOneById(id);
    }

    public Store findById(Long id){
        return storeRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Loja não encontrada"));
    }

    public Store save(Store store){
        store.setId(null);
        return storeRepository.save(store);
    }

    public Store update(Long id, Store current){

        Optional<Store> storeValidate = storeRepository.findById(id);
        Store storeUpdated = new Store();

        if(!storeValidate.isPresent()){
           return null;
        }

        storeUpdated =
                this.updateStoreData(storeValidate.get(), current);

        storeRepository.save(storeUpdated);

        return storeUpdated;

    }

    private Store updateStoreData(Store old, Store current){

        old.setAddress(current.getAddress());
        old.setName(current.getName());

        return old;

    }

}
