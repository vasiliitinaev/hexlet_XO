package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();
    private static final String SEPARATOR = "~~~~~~~~~~~\n";



    public void show(Game game) throws InvalidPointException {

        final StringBuilder fieldBuilder = new StringBuilder();
        final Field field = game.getField();
        final int MAX_SIZE = field.getSize();

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                final Point point = new Point(i, j);
                fieldBuilder.append(itemOutput(field, point));

                if (j < MAX_SIZE-1) {
                    fieldBuilder.append("|");
                }
            }
            if (i < MAX_SIZE-1) {
                fieldBuilder.append(System.lineSeparator());
                fieldBuilder.append(SEPARATOR);
            }
        }

        fieldBuilder.append(System.lineSeparator());
        System.out.println(fieldBuilder);
    }

    public boolean move(final Game game) throws InvalidPointException, AlreadyOccupiedException {
        final Field field = game.getField();
        //final Figure currentFigure = currentMoveController.currentMove(field);
        //if (currentFigure == null) {
        //    final Figure winner = winnerController.getWinner(field);
        //    if (winner == null) {
        //        System.out.println("No winner and no move left!");
        //        return false;
        //    } else {
        //        System.out.format("Winner is: %\n", winner);
        //        return false;
        //    }
        //}

        // Мой код
        final Figure currentFigure = currentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);

        if (currentFigure == null  &&  winner == null) {
            System.out.println("No winner and no move left!");
            return false;
        }

        if (winner != null) {
            System.out.format("Winner is: %s\n", winner.toString());
            return false;
        }

        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }

        return true;
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
        System.out.format("Please input %s:", coordinateName, ": ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


}
