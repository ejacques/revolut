package br.com.erick.revolut.service;

import br.com.erick.revolut.controller.dto.AccountDTO;
import br.com.erick.revolut.repository.AccountsRepository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class AccountService {

    private AccountsRepository accountsRepository;

    public AccountService(final AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public List<AccountDTO> findAll() {
        //TODO:remove
        mocks().stream().forEach(this::saveOrUpdate);

        return accountsRepository.findAll().stream()
                .map(AccountConverter::toDTO)
                .collect(Collectors.toList());
    }

    public void saveOrUpdate(AccountDTO dto) {
        accountsRepository.insert(AccountConverter.toEntity(dto));
    }

    //TODO: remove
    public List<AccountDTO> mocks() {
        List<AccountDTO> dtos = new ArrayList<>();
        AccountDTO dto = new AccountDTO();
        dto.setNumber("0001112229");
        dto.setName("Erick Jacques");
        dto.setType("CHECKING ACCOUNT");
        dtos.add(dto);

        dto = new AccountDTO();
        dto.setNumber("0003333439");
        dto.setName("Dave Navarro");
        dto.setType("CHECKING ACCOUNT");
        dtos.add(dto);

        dto = new AccountDTO();
        dto.setNumber("1231233202");
        dto.setName("James Hetfield");
        dto.setType("CHECKING ACCOUNT");
        dtos.add(dto);

        return dtos;
    }



}
