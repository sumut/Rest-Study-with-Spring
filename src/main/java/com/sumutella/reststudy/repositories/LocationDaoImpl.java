package com.sumutella.reststudy.repositories;

import com.sumutella.reststudy.entities.Department;
import com.sumutella.reststudy.entities.Location;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sumutella
 * @time 6:22 PM
 * @since 11/22/2019, Fri
 */
@Repository
public class LocationDaoImpl implements LocationDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Location> getLocations() {
        return sessionFactory.getCurrentSession().createQuery("from Location", Location.class).getResultList();
    }

    @Override
    public List<Department> getDepartments(Integer id) {
        Location location = sessionFactory.getCurrentSession().get(Location.class, id);
//        Hibernate.initialize(location.getDepartments());
//        return location.getDepartments();
        return sessionFactory.getCurrentSession().createQuery("from Department where location=:location", Department.class)
                .setParameter("location", location).getResultList();
    }
}
