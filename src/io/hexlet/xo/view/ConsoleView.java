package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();
    private static final String SEPARATOR = "~~~~~~~~~~~\n";
    private final StringBuilder fieldBuilder = new StringBuilder();


    public void show(Game game) throws InvalidPointException {

        final Field field = game.getField();
        final int MAX_SIZE = field.getSize();

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                final Point point = new Point(i, j);
                this.fieldBuilder.append(itemOutput(field, point));

                if (j < MAX_SIZE-1) {
                    this.fieldBuilder.append("|");
                }
            }
            if (i < MAX_SIZE-1) {
                this.fieldBuilder.append(System.lineSeparator());
                this.fieldBuilder.append(SEPARATOR);
            }
        }

        this.fieldBuilder.append(System.lineSeparator());
        System.out.println(fieldBuilder);
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            final Figure winner = winnerController.getWinner(field);
            if (winner == null) {
                System.out.println("No winner an dno move left!");
                return false;
            } else {
                System.out.format("Winner is: %\n", winner);
                return false;
            }
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        moveController.applyFigure(field,
                currentFigure,
                point);
    }

    // Вывод содержимого клетки
    private String itemOutput(Field field, Point point) throws InvalidPointException {
        if (field.getFigure(point) == Figure.X) {
            return " X ";
        }
        else {
            if (field.getFigure(point) == Figure.O) {
                return " O ";
            }
            else {
                return "   ";
            }
        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s", coordinateName);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


}
