package br.com.erick.revolut.service.converter;

import br.com.erick.revolut.controller.dto.TransferDTO;
import br.com.erick.revolut.repository.entity.TransferEntity;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.Assert;
import org.junit.Test;

import static br.com.erick.revolut.mock.TransferMock.mockDTO;
import static br.com.erick.revolut.mock.TransferMock.mockDTOWithoutDestinationAccount;
import static br.com.erick.revolut.mock.TransferMock.mockEntity;

@MicronautTest
public class TransferConverterTest {

    @Test
    public void testToDTOOk() {
        //Given
        TransferEntity entity = mockEntity();

        //When
        TransferDTO converted = TransferConverter.toDTO(entity);

        //Then
        Assert.assertEquals(mockDTO(), converted);
    }

    @Test
    public void testToEntityOk() {
        //Given
        TransferDTO dto = mockDTO();

        //When
        TransferEntity converted = TransferConverter.toEntity(dto);

        //Then
        Assert.assertEquals(mockEntity(), converted);
    }

    @Test
    public void testToEntityWithoutDestinationAccount() {
        //Given
        TransferDTO dto = mockDTOWithoutDestinationAccount();

        //When
        TransferEntity converted = TransferConverter.toEntity(dto);

        //Then
        Assert.assertNull(converted.getDestinationAccountNumber());
        Assert.assertNotEquals(mockEntity(), converted);
    }

}
