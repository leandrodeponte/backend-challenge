package com.invillia.acme.storeservice.service;

import com.invillia.acme.storeservice.AcmeStoreApplication;
import com.invillia.acme.storeservice.model.Store;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("Test_StoreService")
//@SpringBootTest(classes = AcmeStoreApplication.class)
public class Test_StoreService {

    //@Autowired
    private StoreService storeService;


    public void obtemPrestadorById_Prestador() {

        Long idStore = 13L;

        Store store = new Store();
        store.setId(idStore);
        store.setName("Lojas CEM");
        store.setAddress("Rua Episcopal");

        Mockito.when(storeService.findOneById(idStore))
                .thenReturn(store);

        Store s = storeService.findOneById(idStore);

        System.out.println(store.getName());
        System.out.println(s.getName());

        Assert.assertEquals("store names não são iguais",
                store.getName(),
                s.getName());

    }
}