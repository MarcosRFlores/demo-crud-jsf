package com.crud.demo_crud.controlador;

import com.crud.demo_crud.modelo.Publicacion;
import com.crud.demo_crud.servicio.PublicacionServicio;
import com.crud.demo_crud.modelo.Usuario;
import com.crud.demo_crud.servicio.UsuarioServicio;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PublicacionController implements Serializable {

    @Inject
    private PublicacionServicio publicacionServicio;

    @Inject
    private UsuarioServicio usuarioServicio;

    private Publicacion publicacion;
    private List<Publicacion> publicaciones;
    private Publicacion publicacionSeleccionada; // Propiedad para almacenar la publicación seleccionada para editar
    private Long usuarioSeleccionado; // Propiedad para almacenar el ID del usuario seleccionado

    @PostConstruct
    public void init() {
        publicacion = new Publicacion();
        publicaciones = publicacionServicio.listarPublicaciones();
    }

    public void guardarPublicacion() {
        // Asigna el usuario seleccionado a la publicación
        if (usuarioSeleccionado == null) {
            System.out.println("Debe seleccionar un usuario para la publicación.");
            return;
        }
        Usuario usuario = usuarioServicio.buscarUsuarioPorId(usuarioSeleccionado);
        publicacion.setUsuario(usuario);

        // Guarda la publicación
        publicacionServicio.crearPublicacion(publicacion);

        // Actualiza la lista de publicaciones
        publicaciones = publicacionServicio.listarPublicaciones();

        // Reinicia el formulario
        publicacion = new Publicacion();
        usuarioSeleccionado = null; // Reinicia el usuario seleccionado
    }

    public void eliminarPublicacion(Publicacion publicacion) {
        if(publicacion == null){
            System.out.println("La publicación es nula");
            return;
        }
        publicacionServicio.eliminarPublicacion(publicacion);
        publicaciones = publicacionServicio.listarPublicaciones();
    }

    public void actualizarPublicacion() {
        if (publicacionSeleccionada != null) {
            publicacionServicio.actualizarPublicacion(publicacionSeleccionada);

            publicaciones = publicacionServicio.listarPublicaciones();
        }
    }

    //Método para seleccionar una publicación para editar
    public void seleccionarPublicacion(Publicacion publicacion) {
        this.publicacionSeleccionada = publicacion;
        this.usuarioSeleccionado = publicacion.getUsuario() != null ? publicacion.getUsuario().getId() : null;
    }

    // Getters y Setters
    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public Publicacion getPublicacionSeleccionada() {
        return publicacionSeleccionada;
    }

    public void setPublicacionSeleccionada(Publicacion publicacionSeleccionada) {
        this.publicacionSeleccionada = publicacionSeleccionada;
    }

    // Getter y Setter para usuarioSeleccionado
    public Long getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Long usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
}