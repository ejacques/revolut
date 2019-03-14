package br.com.erick.revolut.controller.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransferRequestDTO {

    @NotNull
    private BigDecimal amount;
    private AccountDTO source;
    private AccountDTO destination;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccountDTO getSource() {
        return source;
    }

    public void setSource(AccountDTO source) {
        this.source = source;
    }

    public AccountDTO getDestination() {
        return destination;
    }

    public void setDestination(AccountDTO destination) {
        this.destination = destination;
    }
}
