package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreatePedidoUseCase {

	private final PedidoRepository pedidoRepository;

	private final PedidoMapper mapper;

	@Transactional
	public Pedido criarPedido(Pedido pedido) {
		pedido.setDataPedido(LocalDateTime.now());
		return mapper.toDomain(pedidoRepository.save(mapper.toEntity(pedido)));
	}

}
