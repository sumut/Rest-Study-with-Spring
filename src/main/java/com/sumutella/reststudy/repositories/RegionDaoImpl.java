package com.sumutella.reststudy.repositories;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Region;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sumutella
 * @time 6:15 PM
 * @since 11/22/2019, Fri
 */
@Repository
public class RegionDaoImpl implements RegionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Region> getRegions() {
        return sessionFactory.getCurrentSession().createQuery("from Region", Region.class).getResultList();
    }

    @Override
    public List<Country> getCountries(Integer id) {
        Region region = sessionFactory.getCurrentSession().get(Region.class, id);
        Hibernate.initialize(region.getCountries());
        return region.getCountries();
    }
}
