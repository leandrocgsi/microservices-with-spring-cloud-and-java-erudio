package br.com.erudio.proxy;

import br.com.erudio.dto.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

// @FeignClient(name = "exchange-service")
//@FeignClient(name = "exchange-service", url = "${EXCHANGE_SERVICE_SERVICE_HOST:http://host.docker.internal}:8000")
@FeignClient(name = "exchange-service", url = "${EXCHANGE_SERVICE_URI:http://host.docker.internal}:8000")
public interface ExchangeProxy {

    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    public Exchange getExchange(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to);
}

//EXCHANGE_SERVICE_SERVICE_HOST