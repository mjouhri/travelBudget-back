package com.travelbudget.app.travelbudget.repository;

import com.travelbudget.app.travelbudget.model.Trip;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

@Repository
public class TripRepository extends BaseRepository implements Serializable {

    private static final String GET_ALL_QUERY = "FROM Trip t";

    public Trip getById(Long idTrip) {
        Session session = getEntityManager().unwrap(Session.class);
        if (idTrip != null) {
            return session.get(Trip.class, idTrip);
        }
        return null;
    }

    public List<Trip> getTrips() {
        Session session = getEntityManager().unwrap(org.hibernate.Session.class);
        return session.createQuery(GET_ALL_QUERY, Trip.class).list();
    }

    public void create(Trip trip) {
        Session session = getEntityManager().unwrap(Session.class);
        if (trip != null) {
            session.save(trip);
        }
    }

    public void update(Trip trip) {
        Session session = getEntityManager().unwrap(Session.class);
        if (trip != null) {
            session.update(trip);
        }
    }

    public void delete(Trip trip) {
        Session session = getEntityManager().unwrap(Session.class);
        if (trip != null) {
            session.delete(session.merge(trip));
        }
    }

}
