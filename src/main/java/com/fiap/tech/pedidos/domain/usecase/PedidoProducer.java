package com.fiap.tech.pedidos.domain.usecase;

import com.fiap.tech.pedidos.domain.model.PedidoMessage;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoProducer {

    private static final String BINDING_NAME = "output-logistica";

    private final StreamBridge streamBridge;

    public void enviarPedido(PedidoMessage pedidoMessage) {
        streamBridge.send(BINDING_NAME, pedidoMessage);
    }
}
