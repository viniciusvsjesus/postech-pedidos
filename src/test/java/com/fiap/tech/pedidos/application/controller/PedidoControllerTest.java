package com.fiap.tech.pedidos.application.controller;

import com.fiap.tech.pedidos.application.controller.dto.RequestPedidoDTO;
import com.fiap.tech.pedidos.application.controller.dto.ResponsePedidoDTO;
import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.domain.usecase.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {

	@InjectMocks
	private PedidoController pedidoController;

	@Mock
	private FindPedidoByIdUseCase findPedidoByIdUseCase;

	@Mock
	private ListPedidosUseCase listPedidosUseCase;

	@Mock
	private CreatePedidoUseCase createPedidoUseCase;

	@Mock
	private DeletePedidoUseCase deletePedidoUseCase;

	@Mock
	private PedidoMapper pedidoMapper;

	private Pedido pedido;

	private RequestPedidoDTO requestPedidoDTO;

	private ResponsePedidoDTO responsePedidoDTO;

	@BeforeEach
	void setUp() {
		pedido = new Pedido();
		pedido.setId(1L);
		pedido.setDataPedido(null);
		pedido.setDataEntrega(null);

		requestPedidoDTO = new RequestPedidoDTO();
		responsePedidoDTO = new ResponsePedidoDTO();
	}

	@Test
	void listarPedidos_DeveRetornarListaDePedidos() {
		when(listPedidosUseCase.listarPedidos()).thenReturn(Collections.singletonList(pedido));
		when(pedidoMapper.toDTO(any(Pedido.class))).thenReturn(responsePedidoDTO);

		List<ResponsePedidoDTO> resultado = pedidoController.listarPedidos();

		assertEquals(1, resultado.size());
		verify(listPedidosUseCase, times(1)).listarPedidos();
		verify(pedidoMapper, times(1)).toDTO(any(Pedido.class));
	}

	@Test
	void buscarPedidoPorId_DeveRetornarPedido() {
		when(findPedidoByIdUseCase.buscarPorId(anyLong())).thenReturn(pedido);

		Pedido resultado = pedidoController.buscarPedidoPorId(1L);

		assertEquals(pedido, resultado);
		verify(findPedidoByIdUseCase, times(1)).buscarPorId(anyLong());
	}

	@Test
	void criarPedido_DeveRetornarPedidoCriado() {
		when(createPedidoUseCase.criarPedido(any(Pedido.class))).thenReturn(pedido);
		when(pedidoMapper.toDTO(any(Pedido.class))).thenReturn(responsePedidoDTO);
		when(pedidoMapper.toDomain(any(RequestPedidoDTO.class))).thenReturn(pedido);

		ResponsePedidoDTO resultado = pedidoController.criarPedido(requestPedidoDTO);

		assertEquals(responsePedidoDTO, resultado);
		verify(createPedidoUseCase, times(1)).criarPedido(any(Pedido.class));
		verify(pedidoMapper, times(1)).toDTO(any(Pedido.class));
		verify(pedidoMapper, times(1)).toDomain(any(RequestPedidoDTO.class));
	}

	@Test
	void deletarPedido_DeveChamarDeleteUseCase() {
		doNothing().when(deletePedidoUseCase).deletarPedido(anyLong());

		pedidoController.deletarPedido(1L);

		verify(deletePedidoUseCase, times(1)).deletarPedido(anyLong());
	}

}
