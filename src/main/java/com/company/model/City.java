package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @SequenceGenerator(name = "city_generator", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_generator")
    private int id;
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public City(){}

    public City(String name, String region,
                String district, int population,
                String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation(){ return foundation; }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population='" + population + '\'' +
                ", foundation='" + foundation + '\'' +
                '}';
    }
}
