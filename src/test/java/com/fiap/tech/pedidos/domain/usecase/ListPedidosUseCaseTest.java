package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.infra.entity.PedidoEntity;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListPedidosUseCaseTest {

	@InjectMocks
	private ListPedidosUseCase listPedidosUseCase;

	@Mock
	private PedidoRepository pedidoRepository;

	@Mock
	private PedidoMapper mapper;

	private PedidoEntity pedidoEntity1;

	private PedidoEntity pedidoEntity2;

	private Pedido pedido1;

	private Pedido pedido2;

	@BeforeEach
	void setUp() {
		pedidoEntity1 = new PedidoEntity();
		pedidoEntity1.setId(1L);

		pedidoEntity2 = new PedidoEntity();
		pedidoEntity2.setId(2L);

		pedido1 = new Pedido();
		pedido1.setId(1L);

		pedido2 = new Pedido();
		pedido2.setId(2L);
	}

	@Test
	void listarPedidos_DeveRetornarListaDePedidos() {
		when(pedidoRepository.findAll()).thenReturn(Arrays.asList(pedidoEntity1, pedidoEntity2));
		when(mapper.toDomain(pedidoEntity1)).thenReturn(pedido1);
		when(mapper.toDomain(pedidoEntity2)).thenReturn(pedido2);

		List<Pedido> resultado = listPedidosUseCase.listarPedidos();

		assertEquals(2, resultado.size());
		assertEquals(1L, resultado.get(0).getId());
		assertEquals(2L, resultado.get(1).getId());
	}

}
