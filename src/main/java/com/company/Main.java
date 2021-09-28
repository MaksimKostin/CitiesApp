package com.company;

import com.company.dao.CityDAO;
import com.company.model.City;
import com.company.utils.CityUtils;

import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.println("Выберите требуемое действие:");
        System.out.println("1) Список городов.");
        System.out.println("2) Сортировка списка городов " +
                "по наименованию в алфавитном порядке по " +
                "убыванию без учета регистра.");
        System.out.println("3) Сортировка списка городов " +
                "по федеральному округу и наименованию " +
                "города в алфавитном порядке по убыванию " +
                "с учетом регистра.");
        System.out.println("4) Максимальное количество жителей.");
        System.out.println("5) Количество городов в разрезе регионов.");
        System.out.println("6) Выход.");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        if(action == 6){
            System.exit(0);
        }


        List<City> cityList = CityUtils.parseFile(); // Получение списка городов
        CityDAO cityDAO = new CityDAO();
        cityDAO.writeCities(cityList); // Добавление в БД

        List<City> cityListFromDB = cityDAO.getCities(); // Получение списка из БД

        switch (action){
            case 1:
                CityUtils.printCities(cityListFromDB);
                break;
            case 2:
                CityUtils.sortedByName(cityListFromDB);
                CityUtils.printCities(cityListFromDB);
                break;
            case 3:
                CityUtils.sortedByDistrictAndName(cityListFromDB);
                CityUtils.printCities(cityListFromDB);
                break;
            case 4:
                CityUtils.findMaxPopulation(cityListFromDB);
                break;
            case 5:
                CityUtils.getNumOfCitiesInEachRegion(cityListFromDB);
                break;
        }
    }
}
