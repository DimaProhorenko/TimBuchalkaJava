package com.dima;
record BaseballPlayer(String name, String position){}

public class Main {
    public static void main(String[] args) {
        BaseballTeam a = new BaseballTeam("Tigers");
        BaseballTeam b = new BaseballTeam("New Horizon");
        scoreResult(a, b, 2, 3);

        BaseballPlayer haesh = new BaseballPlayer("Haesh", "Right fielder");
        BaseballPlayer johny = new BaseballPlayer("John", "Left fielder");

        a.addTeamMember(haesh);
        a.addTeamMember(johny);
        a.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam a, BaseballTeam b, int aScore, int bScore) {
        String msg = a.setScore(aScore, bScore);
        b.setScore(bScore, aScore);
        System.out.printf("%s %s %s\n", a, msg, b);
    }
}
