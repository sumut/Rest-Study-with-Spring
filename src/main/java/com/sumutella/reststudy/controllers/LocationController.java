package com.sumutella.reststudy.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sumutella.reststudy.entities.Department;
import com.sumutella.reststudy.entities.Location;
import com.sumutella.reststudy.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sumutella
 * @time 6:38 PM
 * @since 11/22/2019, Fri
 */
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationServiceImpl;

    @RequestMapping("")
    public List<Location> getLocations(){
        return locationServiceImpl.getLocations();
    }

    @RequestMapping("/{locationId}")
    public List<Department> getDepartmentsInLocation(@PathVariable Integer locationId){
        return locationServiceImpl.getDepartments(locationId);
    }


}
