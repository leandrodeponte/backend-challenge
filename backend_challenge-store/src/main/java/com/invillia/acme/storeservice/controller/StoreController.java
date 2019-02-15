package com.invillia.acme.storeservice.controller;

import com.invillia.acme.storeservice.model.Store;
import com.invillia.acme.storeservice.service.StoreRepository;
import com.invillia.acme.storeservice.service.StoreService;
import com.invillia.acme.storeservice.validator.StoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreService storeService;

    @Autowired
    StoreValidator storeValidator;

    @GetMapping("/store/{id}")
    public ResponseEntity<Store> get(
            @PathVariable(value = "id") Long id
    ) {
        Store store = storeRepository.findOneById(id);

        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @GetMapping("/store")
    public ResponseEntity<List<Store>> get(
            @RequestParam(value = "name") String name
    ) {
        List<Store> storeList = storeRepository.findByNameContaining(name);

        return new ResponseEntity<List<Store>>(storeList, HttpStatus.OK);
    }

    @PostMapping("/store")
    public ResponseEntity<Store> post(
            @RequestBody Store store
    ) {

        Store storeSaved = storeService.save(store);

        return ResponseEntity.ok().body(storeSaved);
    }

    @PutMapping("/store/{id}")
    public ResponseEntity<Store> put(
            @PathVariable( value = "id") Long id,
            @RequestBody Store store
    ) {
        storeValidator.validate(id, store);

        if(storeValidator.hasErrors()){
            return new ResponseEntity(storeValidator, HttpStatus.PRECONDITION_FAILED);
        }

        Store storeUpdated = storeService.update(id, store);

        return ResponseEntity.ok().body(storeUpdated);
    }
}
