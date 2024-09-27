package com.usuario.repository;

import com.usuario.entity.Usuario;
import com.usuario.filtro.UsuarioFiltro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioRepository {

    @PersistenceContext private EntityManager entityManager;


    @Transactional
    public void saveUsuario(Usuario usuario) {
        Session session = entityManager.unwrap(Session.class);
        session.save(usuario);
    }


    @Transactional
    public List<Usuario> findByIdAndNome(UsuarioFiltro filtro, Integer inicio, Integer max){

        Long id = filtro.getId();
        String nome = filtro.getNome();

        StringBuilder hql = new StringBuilder();

        Map<String, Object> params = new LinkedHashMap<>();

        hql.append("select u from ").append(Usuario.class.getName()).append(" u ");
        hql.append(" where 1=1 ");

        if(id != null){
            hql.append(" and u.id = :id");
            params.put("id", id);
        }

        if(nome != null && !nome.isEmpty()){
            hql.append(" and u.nome like :nome");
            params.put("nome","%"+nome+"%");
        }

        Session session = entityManager.unwrap(Session.class);
        Query<Usuario> query = session.createQuery(hql.toString(), Usuario.class);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        if (inicio != null && max != null) {
            query.setFirstResult(inicio);
            query.setMaxResults(max);
        }

        return query.getResultList();
    }
}
