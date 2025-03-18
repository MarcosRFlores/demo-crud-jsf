package com.crud.demo_crud.servicio;

import com.crud.demo_crud.dao.RolDAO;
import com.crud.demo_crud.modelo.Rol;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RolServicio {

    @Inject
    private RolDAO rolDAO;

    public void crearRol(Rol rol) {
        rolDAO.crear(rol);
    }

    public Rol buscarRolPorId(Long id) {
        return rolDAO.buscarporId(id);
    }

    public List<Rol> listarRoles() {
        return rolDAO.listarTodos();
    }

    public void actualizarRol(Rol rol) {
        rolDAO.actualizar(rol);
    }

    public void eliminarRol(Rol rol) {
        System.out.println("Eliminando rol: " + rol.getNombre());
        rolDAO.eliminar(rol);
    }
}