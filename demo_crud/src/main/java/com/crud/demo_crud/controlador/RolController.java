package com.crud.demo_crud.controlador;

import com.crud.demo_crud.modelo.Rol;
import com.crud.demo_crud.servicio.RolServicio;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RolController implements Serializable {

    @Inject
    private RolServicio rolServicio;

    private Rol rol;
    private List<Rol> roles;
    private Rol rolSeleccionado; // Propiedad para almacenar el rol seleccionado para editar

    @PostConstruct
    public void init() {
        rol = new Rol();
        roles = rolServicio.listarRoles();
    }

    public void guardarRol() {
        rolServicio.crearRol(rol);
        roles = rolServicio.listarRoles();
        rol = new Rol();
    }

    public void eliminarRol(Rol rol) {
        if (rol == null) {
            System.out.println("El rol es nulo");
            return;
        }
        System.out.println("Eliminando rol con ID: " + rol.getId() + ", Nombre: " + rol.getNombre());
        rolServicio.eliminarRol(rol);
        roles = rolServicio.listarRoles(); // Actualiza la lista de roles
    }

    public void actualizarRol() {
        if (rolSeleccionado != null) {
            rolServicio.actualizarRol(rolSeleccionado);
            roles = rolServicio.listarRoles(); // Actualiza la lista de roles
        }
    }

    public Rol buscarRolPorId(Long id) {
        return rolServicio.buscarRolPorId(id);
    }

    // Getters y Setters
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }
}