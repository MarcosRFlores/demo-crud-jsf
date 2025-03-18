package com.crud.demo_crud.dao;

import com.crud.demo_crud.modelo.Publicacion;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PublicacionDAO {

    @PersistenceContext
    private EntityManager em;

    public void crear (Publicacion publicacion) {em.persist(publicacion);}

    public Publicacion buscarPorId(Long id) {return em.find(Publicacion.class, id);}

    public List<Publicacion> listarTodas() {return em.createQuery("Select p from Publicacion p", Publicacion.class).getResultList();}

    public void eliminar(Publicacion publicacion) {
        System.out.println("eliminando publicacion en el dao1");
        Publicacion publicacionManaged = em.merge(publicacion);
        System.out.println("eliminando publicacion en el dao2");
        em.remove(publicacionManaged);
    }

    public void actualizar(Publicacion publicacion) {em.merge(publicacion);}
}
