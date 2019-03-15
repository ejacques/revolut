package br.com.erick.revolut.mock;

import br.com.erick.revolut.controller.dto.TransferDTO;
import br.com.erick.revolut.repository.entity.TransferEntity;

public class TransferMock {

    public static TransferEntity mockEntity() {
        return TransferBuilder.getInstance()
                .withInstant()
                .withAmount()
                .withDestinationAccount()
                .withSourceAccount()
                .withTransactionId()
                .buildEntity();
    }

    public static TransferDTO mockDTO() {
        return TransferBuilder.getInstance()
                .withInstant()
                .withAmount()
                .withDestinationAccount()
                .withSourceAccount()
                .withTransactionId()
                .buildDTO();
    }

    public static TransferDTO mockDTOWithoutDestinationAccount() {
        return TransferBuilder.getInstance()
                .withInstant()
                .withAmount()
                .withSourceAccount()
                .withTransactionId()
                .buildDTO();
    }
}
