package com.sumutella.reststudy.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Region;
import com.sumutella.reststudy.services.RegionService;
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
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionServiceImpl;

    @RequestMapping("")
    public List<Region> showRegions(){
        return regionServiceImpl.getRegions();
    }

    @RequestMapping("/{regionId}")
    public List<Country> getCountriesInRegion(@PathVariable Integer regionId){
        return regionServiceImpl.getCountries(regionId);
    }

}
