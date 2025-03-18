package com.crud.demo_crud.controlador;

import com.crud.demo_crud.modelo.Usuario;
import com.crud.demo_crud.modelo.Rol;
import com.crud.demo_crud.servicio.UsuarioServicio;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @Inject
    private UsuarioServicio usuarioServicio;

    @Inject
    private RolController rolController;

    private Usuario usuario;
    private List<Usuario> usuarios;
    private Long rolSeleccionado;
    private Usuario usuarioSeleccionado; // Propiedad para almacenar el usuario seleccionado para editar

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarios = usuarioServicio.listarUsuarios();
    }

    public void guardarUsuario() {
        if (rolSeleccionado == null) {
            System.out.println("Debe seleccionar un rol para el usuario.");
            return;
        }

        Rol rolUsuario = rolController.buscarRolPorId(rolSeleccionado);
        usuario.setRol(rolUsuario);

        System.out.println("Guardando usuario: " + usuario.getNombre());
        System.out.println("Rol asignado: " + usuario.getRol().getNombre());

        usuarioServicio.crearUsuario(usuario);
        usuarios = usuarioServicio.listarUsuarios();
        usuario = new Usuario();
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuario == null) {
            System.out.println("El usuario es nulo");
            return;
        }
        System.out.println("Eliminando usuario con ID: " + usuario.getId());
        usuarioServicio.eliminarUsuario(usuario);
        usuarios = usuarioServicio.listarUsuarios();
    }

    public void actualizarUsuario() {
        if (usuarioSeleccionado != null) {
            // Asignar el rol seleccionado al usuario
            Rol rolUsuario = rolController.buscarRolPorId(rolSeleccionado);
            usuarioSeleccionado.setRol(rolUsuario);

            usuarioServicio.actualizarUsuario(usuarioSeleccionado);
            usuarios = usuarioServicio.listarUsuarios(); // Actualizar la lista de usuarios
        }
    }

    // Getters y Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Long getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Long rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
}