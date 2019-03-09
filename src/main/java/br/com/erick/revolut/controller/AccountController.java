package br.com.erick.revolut.controller;

import br.com.erick.revolut.controller.dto.AccountDTO;
import br.com.erick.revolut.controller.dto.TransferDTO;
import br.com.erick.revolut.service.AccountService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import java.util.List;

@Validated
@Controller("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Get
    public HttpResponse<List<AccountDTO>> getAccounts() {
        return HttpResponse.ok(accountService.findAll());
    }

    @Post
    public HttpResponse<AccountDTO> createAccount(String name, String type) {
        throw new UnsupportedOperationException();
    }

    @Get("/{accountNumber}")
    public HttpResponse<AccountDTO> getAccount(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    @Get("/{accountNumber}/transfers")
    public HttpResponse<List<TransferDTO>> getTransfers(String accountNumber) {
        throw new UnsupportedOperationException();
    }

}
