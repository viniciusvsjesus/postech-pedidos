package com.fiap.tech.pedidos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

	private Long id;

	private Long idCliente;

	// private List<String> itens;
	private Long idProduto;

	private int quantidade;

	private double valorUnitario;

	private LocalDateTime dataPedido;

	private LocalDateTime dataEntrega;

}