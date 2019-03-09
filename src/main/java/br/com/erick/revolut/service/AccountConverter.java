package br.com.erick.revolut.service;

import br.com.erick.revolut.controller.dto.AccountDTO;
import br.com.erick.revolut.repository.entity.AccountEntity;

public class AccountConverter {

    public static AccountDTO toDTO(final AccountEntity entity) {
        if (entity == null) {
            return null;
        }
        AccountDTO dto = new AccountDTO();
        dto.setNumber(entity.getNumber());
        dto.setName(entity.getName());
        return dto;
    }

    public static AccountEntity toEntity(final AccountDTO dto) {
        if (dto == null) {
            return null;
        }
        AccountEntity entity = new AccountEntity();
        entity.setNumber(dto.getNumber());
        entity.setName(dto.getName());
        return entity;
    }

}
