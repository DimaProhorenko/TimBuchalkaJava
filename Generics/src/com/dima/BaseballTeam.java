package com.dima;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {
    private String name;
    private List<BaseballPlayer> playersList = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String name) {
        this.name = name;
    }

    public void addTeamMember(BaseballPlayer player) {
        if(!playersList.contains(player)) {
            playersList.add(player);
        }
    }

    public void listTeamMembers() {
        System.out.println("Name -> " + name);
        System.out.println(playersList);
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