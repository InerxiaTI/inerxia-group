package com.inerxiagroup.repository.contacto;

import com.inerxiagroup.model.contacto.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
    //Optional<Contacto> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);




}
