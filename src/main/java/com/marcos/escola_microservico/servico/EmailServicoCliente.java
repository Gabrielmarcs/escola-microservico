package com.marcos.escola_microservico.servico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.marcos.escola_microservico.modelo.EmailModelo;

@FeignClient(name = "email-servico", url = "localhost:8090/email")
public interface EmailServicoCliente {
    
    @PostMapping("/enviar")
    void enviarEmail(@RequestBody EmailModelo emailModelo);
}
