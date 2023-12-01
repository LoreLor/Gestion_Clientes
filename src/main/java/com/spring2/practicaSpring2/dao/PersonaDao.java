package com.spring2.practicaSpring2.dao;

import com.spring2.practicaSpring2.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaDao extends JpaRepository<Persona, Long>{
        // puedo agregar métodos personalizados - ya tiene métodos generales  
}
