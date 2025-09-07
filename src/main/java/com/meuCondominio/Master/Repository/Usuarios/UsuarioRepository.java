package com.meuCondominio.Master.Repository.Usuarios;

import com.meuCondominio.Master.Models.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Long, Usuario> {

    /**
     * findByUsername:
     * Montamos uma JPQL para buscarmos um Usuário pelo user_name.
     * existByUsername:
     * Verificar se existie o usuário em questão.
     * */
    @Query("SELECT * FROM Usuario e JOIN FETCH e.roles WHERE e.user_name = (:user_name)")
    public Usuario findByUsername(@Param("user_name") String username);

    boolean existByUsername(String username);
}
