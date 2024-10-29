package com.fiap.tech.pedidos.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Pedido {

	private Long id;

	private Long idCliente;

	private List<ItemPedido> itens;

	private LocalDateTime dataPedido;

	private LocalDateTime dataEntrega;

}