package com.alkemann.advent.nine;

import java.util.HashMap;

public class City {

    protected String name;
    protected HashMap<String, Integer> routes;
    protected HashMap<String, City> neighbors;
    protected int cost = Integer.MAX_VALUE;

    public City(String name) {
        this.name = name;
        routes = new HashMap<>(20);
        neighbors = new HashMap<>(20);
    }

    public void addRoute(City city, int distance) {
        routes.put(city.name, distance);
        neighbors.put(city.name, city);
    }

    @Override
    public String toString() {
        return "City{name='" + name + "', cost=" + cost  + "'}";
    }

    public HashMap<String, City> getNeighbors() {
        return (HashMap<String, City>) neighbors.clone();
    }
}
