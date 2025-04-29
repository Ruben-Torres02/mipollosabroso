package com.mipollosabroso.web.sprintboot_mipollosabroso.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mipollosabroso.web.sprintboot_mipollosabroso.entities.Plato;
import com.mipollosabroso.web.sprintboot_mipollosabroso.services.PlatoService;

@RequestMapping("/api/platos")
@RestController
public class PlatoController {

    private PlatoService platoService;

    @GetMapping
    public List<Plato> findAll() {
        return platoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Plato> save (@RequestBody Plato plato) {
        Plato platoGuardado = platoService.save(plato);
        return ResponseEntity.ok(platoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Plato> pOptional= platoService.delete(id);
        if(pOptional.isPresent()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Plato> update (@PathVariable Long id, @RequestBody Plato plato ) {
        Optional<Plato> platOptional = platoService.update(plato, id);
        if(platOptional.isPresent()) {
            return ResponseEntity.ok(platOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

}
