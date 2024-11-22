package com.fiap.tech.pedidos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PedidoMessage {

    private String idPedido;
    private String dadosComprador;
    private List<ItemPedido> itens;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
}
