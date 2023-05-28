package com.dima;

import java.util.ArrayList;
import java.util.List;


record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return String.format("%S (%s in %s)", name, type, countryCode);
    }
}

public class Team<T extends Player, S> {
    private String name;
    private List<T> playersList = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, S affiliation) {
        this.name = name;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {
        if(!playersList.contains(t)) {
            playersList.add(t);
        }
    }

    public void listTeamMembers() {
        System.out.print("Name -> " + name);
        System.out.print(affiliation == null ? "" : "Affiliation: " + affiliation);
        playersList.forEach((T t) -> {
            System.out.println(t.name());
        });
    }

    public int ranking() {
        return totalLosses * 2 + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if( ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if(ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s (rank %d)", name, ranking());
    }
}
