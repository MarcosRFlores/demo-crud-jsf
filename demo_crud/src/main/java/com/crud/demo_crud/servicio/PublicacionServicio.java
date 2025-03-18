package com.crud.demo_crud.servicio;

import com.crud.demo_crud.dao.PublicacionDAO;
import com.crud.demo_crud.modelo.Publicacion;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PublicacionServicio {

    @Inject
    private PublicacionDAO publicacionDAO;

    public void crearPublicacion(Publicacion publicacion) {
        publicacionDAO.crear(publicacion);
    }

    public Publicacion buscarPublicacionPorId(Long id) {
        return publicacionDAO.buscarPorId(id);
    }

    public List<Publicacion> listarPublicaciones() {
        return publicacionDAO.listarTodas();
    }

    public void actualizarPublicacion(Publicacion publicacion) {
        publicacionDAO.actualizar(publicacion);
    }

    public void eliminarPublicacion(Publicacion publicacion) {
        System.out.println("eliminando publicacion en el servicio");
        publicacionDAO.eliminar(publicacion);
    }
}