package com.mipollosabroso.web.sprintboot_mipollosabroso.services;

import java.util.List;
import java.util.Optional;

import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.Plato;

public interface PlatoService {

    List<Plato> findAll();

    Plato findById(Long id);

    Plato save(Plato plato);

    Optional<Plato> delete(Long id);

    Optional<Plato> update(Plato plato, Long id);


    

}
