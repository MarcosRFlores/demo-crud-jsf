package com.crud.demo_crud.dao;

import com.crud.demo_crud.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

public class UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    public void crear(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        em.persist(usuario);
        em.flush(); // Fuerza la sincronización con la base de datos
    }

    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> listarTodos() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public List<Usuario> listarTodos(int offset, int limit) {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public Usuario actualizar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        return em.merge(usuario); // Devuelve la instancia gestionada
    }

    public void eliminar(Usuario usuario) {
        Usuario usuarioManaged = em.merge(usuario); // Asegura que el objeto esté gestionado
        em.remove(usuarioManaged);
    }
}