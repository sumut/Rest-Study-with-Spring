package com.sumutella.reststudy.repositories;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Location;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sumutella
 * @time 6:18 PM
 * @since 11/22/2019, Fri
 */
@Repository
public class CountryDaoImpl implements CountryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Country> getCountries() {
        return sessionFactory.getCurrentSession().createQuery("from Country", Country.class).getResultList();
    }

    @Override
    public List<Location> getLocations(String id) {
       Country country = sessionFactory.getCurrentSession().get(Country.class, id.toUpperCase());

       Hibernate.initialize(country.getLocations());

       return country.getLocations();

    }
}
