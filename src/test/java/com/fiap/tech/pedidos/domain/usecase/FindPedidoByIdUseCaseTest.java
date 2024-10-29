package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.exception.ResourceNotFoundException;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.infra.entity.PedidoEntity;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPedidoByIdUseCaseTest {

	@InjectMocks
	private FindPedidoByIdUseCase findPedidoByIdUseCase;

	@Mock
	private PedidoRepository pedidoRepository;

	@Mock
	private PedidoMapper mapper;

	private PedidoEntity pedidoEntity;

	private Pedido pedido;

	@BeforeEach
	void setUp() {
		pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(1L);

		pedido = new Pedido();
		pedido.setId(1L);
	}

	@Test
	void buscarPorId_DeveRetornarPedidoQuandoExistir() {
		when(pedidoRepository.findById(anyLong())).thenReturn(Optional.of(pedidoEntity));
		when(mapper.toDomain(pedidoEntity)).thenReturn(pedido);

		Pedido resultado = findPedidoByIdUseCase.buscarPorId(1L);

		assertEquals(1L, resultado.getId());
	}

	@Test
	void buscarPorId_DeveLancarExcecaoQuandoPedidoNaoExistir() {
		when(pedidoRepository.findById(anyLong())).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> findPedidoByIdUseCase.buscarPorId(1L));
	}

}
