package br.edu.pucgoias.cmp1491.meubackend.negocio;

import br.edu.pucgoias.cmp1491.meubackend.entidade.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario incluir(Usuario usuario);
    public List<Usuario> listar();
    public Usuario consultar(Integer id);
    public void alterar(Usuario usuario);
    public void excluir(Integer id);

}
