package br.com.erick.revolut.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonIgnoreProperties
public class TransferDTO {

    private String transactionId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime instant;
    private AccountDTO source;
    private AccountDTO destination;
    private BigDecimal amount;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferDTO that = (TransferDTO) o;
        return Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(instant, that.instant) &&
                Objects.equals(source, that.source) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, instant, source, destination, amount);
    }
}
