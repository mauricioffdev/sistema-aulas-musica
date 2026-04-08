package com.mauricioffdev.sistema.service;

import com.mauricioffdev.sistema.model.Pagamento;
import com.mauricioffdev.sistema.repository.PagamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PagamentoServiceTest {

    @Mock
    private PagamentoRepository repository;

    @InjectMocks
    private PagamentoService service;

    @Test
    void registrarPagamento_deveSalvarPagamentoNoRepositorio() {
        Pagamento pagamento = new Pagamento();

        service.registrarPagamento(pagamento);

        verify(repository, times(1)).save(pagamento);
    }

    @Test
    void listarTodos_deveRetornarPagamentosDoRepositorio() {
        List<Pagamento> pagamentos = List.of(new Pagamento(), new Pagamento());
        when(repository.findAll()).thenReturn(pagamentos);

        List<Pagamento> resultado = service.listarTodos();

        assertEquals(pagamentos, resultado);
        verify(repository, times(1)).findAll();
    }
}
