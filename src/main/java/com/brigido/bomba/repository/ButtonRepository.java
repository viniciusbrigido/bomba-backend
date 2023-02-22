package com.brigido.bomba.repository;

import com.brigido.bomba.entity.ButtonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ButtonRepository extends JpaRepository<ButtonEntity, UUID> {
}
