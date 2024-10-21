package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListPedidosUseCase {

	private final PedidoRepository pedidoRepository;

	private final PedidoMapper mapper;

	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll().stream().map(p -> mapper.toDomain(p)).collect(Collectors.toList());
	}

}
