package com.alkemann.advent.nine;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Travel {

    protected Pattern pattern = Pattern.compile("(\\w+) to (\\w+) = (\\d+)");
    protected int shortestDistance = -1;
    protected HashMap<String, City> cities = new HashMap<>(10);
    private int longestDistance = -1;

    public Travel(List<String> parts) {
        parts.forEach(this::addPart);
    }

    public Travel(Scanner scanner) {
        while (scanner.hasNextLine())
            this.addPart(scanner.nextLine());
    }

    public void addPart(String s) {
        Matcher m = pattern.matcher(s);
        if (m.matches()) {
            String from  = m.group(1);
            String to    = m.group(2);
            int distance = Integer.parseInt(m.group(3));
            City fromCity = getCity(from);
            City toCity = getCity(to);
            fromCity.addRoute(toCity, distance);
            toCity.addRoute(fromCity, distance);
        } else {
            throw new RuntimeException("Didnt match pattern " + s);
        }
    }

    private City getCity(String name) {
        if (!cities.containsKey(name))
            cities.put(name, new City(name));
        return cities.get(name);
    }

    public int getShortestDistance(String startingCityName) {
        City startingCity = cities.get(startingCityName);
        shortestDistance = 0;
        rec(startingCity);
        cities.forEach((s, city) -> city.visited = false);
        return shortestDistance;
    }

    private void rec(City city) {
        List<City> near = city.getNeighbors();
        if (near.isEmpty()) {
            return; // all the way through
        }
        int cheapestCost = Integer.MAX_VALUE;
        City cheapestCity = null;
        for (City c : near) {
            int distance = city.distanceTo(c.name) ;
            if (distance < cheapestCost) {
                cheapestCity = c;
                cheapestCost = distance;
            }
        }
        city.visited();
        shortestDistance += cheapestCost;
        rec(cheapestCity);
    }

    public int getLongestDistance(String startingCityName) {
        City startingCity = cities.get(startingCityName);
        longestDistance = 0;
        recLongest(startingCity);
        cities.forEach((s, city) -> city.visited = false );
        return longestDistance;
    }

    private void recLongest(City city) {
        if (city == null) {
            System.out.println("NULL CITY");
            System.exit(-1);
        }

        List<City> near = city.getNeighbors();
        if (near.isEmpty()) {
            return; // all the way through
        }
        int cheapestCost = 0;
        City cheapestCity = null;
        for (City c : near) {
            int distance = city.distanceTo(c.name) ;
            if (distance > cheapestCost) {
                cheapestCity = c;
                cheapestCost = distance;
            }
        }
        city.visited();
        longestDistance += cheapestCost;
        recLongest(cheapestCity);
    }
}
