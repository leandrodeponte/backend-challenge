package com.invillia.acme.storeservice.service;

import com.invillia.acme.storeservice.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long>{

    Store findOneById(Long id);

    List<Store> findByNameContaining(String name);

    @Query("SELECT s FROM Store s where s.name like %:name% AND s.address like %:address%")
    public Optional<List<Store>> findAllByNameAndAddressContaining(String name, String address);

}
