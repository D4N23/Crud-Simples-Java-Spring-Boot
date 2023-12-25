package com.crudsimples.CrudSimples.repositories;

import com.crudsimples.CrudSimples.models.PartnersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartnersRepository extends JpaRepository<PartnersModel, UUID> {
    List<PartnersModel> findByActiveTrue();
}
