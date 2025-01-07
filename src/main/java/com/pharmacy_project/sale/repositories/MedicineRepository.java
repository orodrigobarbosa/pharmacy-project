package com.pharmacy_project.sale.repositories;

import com.pharmacy_project.sale.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    //Query para buscar por nome quando for cadastrar um medicamento no banco de dados
    //query to find by name a medication to check if it is already in database
    Optional<Medicine> findByName(String name);
}
