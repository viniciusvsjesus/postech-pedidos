package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.exception.ResourceNotFoundException;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindPedidoByIdUseCase {

	private final PedidoRepository pedidoRepository;

	private final PedidoMapper mapper;

	public Pedido buscarPorId(Long id) {
		return mapper.toDomain(pedidoRepository.findById(id)
			.orElseThrow(
					() -> new ResourceNotFoundException(String.format("O pedido com o id %d não foi encontrado", id))));
	}

}
