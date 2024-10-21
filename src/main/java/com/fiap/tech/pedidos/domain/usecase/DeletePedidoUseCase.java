package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.infra.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeletePedidoUseCase {

	private final PedidoRepository pedidoRepository;

	@Transactional
	public void deletarPedido(Long id) {
		pedidoRepository.deleteById(id);
	}

}
