package com.sumutella.reststudy.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sumutella
 * @time 5:29 PM
 * @since 11/22/2019, Fri
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id")
    private String id;
    @Column(name = "country_name")
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;


    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    public Country() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
