package com.spring2.practicaSpring2.web;


import com.spring2.practicaSpring2.domain.Persona;
import com.spring2.practicaSpring2.service.PersonaService;
import java.util.List;
import lombok.experimental.var;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ContraladorInicio {
    
    // inyecto la interface
    @Autowired
    private PersonaService  personaService;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // trae los datos de personas y me muestra la vista
    @GetMapping("/")   
    public String inicio(Model model) {
        List<Persona> personas = personaService.listarPersonas();
        
        double saldoTotal = 0;
        for(Persona p : personas){
            saldoTotal += p.getSaldo();
        }
        
        
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas); 
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes",personas.size());
        
        return "index";
    }
    
    // me lleva al html modificar
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    
    //guarda la info ingresada al form y me redirecciona al home
    @PostMapping("/guardar")
    public String guardar(@Validated Persona persona, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //log.info("Errores de validación: {}", bindingResult.getAllErrors());
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    // es un link => get - 
    @GetMapping("/editar/{idpersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
