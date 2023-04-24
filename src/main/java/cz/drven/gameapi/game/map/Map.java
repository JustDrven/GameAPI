package cz.drven.gameapi.game.map;

public class Map {

    private String name;
    private int votes;

    public Map(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }

    public void removeVote() {
        votes--;
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Votes: " + votes;
    }
}
