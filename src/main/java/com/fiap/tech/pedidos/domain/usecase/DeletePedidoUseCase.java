package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.domain.exception.ResourceNotFoundException;
import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePedidoUseCase {

	private final PedidoRepository pedidoRepository;

	public void deletarPedido(Long id) throws ResourceNotFoundException {
		if (pedidoRepository.findById(id).isPresent()) {
			pedidoRepository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException(String.format("O pedido %d já não existe", id));
		}
	}

}
