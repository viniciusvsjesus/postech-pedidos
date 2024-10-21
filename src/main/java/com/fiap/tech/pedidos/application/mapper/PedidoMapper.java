package com.fiap.tech.pedidos.application.mapper;

import com.fiap.tech.pedidos.application.controller.dto.RequestPedidoDTO;
import com.fiap.tech.pedidos.application.controller.dto.ResponsePedidoDTO;
import com.fiap.tech.pedidos.domain.model.Pedido;
import com.fiap.tech.pedidos.infra.entity.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

	Pedido toDomain(PedidoEntity entity);

	Pedido toDomain(RequestPedidoDTO rquest);

	PedidoEntity toEntity(Pedido pedido);

	ResponsePedidoDTO toDTO(Pedido pedido);

}
