package com.invillia.acme.paymentservice.validator;

import com.invillia.acme.paymentservice.model.OrderItem;
import com.invillia.acme.paymentservice.model.OrderM;
import com.invillia.acme.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
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

        RestTemplate restTemplate = new RestTemplate();

         ResponseEntity<OrderM> exchange =
                 restTemplate.exchange(url + payment.getIdOrder(),
                            HttpMethod.GET, null, OrderM.class);

         OrderM responseBody = exchange.getBody();


        //validar se pedido existe
        if(Objects.isNull(responseBody)){
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

