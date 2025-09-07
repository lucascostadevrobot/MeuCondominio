package com.meuCondominio.Master.Services.Usuarios;

import com.meuCondominio.Master.Models.Usuarios.Usuario;
import com.meuCondominio.Master.Repository.Usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;



public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder encoder;

    public void criandoUsuario(Usuario usuario){
        if (usuario == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else {
            String pass = usuario.getPassword();
            //encriptando antes de salvar
            usuario.setPassword(encoder.encode(pass));
            usuarioRepository.save(usuario);
        }
    }

}
