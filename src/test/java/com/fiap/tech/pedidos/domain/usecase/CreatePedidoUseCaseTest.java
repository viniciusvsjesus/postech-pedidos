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

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreatePedidoUseCaseTest {

	@InjectMocks
	private CreatePedidoUseCase createPedidoUseCase;

	@Mock
	private PedidoRepository pedidoRepository;

	@Mock
	private PedidoMapper pedidoMapper;

	private Pedido pedido;

	private PedidoEntity pedidoEntity;

	@BeforeEach
	void setUp() {
		pedido = new Pedido();
		pedido.setId(1L);
		pedido.setDataPedido(LocalDateTime.now());

		pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(1L);
		pedidoEntity.setDataPedido(LocalDateTime.now());
	}

	@Test
	void criarPedido_DeveSalvarEPersistirPedido() {
		when(pedidoMapper.toEntity(any(Pedido.class))).thenReturn(pedidoEntity);
		when(pedidoRepository.save(any(PedidoEntity.class))).thenReturn(pedidoEntity);
		when(pedidoMapper.toDomain(any(PedidoEntity.class))).thenReturn(pedido);

		Pedido resultado = createPedidoUseCase.criarPedido(pedido);

		assertEquals(pedido, resultado);
		verify(pedidoMapper, times(1)).toEntity(any(Pedido.class));
		verify(pedidoRepository, times(1)).save(any(PedidoEntity.class));
		verify(pedidoMapper, times(1)).toDomain(any(PedidoEntity.class));
	}

}
