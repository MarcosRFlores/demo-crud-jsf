package com.crud.demo_crud.dao;

import com.crud.demo_crud.modelo.Rol;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RolDAO {

    @PersistenceContext
    private EntityManager em;

    public void crear(Rol rol) {
        em.persist(rol);
    }

    public Rol buscarporId(Long id){
        return em.find(Rol.class, id);
    }

    public List<Rol> listarTodos(){
        return em.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();
    }

    public void actualizar(Rol rol){
        em.merge(rol);
    }

    public void eliminar(Rol rol) {
        Rol rolManaged = em.merge(rol); // Asegura que el objeto esté gestionado
        em.remove(rolManaged); // Elimina el objeto gestionado
    }
}
