package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) throws InvalidPointException {
        final String name1 = "Vasya";
        final String name2 = "Robot";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Field field = new Field(3);

        Game game = new Game("Игра", field,  players);

        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(game);
    }





}
