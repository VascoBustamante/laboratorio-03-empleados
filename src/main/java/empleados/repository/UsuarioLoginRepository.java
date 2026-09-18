package empleados.repository;

import empleados.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioLoginRepository
        extends JpaRepository<UsuarioLogin, Long> {

    Optional<UsuarioLogin> findByUsuario(String usuario);
}