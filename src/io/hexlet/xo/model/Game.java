package io.hexlet.xo.model;

public class Game {
    final private Player[] players;
    final private String name;
    final private Field field;

    public Game(final String name, final Field field, final Player[] players) {
        this.name = name;
        this.field = field;
        this.players = players;
    }



    public Player[] getPlayers() {
        return this.players;
    }

    public Field getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }
}
