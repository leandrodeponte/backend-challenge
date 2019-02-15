package com.invillia.acme.storeservice.config;

import com.invillia.acme.storeservice.service.StoreService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


//@Profile("Test_StoreService")
//@Configuration
public class StoreService_MockTest {
    //@Bean
    //@Primary
    public StoreService storeService() {
        return Mockito.mock(StoreService.class);
    }
}


