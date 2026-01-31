package estudo.projeto.repository;

import estudo.projeto.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

   boolean existsByName(String name);
   Optional<Usuario> findByName(String name);
}
