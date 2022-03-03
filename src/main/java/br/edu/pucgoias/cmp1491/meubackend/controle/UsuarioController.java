package br.edu.pucgoias.cmp1491.meubackend.controle;

import br.edu.pucgoias.cmp1491.meubackend.entidade.Usuario;
import br.edu.pucgoias.cmp1491.meubackend.negocio.UsuarioService;
import br.edu.pucgoias.cmp1491.meubackend.util.MeuBackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe controladora de Usuarios
 * Exemplo para aula CMP1491 da PUC Goias
 * Prof.: Gilcimar
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public void setMedicoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Metodo que lista os usuarios
     * @return lista de usuários
     */
    @GetMapping(value = "/listar-usuarios")
    public List<Usuario> listar(){

        List<Usuario> lista = usuarioService.listar();
        return lista;

    }

    /**
     * Metodo que consulta um usuario por id
     * @param id id do usuário
     * @return objeto usuario
     */
    @GetMapping(value = "/consultar-usuario/{id}")
    public Usuario consultar(@PathVariable Integer id){

        return usuarioService.consultar(id);

    }

    /**
     * metood que salva (inclui ou altera) um usuario
     * @param usuario
     * @return usuario alterado ou incluido
     */
    @PostMapping(value = "/salvar-usuario")
    public Usuario salvar(@RequestBody Usuario usuario) {

        try{
            if (usuario.getId()==null){

                usuario = usuarioService.incluir(usuario);

            }
            else{
                usuarioService.alterar(usuario);
            }

            return usuario;

        }
        catch (MeuBackEndException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getReason());
        }

    }

    /**
     * Metodo que exclui usuario pelo id
     * @param id id do usuario a ser excluido
     */
    @DeleteMapping(value = "/excluir-usuario/{id}")
    public void excluir(@PathVariable Integer id){

        usuarioService.excluir(id);

    }

}
