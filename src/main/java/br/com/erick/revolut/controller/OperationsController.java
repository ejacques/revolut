package br.com.erick.revolut.controller;


import br.com.erick.revolut.controller.dto.DepositRequestDTO;
import br.com.erick.revolut.controller.dto.TransferRequestDTO;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Options;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller("/operations")
public class OperationsController {

    @Options
    public HttpResponse<List<String>> availableOperations() {
        throw new UnsupportedOperationException();
    }

    @Post("/transfer")
    public HttpResponse<Void> transfer(@Body @Valid TransferRequestDTO payload) {
        throw new UnsupportedOperationException();
    }

    @Post("/deposit")
    public HttpResponse<Void> deposit(@Body @Valid DepositRequestDTO payload) {
        throw new UnsupportedOperationException();
    }
}
