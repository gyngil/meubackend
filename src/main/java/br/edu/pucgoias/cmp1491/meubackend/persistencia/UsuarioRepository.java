package br.edu.pucgoias.cmp1491.meubackend.persistencia;

import br.edu.pucgoias.cmp1491.meubackend.entidade.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}