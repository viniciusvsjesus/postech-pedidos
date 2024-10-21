package com.fiap.tech.pedidos.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idCliente;

	// private List<String> itens;
	private Long idProduto;

	private int quantidade;

	private double valorUnitario;

	private LocalDateTime dataPedido;

	private LocalDateTime dataEntrega;

}
