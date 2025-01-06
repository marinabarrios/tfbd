package com.example.tf;

import com.example.tf.model.Bank;
import com.example.tf.repositories.BankRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class TfApplicationTests {

	@Autowired
    private BankRepository bankRepository;

    @Test
    public void testSaveBank() {
        // Creo una instancia de Bank
        Bank bank = new Bank("Banco Test", "20-12345678-9", "Calle Falsa 123", "123456789");

        // Guardo el banco y obtener el objeto guardado
        Bank savedBank = bankRepository.customSave(bank);

        // Verifico que se guardó correctamente
        assertThat(savedBank.getId()).isNotNull();
        assertThat(savedBank.getName()).isEqualTo("Banco Test");
    }

    @Test
    public void testUpdateBank() {
        // Creo y guardo una instancia inicial de Bank
        Bank bank = new Bank("Banco Inicial", "20-11111111-1", "Calle Original 123", "987654321");
        Bank savedBank = bankRepository.customSave(bank);

        // Verifico que el banco fue guardado correctamente
        assertThat(savedBank.getId()).isNotNull();
        assertThat(savedBank.getName()).isEqualTo("Banco Inicial");

        // Modifico algunos atributos del banco
        savedBank.setName("Banco Actualizado");
        savedBank.setAddress("Calle Actualizada 456");

        // Llamo al método update
        Bank updatedBank = bankRepository.customUpdate(savedBank);

        // Verifico que los cambios se hayan persistido
        assertThat(updatedBank.getName()).isEqualTo("Banco Actualizado");
        assertThat(updatedBank.getAddress()).isEqualTo("Calle Actualizada 456");

        // Recupero el banco desde la base de datos y verifico los cambios
        Bank retrievedBank = bankRepository.findById(updatedBank.getId()).orElse(null);
        assertThat(retrievedBank).isNotNull();
        assertThat(retrievedBank.getName()).isEqualTo("Banco Actualizado");
        assertThat(retrievedBank.getAddress()).isEqualTo("Calle Actualizada 456");
    }
}
