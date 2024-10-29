package com.fiap.tech.pedidos.infra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

	@NotNull
	private Long idCliente;

	@ElementCollection
	@CollectionTable(name = "pedido_itens", joinColumns = @JoinColumn(name = "pedido_id"))
	private List<ItemPedidoEntity> itens;

	@NotNull
	private LocalDateTime dataPedido;

	private LocalDateTime dataEntrega;

}
