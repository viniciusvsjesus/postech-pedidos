package com.fiap.tech.pedidos.domain.model;

import lombok.Data;

@Data
public class ItemPedido {

	private long idProduto;

	private int quantidade;

	private double valorUnitario;

}
