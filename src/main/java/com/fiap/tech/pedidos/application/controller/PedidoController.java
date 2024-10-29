package com.fiap.tech.pedidos.application.controller;

import com.fiap.tech.pedidos.application.controller.dto.RequestPedidoDTO;
import com.fiap.tech.pedidos.application.controller.dto.ResponsePedidoDTO;
import com.fiap.tech.pedidos.application.mapper.PedidoMapper;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.domain.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

	private final FindPedidoByIdUseCase findPedidoByIdUseCase;

	private final ListPedidosUseCase listPedidosUseCase;

	private final CreatePedidoUseCase createPedidoUseCase;

	private final UpdatePedidoUseCase updatePedidoUseCase;

	private final DeletePedidoUseCase deletePedidoUseCase;

	private final PedidoMapper mapper;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ResponsePedidoDTO> listarPedidos() {
		return listPedidosUseCase.listarPedidos().stream().map(p -> mapper.toDTO(p)).collect(Collectors.toList());
	}

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

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPedido(@PathVariable Long id) {
		deletePedidoUseCase.deletarPedido(id);
	}

}