package com.brigido.bomba.repository;

import com.brigido.bomba.entity.WireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface WireRepository extends JpaRepository<WireEntity, UUID> {
}
