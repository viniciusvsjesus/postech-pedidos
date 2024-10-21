package com.fiap.tech.pedidos.application.controller;

import com.fiap.tech.pedidos.application.controller.dto.RequestPedidoDTO;
import com.fiap.tech.pedidos.application.controller.dto.ResponsePedidoDTO;
import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.domain.usecase.CreatePedidoUseCase;
import com.fiap.tech.pedidos.domain.usecase.DeletePedidoUseCase;
import com.fiap.tech.pedidos.domain.usecase.FindPedidoByIdUseCase;
import com.fiap.tech.pedidos.domain.usecase.UpdatePedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

	private final FindPedidoByIdUseCase findPedidoByIdUseCase;

	private final CreatePedidoUseCase createPedidoUseCase;

	private final UpdatePedidoUseCase updatePedidoUseCase;

	private final DeletePedidoUseCase deletePedidoUseCase;

	private final PedidoMapper mapper;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pedido buscarPedidoPorId(@PathVariable Long id) {
		return findPedidoByIdUseCase.buscarPorId(id);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponsePedidoDTO criarPedido(@RequestBody RequestPedidoDTO pedido) {
		return mapper.toDTO(createPedidoUseCase.criarPedido(mapper.toDomain(pedido)));
	}

}