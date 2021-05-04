package com.travelbudget.app.travelbudget.repository;

import com.travelbudget.app.travelbudget.model.Trip;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
public class TripRepository extends BaseRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String GET_ALL_FILTER_QUERY = "FROM Trip t";

    public List<Trip> getTrips() {
        Session sessionHibernate = getEntityManager().unwrap(org.hibernate.Session.class);
        return sessionHibernate.createQuery(GET_ALL_FILTER_QUERY, Trip.class).list();
    }

}
