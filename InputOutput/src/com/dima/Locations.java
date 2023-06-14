package com.dima;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    static {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")));
             Scanner existsScanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String desc = scanner.nextLine();
                locations.put(loc, new Location(loc, desc, null));
            }

            while(existsScanner.hasNextLine()) {
                String[] data = existsScanner.nextLine().split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                locations.get(loc).addExit(direction, destination);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location location : locations.values()) {
                locFile.write("%s,%s%n".formatted(location.getLocationID(), location.getDescription()));
                for (String direction : location.getExits().keySet()) {
                    dirFile.write("%d,%s,%s%n"
                            .formatted(location.getLocationID(), direction, location.getExits().get(direction)));
                }
            }
        } catch (IOException e) {
            System.out.println("File error " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
