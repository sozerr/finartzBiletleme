package com.odev.biletleme.repository;

import com.odev.biletleme.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, Long>, JpaSpecificationExecutor<TicketEntity> {
    TicketEntity findByTicketNumber(String ticketId);
    List<TicketEntity> findByRouteID(Long routeId);
}
