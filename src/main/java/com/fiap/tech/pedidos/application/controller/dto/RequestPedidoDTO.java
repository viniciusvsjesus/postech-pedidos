package com.fiap.tech.pedidos.application.controller.dto;

import com.fiap.tech.pedidos.domain.model.ItemPedido;
import lombok.Data;

import java.util.List;

@Data
public class RequestPedidoDTO {

	private Long idCliente;

	private List<ItemPedido> itens;

}
