package com.fiap.tech.pedidos.application.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponsePedidoDTO {

	private Long id;

	private Long idCliente;

	private LocalDateTime dataCriacao;

}
