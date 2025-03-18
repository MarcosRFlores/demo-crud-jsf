package com.crud.demo_crud.servicio;

import com.crud.demo_crud.dao.UsuarioDAO;
import com.crud.demo_crud.modelo.Usuario;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UsuarioServicio {

    @Inject
    private UsuarioDAO usuarioDAO;

    public void crearUsuario(Usuario usuario) {
        usuarioDAO.crear(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioDAO.buscarPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos();
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioDAO.actualizar(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.eliminar(usuario);
    }
}