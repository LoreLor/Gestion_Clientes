package com.spring2.practicaSpring2.service;

import com.spring2.practicaSpring2.dao.PersonaDao;
import com.spring2.practicaSpring2.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Persona> listarPersonas() {
        //conecto mi servicio con la entidad
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
       return personaDao.findById(persona.getIdpersona()).orElse(null);
    }

    public List<Persona> listarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
