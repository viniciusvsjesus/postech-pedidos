package com.fiap.tech.pedidos.infra.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class ItemPedidoEntity {

	@NotNull
	private long idProduto;

	@NotNull
	private int quantidade;

	@NotNull
	private double valorUnitario;

}
