package br.edu.pucgoias.cmp1491.meubackend.negocio;

import br.edu.pucgoias.cmp1491.meubackend.entidade.Usuario;
import br.edu.pucgoias.cmp1491.meubackend.persistencia.UsuarioRepository;
import br.edu.pucgoias.cmp1491.meubackend.util.MeuBackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario incluir(Usuario usuario) {
        try {
            repository.save(usuario);
            return usuario;
        }
        catch (Exception e){
            throw new MeuBackEndException("Não foi possível incluir o usuario!");
        }
    }

    @Override
    public List<Usuario> listar() {
        try {
            return (List<Usuario>) this.repository.findAll();
        }
        catch (Exception e){
            throw new MeuBackEndException("Não foi possível listar os usuarios!");
        }
    }

    @Override
    public Usuario consultar(Integer id) {
        try {
            return this.repository.findById(id).get();
        }
        catch (Exception e){
            throw new MeuBackEndException("Não foi possível consultar o usuario: "+id+"!");
        }
    }

    @Override
    public void alterar(Usuario usuario) {
        try {
            repository.save(usuario);
        }
        catch (Exception e){
            throw new MeuBackEndException("Não foi possível alterar o usuario: "+usuario.getId()+"!");
        }
    }

    @Override
    public void excluir(Integer id) {
        try {
            repository.deleteById(id);
        }
        catch (Exception e){
            throw new MeuBackEndException("Não foi possível excluir o usuario: "+id+"!");
        }
    }
}
