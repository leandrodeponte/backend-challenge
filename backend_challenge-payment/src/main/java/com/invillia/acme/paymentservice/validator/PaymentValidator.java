package com.invillia.acme.paymentservice.validator;

import com.invillia.acme.paymentservice.model.OrderItem;
import com.invillia.acme.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class PaymentValidator {

    @Value("${url.acme.order_api}")
    private String url;

    @Autowired
    PaymentValidator paymentValidator;

    List<String> erros = new ArrayList();

    public void validate(Payment payment){

        if(Objects.isNull(payment)){
            erros.add("Pagamento não é válido.");
        }

        //TODO buscar da configuração
        //RestTemplate restTemplate = new RestTemplate();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<OrderItem>> response = restTemplate.exchange(
                "http://127.0.0.1:8080/api/orderm/"+payment.getIdOrder()+"/orderItemList/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderItem>>(){});
        List<OrderItem> orderItemList = response.getBody();

        //validar se pedido existe
        if(Objects.isNull(orderItemList) || orderItemList.isEmpty()){
            erros.add("Não há pedido para o pagamento requerido.");
        }

    }

    public boolean hasErrors(){
        return !erros.isEmpty();
    }

    public List<String> getErros(){
        return erros;
    }
}

