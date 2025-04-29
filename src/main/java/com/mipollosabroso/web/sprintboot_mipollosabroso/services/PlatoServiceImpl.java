package com.mipollosabroso.web.sprintboot_mipollosabroso.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.Plato;
import com.mipollosabroso.web.sprintboot_mipollosabroso.repositories.PlatoRepository;

@Service
public class PlatoServiceImpl implements PlatoService{

    @Autowired
    private PlatoRepository platoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Plato> findAll() {
        return (List<Plato>) platoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Plato findById(Long id) {
        return platoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plato no encontrado"));
         
    }

    @Transactional
    @Override
    public Plato save(Plato plato) {
        return platoRepository.save(plato);
        
    }

    @Transactional
    @Override
    public Optional<Plato> delete(Long id) {
        Optional<Plato> platoOptional = platoRepository.findById(id);
        platoOptional.ifPresent(platoRepository::delete);
        return platoOptional;
    }

    @Transactional
    @Override
    public Optional<Plato> update(Plato plato, Long id) {
        Optional<Plato> platOptional = platoRepository.findById(id);
        if(platOptional.isPresent()){
            Plato plato2 = platOptional.get();

            plato2.setNameProduct(plato.getNameProduct());
            plato2.setDescription(plato.getDescription());
            plato2.setPrice(plato.getPrice());

            platoRepository.save(plato2);

            return Optional.of(plato2);

        }
        return Optional.empty();
    }
    
}
