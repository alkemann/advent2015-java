package com.alkemann.advent.nine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class City {

    protected String name;
    protected HashMap<String, Integer> routes;
    protected HashMap<String, City> neighbors;
    protected int cost = Integer.MAX_VALUE;
    protected boolean visited = false;

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

    public List<City> getNeighbors() {
        List<City> unvistedNeighbors = new ArrayList<>();
        for (Entry<String, City> entry : neighbors.entrySet()) {
            City c = entry.getValue();
            if (c.isVisited() == false) {
                unvistedNeighbors.add(c);
            }
        }
        return unvistedNeighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visited() {
        visited = true;
    }

    public int distanceTo(String neighborCityName) {
        return routes.get(neighborCityName);
    }
}
