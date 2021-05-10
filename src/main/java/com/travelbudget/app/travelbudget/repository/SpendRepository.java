package com.travelbudget.app.travelbudget.repository;

import com.travelbudget.app.travelbudget.model.Spend;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class SpendRepository extends BaseRepository implements Serializable {
    private static final String GET_ALL_QUERY = "SELECT S FROM Spend S Order By S.date DESC";

    public Spend getById(Long idSpend) {
        Session session = getEntityManager().unwrap(Session.class);
        if (idSpend != null) {
            return session.get(Spend.class, idSpend);
        }
        return null;
    }

    public List<Spend> getSpends() {
        Session session = getEntityManager().unwrap(org.hibernate.Session.class);
        return session.createQuery(GET_ALL_QUERY, Spend.class).list();
    }

    public void create(Spend spend) {
        Session session = getEntityManager().unwrap(Session.class);
        if (spend != null) {
            session.save(spend);
        }
    }

    public void update(Spend spend) {
        Session session = getEntityManager().unwrap(Session.class);
        if (spend != null) {
            session.update(spend);
        }
    }

    public void delete(Spend spend) {
        Session session = getEntityManager().unwrap(Session.class);
        if (spend != null) {
            session.delete(session.merge(spend));
        }
    }
}
