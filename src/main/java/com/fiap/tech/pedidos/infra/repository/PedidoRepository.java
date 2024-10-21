package com.fiap.tech.pedidos.infra.repository;

import com.fiap.tech.pedidos.infra.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
