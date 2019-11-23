package com.sumutella.reststudy.services;

import com.sumutella.reststudy.entities.Department;
import com.sumutella.reststudy.entities.Location;
import com.sumutella.reststudy.repositories.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sumutella
 * @time 6:28 PM
 * @since 11/22/2019, Fri
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationDao locationDaoImpl;

    @Transactional
    @Override
    public List<Location> getLocations() {
        return locationDaoImpl.getLocations();
    }

    @Transactional
    @Override
    public List<Department> getDepartments(Integer id) {
        return locationDaoImpl.getDepartments(id);
    }
}
