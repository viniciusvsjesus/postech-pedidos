package com.fiap.tech.pedidos.application.controller.dto;

import com.fiap.tech.pedidos.domain.model.ItemPedido;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponsePedidoDTO {

	private Long id;

	private Long idCliente;

	private LocalDateTime dataPedido;

	private List<ItemPedido> itens;

}
