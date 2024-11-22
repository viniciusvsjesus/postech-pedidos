package com.fiap.tech.pedidos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

	private long idProduto;

	private int quantidade;

	private double valorUnitario;

}
