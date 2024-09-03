package com.marcos.escola_microservico.servico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email-servico", url = "http://localhost:8090")
public interface EmailServicoCliente {
    
    @PostMapping("/email/enviar")
    void enviarEmail(@RequestParam("para") String para, @RequestParam("assunto") String assunto, @RequestParam("mensagem") String mensagem);
}
