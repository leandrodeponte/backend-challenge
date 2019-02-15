package com.invillia.acme.paymentservice.validator;

import com.invillia.acme.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Component
public class PaymentValidator {

    @Value("${url.frontend.recuperar.senha}")
    private String url;

    @Autowired
    PaymentValidator paymentValidator;

    List<String> erros = new ArrayList();

    public void validate(Payment payment){

        if(Objects.isNull(payment)){
            erros.add("Pagamento não é válido.");
        }

        RestTemplate restTemplate = new RestTemplate();
        OrderM order = restTemplate.getForObject(
                "url" + "/order/"+payment.getIdOrder(),
                OrderM.class);

        if(Objects.isNull(order)){
            erros.add("Não há pedido para o pagamento requerido.");
        }

        //TODO validar se pedido existe
        //TODO validar se o valor do pagamento é igual ao pedido



        if(false){
            erros.add("Pedido não encontrado no sistema.");
        }
    }

    public boolean hasErrors(){
        return !erros.isEmpty();
    }

    public List<String> getErros(){
        return erros;
    }
}

