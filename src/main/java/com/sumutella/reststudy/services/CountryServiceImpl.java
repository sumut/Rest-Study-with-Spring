package com.sumutella.reststudy.services;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Location;
import com.sumutella.reststudy.repositories.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sumutella
 * @time 6:27 PM
 * @since 11/22/2019, Fri
 */

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDaoImpl;


    @Transactional
    @Override
    public List<Country> getCountries() {
        return countryDaoImpl.getCountries();
    }

    @Transactional
    @Override
    public List<Location> getLocations(String id) {
        return countryDaoImpl.getLocations(id);
    }
}
