
package com.spring2.practicaSpring2.service;

import com.spring2.practicaSpring2.dao.UsuarioDao;
import com.spring2.practicaSpring2.domain.Rol;
import com.spring2.practicaSpring2.domain.Usuario;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("UserDetailsService")
@Slf4j
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        recupero al usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        log.info("Intento de autenticación del usuario: " + username);
        
//        valido
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        
        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        
//        recorro
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
