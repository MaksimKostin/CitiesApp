package com.company.utils;

import com.company.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityUtils {

    private static City parseCity(String line){
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if(scanner.hasNext()){ // может отсутсвовать дата основания
            foundation = scanner.next();
        }
        scanner.close();

        return new City(name, region, district, population, foundation);
    }

    public static List<City> parseFile(){
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner((new File("src/main/resources/rus.txt")));
            while(scanner.hasNextLine()){
                cities.add(parseCity(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void printCities(List<City> cities){
        cities.forEach(System.out::println);
    }

    public static void sortedByName(List<City> cities){
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    public static void sortedByDistrictAndName(List<City> cities){
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    public static void findMaxPopulation(List<City> cities){
        City[] allCities = cities.toArray(City[]::new);
        int index = 0;
        int population = 0;
        for (int i = 0; i < allCities.length - 1; i++) {
            if(allCities[i].getPopulation() > population){
                index = i;
                population = allCities[i].getPopulation();
            }
        }
        System.out.println("[" + index + "] = " + population);
    }

    public static void getNumOfCitiesInEachRegion(List<City> cities) {
        Map<String, Integer> regions = new HashMap<>();
        cities.forEach(c -> regions.merge(c.getRegion(), 1, Integer::sum));
        regions.forEach((r, c) -> System.out.println(r + " = " + c));
    }
}
