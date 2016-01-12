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
            System.out.println(toCity);
        } else {
            throw new RuntimeException("Didnt match pattern " + s);
        }
    }

    private City getCity(String name) {
        if (!cities.containsKey(name))
            cities.put(name, new City(name));
        return cities.get(name);
    }

    public int getShortestDistance(String cityName) {
        City city = cities.get(cityName);
        HashMap<String, City> n = city.getNeighbors();
        return shortestDistance;
    }
}
