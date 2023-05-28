package com.dima;

interface Player {
    String name();
}
record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position) implements Player{}

public class Main {
    public static void main(String[] args) {
//        BaseballTeam a = new BaseballTeam("Tigers");
//        BaseballTeam b = new BaseballTeam("New Horizon");
//        scoreResult(a, b, 2, 3);
//
//        BaseballPlayer haesh = new BaseballPlayer("Haesh", "Right fielder");
//        BaseballPlayer johny = new BaseballPlayer("John", "Left fielder");
//
//        a.addTeamMember(haesh);
//        a.addTeamMember(johny);
//        a.listTeamMembers();

        Affiliation philly = new Affiliation("city", "Philadelphia, PA", "US");
        Affiliation madrid = new Affiliation("city", "Madrid", "Spanin");

        Team<BaseballPlayer,Affiliation> philipines = new Team<>("Philipines", philly);
        Team<FootballPlayer, Affiliation> realMadrid = new Team<>("Real Madrid", madrid);
        realMadrid.addTeamMember(new FootballPlayer("Benzema", "Forward"));
        realMadrid.addTeamMember(new FootballPlayer("Ronaldo", "Forward"));
        realMadrid.addTeamMember(new FootballPlayer("Costa", "defender"));
        realMadrid.listTeamMembers();
//        Team<Integer> notValid = new FootballTeam("Not Valid");
    }

    public static void scoreResult(BaseballTeam a, BaseballTeam b, int aScore, int bScore) {
        String msg = a.setScore(aScore, bScore);
        b.setScore(bScore, aScore);
        System.out.printf("%s %s %s\n", a, msg, b);
    }

    public static void scoreResult(Team a, Team b, int aScore, int bScore) {
        scoreResult(a, b, aScore, bScore);
    }
}
