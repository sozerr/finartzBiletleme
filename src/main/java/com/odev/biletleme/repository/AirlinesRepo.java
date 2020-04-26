package com.odev.biletleme.repository;

import com.odev.biletleme.entity.AirlinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlinesRepo extends JpaRepository<AirlinesEntity, Long>, JpaSpecificationExecutor<AirlinesEntity> {
    AirlinesEntity findAirlinesEntityByAirlinesID(Long airlines_id);

    AirlinesEntity findByName(String name);
}
