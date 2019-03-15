package br.com.erick.revolut.service;

import br.com.erick.revolut.controller.dto.AccountDTO;
import br.com.erick.revolut.repository.AccountsRepository;
import br.com.erick.revolut.service.converter.AccountConverter;
import io.micronaut.context.annotation.Primary;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Singleton
public class AccountService {

    @Inject
    private AccountsRepository accountsRepository;

    @Inject
    private BalanceService balanceService;

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
                .map(AccountConverter::toDTO)
                .map(dto -> {
                    dto.setBalance(calculateBalance(accountNumber));
                    return dto;
                });
    }

    public void saveOrUpdate(AccountDTO dto) {
        accountsRepository.insert(AccountConverter.toEntity(dto));
    }

    public BigDecimal calculateBalance(final String accountNumber) {
        return balanceService.calculateBalance(accountNumber);
    }

}
