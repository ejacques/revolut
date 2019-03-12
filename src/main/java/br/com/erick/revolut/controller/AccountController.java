package br.com.erick.revolut.controller;

import br.com.erick.revolut.controller.dto.AccountDTO;
import br.com.erick.revolut.controller.dto.TransferDTO;
import br.com.erick.revolut.service.AccountService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import java.util.List;

@Validated
@Controller("/accounts")
public class AccountController {

    @Inject
    private AccountService accountService;

    @Get
    public HttpResponse<List<AccountDTO>> getAccounts(@QueryValue(value = "showBalance", defaultValue = "false") boolean showBalance) {
        return HttpResponse.ok(accountService.findAll(showBalance));
    }

    @Get("/{accountNumber}")
    public HttpResponse<AccountDTO> getAccount(String accountNumber) {
        return accountService.findByAccountNumber(accountNumber)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Get("/{accountNumber}/transfers")
    public HttpResponse<List<TransferDTO>> getTransfers(String accountNumber) {
        throw new UnsupportedOperationException();
    }

}
