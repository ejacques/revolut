package br.com.erick.revolut.controller.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransferRequestDTO {

    @NotNull
    private BigDecimal amount;
    private PersonDTO source;
    private PersonDTO destiny;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PersonDTO getSource() {
        return source;
    }

    public void setSource(PersonDTO source) {
        this.source = source;
    }

    public PersonDTO getDestiny() {
        return destiny;
    }

    public void setDestiny(PersonDTO destiny) {
        this.destiny = destiny;
    }
}
