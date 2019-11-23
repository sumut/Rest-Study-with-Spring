package com.sumutella.reststudy.services;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Region;
import com.sumutella.reststudy.repositories.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sumutella
 * @time 6:29 PM
 * @since 11/22/2019, Fri
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionDao regionDaoImpl;


    @Transactional
    @Override
    public List<Region> getRegions() {
        return regionDaoImpl.getRegions();
    }

    @Transactional
    @Override
    public List<Country> getCountries(Integer id) {
        return regionDaoImpl.getCountries(id);
    }
}
