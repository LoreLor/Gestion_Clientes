
package com.spring2.practicaSpring2.dao;

import com.spring2.practicaSpring2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
    
}
