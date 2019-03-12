package br.com.erick.revolut.service;

import br.com.erick.revolut.controller.dto.AccountDTO;
import br.com.erick.revolut.repository.AccountsRepository;
import br.com.erick.revolut.repository.DepositRepository;
import br.com.erick.revolut.repository.TransferRepository;
import br.com.erick.revolut.repository.entity.DepositEntity;
import br.com.erick.revolut.service.converter.AccountConverter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class AccountService {

    @Inject
    private AccountsRepository accountsRepository;

    @Inject
    private DepositRepository depositRepository;

    @Inject
    private TransferRepository transferRepository;

    public List<AccountDTO> findAll(final boolean showBalance) {
        return accountsRepository.findAll().stream()
                .map(AccountConverter::toDTO)
                .map(accountDTO -> {
                    if (showBalance) {
                        accountDTO.setBalance(calculateBalance(accountDTO.getNumber()));
                    }
                    return accountDTO;
                })
                .collect(Collectors.toList());
    }

    public Optional<AccountDTO> findByAccountNumber(final String accountNumber) {
        return accountsRepository.findByAccountNumber(accountNumber)
                .map(AccountConverter::toDTO);
    }

    public void saveOrUpdate(AccountDTO dto) {
        accountsRepository.insert(AccountConverter.toEntity(dto));
    }

    public BigDecimal calculateBalance(final String accountNumber) {
        return BigDecimal.ZERO
                .add(getTransferBalance(accountNumber))
                .add(getDepositBalance(accountNumber));
    }

    //TODO: move to TransferService
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

    //TODO: move to DepositService
    private BigDecimal getDepositBalance(final String accountNumber) {
        return depositRepository.findByAccountNumber(accountNumber)
                .stream()
                .map(DepositEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
