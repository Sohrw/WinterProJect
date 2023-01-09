package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Join;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JoinRepository {

    private final EntityManager em;

    public void save(Join join) {
        em.persist(join);
    }

    public Join findOne(Long id) {
        return em.find(Join.class, id);
    }

    public List<Join> findAll() {
        return em.createQuery("select j from Join j", Join.class)
                .getResultList();
    }

    public List<Join> findByUserName(String user_name) {
        return em.createQuery("select j from Join j where j.user_name = :user_name", Join.class)
                .setParameter("user_name", user_name)
                .getResultList();
    }

    public List<Join> permission(String user_name, String pw) {
        return em.createQuery("select j from Join j where j.user_name = :user_name and j.pw = :pw", Join.class)
                .setParameter("user_name", user_name)
                .setParameter("pw", pw)
                .getResultList();
    }





}
