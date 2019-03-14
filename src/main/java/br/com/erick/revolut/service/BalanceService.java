package br.com.erick.revolut.service;

import br.com.erick.revolut.repository.DepositRepository;
import br.com.erick.revolut.repository.TransferRepository;
import br.com.erick.revolut.repository.entity.DepositEntity;

import javax.inject.Inject;
import java.math.BigDecimal;

public class BalanceService {

    @Inject
    private TransferRepository transferRepository;

    @Inject
    private DepositRepository depositRepository;

    public BigDecimal calculateBalance(final String accountNumber) {
        return BigDecimal.ZERO
                .add(getTransferBalance(accountNumber))
                .add(getDepositBalance(accountNumber));
    }

    private BigDecimal getTransferBalance(final String accountNumber) {
        return transferRepository.findByAccountNumber(accountNumber)
                .stream()
                .map(transferEntity -> {
                    if (accountNumber.equals(transferEntity.getSourceAccountNumber())) {
                        return transferEntity.getAmount().negate();
                    } else {
                        return transferEntity.getAmount();
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getDepositBalance(final String accountNumber) {
        return depositRepository.findByAccountNumber(accountNumber)
                .stream()
                .map(DepositEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
