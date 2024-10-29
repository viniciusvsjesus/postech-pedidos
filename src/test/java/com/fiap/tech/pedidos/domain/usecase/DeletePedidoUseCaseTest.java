package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.domain.exception.ResourceNotFoundException;
import com.fiap.tech.pedidos.infra.entity.PedidoEntity;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeletePedidoUseCaseTest {

	@InjectMocks
	private DeletePedidoUseCase deletePedidoUseCase;

	@Mock
	private PedidoRepository pedidoRepository;

	@BeforeEach
	void setUp() {
	}

	@Test
	void deletarPedido_DeveExcluirPedidoExistente() {
		PedidoEntity pedidoExistente = new PedidoEntity();
		when(pedidoRepository.findById(anyLong())).thenReturn(Optional.of(pedidoExistente));

		deletePedidoUseCase.deletarPedido(1L);

		verify(pedidoRepository, times(1)).deleteById(anyLong());
	}

	@Test
	void deletarPedido_DeveLancarExcecaoQuandoPedidoNaoExistir() {
		when(pedidoRepository.findById(anyLong())).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> deletePedidoUseCase.deletarPedido(1L));

		verify(pedidoRepository, never()).deleteById(anyLong());
	}

}
