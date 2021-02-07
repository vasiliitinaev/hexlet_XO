package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(Field field) throws InvalidPointException {

        int MAX_SIZE = field.getSize();

        Figure winner = null;
        Figure interWinner = null;


        // Проходим по строкам
        for (int i = 0; i < MAX_SIZE; i++) {
            interWinner = null;
            interWinner = checkWinnerInLine(getGorizontalLine(field, i));
            if ((interWinner == Figure.X) || (interWinner == Figure.O)) {
                winner = interWinner;
            }
        }


        // Проходим по столбцам
        for (int j = 0; j < MAX_SIZE; j++) {
            interWinner = null;
            interWinner = checkWinnerInLine(getVerticalLine(field, j));
            if ((interWinner == Figure.X) || (interWinner == Figure.O)) {
                winner = interWinner;
            }
        }


        // Проходим по левой диагонали
        for (int i = 0; i < MAX_SIZE; i++) {
            interWinner = null;
            interWinner = checkWinnerInLine(getLeftDiagonal(field));
            if ((interWinner == Figure.X) || (interWinner == Figure.O)) {
                winner = interWinner;
            }
        }


        // Проходим по правой диагонали
        for (int i = 0; i < MAX_SIZE; i++) {
            interWinner = null;
            interWinner = checkWinnerInLine(getRightDiagonal(field));
            if ((interWinner == Figure.X) || (interWinner == Figure.O)) {
                winner = interWinner;
            }
        }

        return winner;
    }



    // Метод формирования массива XO по вертикальной линии
    Figure[] getVerticalLine(Field field, int columnNumber) throws InvalidPointException {

        final int MAX_SIZE = field.getSize();
        Figure[] verticalLine = new Figure[MAX_SIZE];

        for (int j = 0; j < MAX_SIZE; j++) {
            Point point = new Point(j, columnNumber);
            verticalLine[j] = field.getFigure(point);
        }

        return verticalLine;
    }


    // Метод формирования массива XO по горионтальной линии
    Figure[] getGorizontalLine(Field field, int rowNumber) throws InvalidPointException {

        final int MAX_SIZE = field.getSize();
        Figure[] gorizontalLine = new Figure[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            Point point = new Point(rowNumber, i);
            gorizontalLine[i] = field.getFigure(point);
        }

        return gorizontalLine;
    }



    // Метод получения победителя из переданного массива строк
    Figure checkWinnerInLine(Figure[] line) {
        int countX = 0;
        int countO = 0;

        for (Figure figure : line) {
            if (figure == Figure.X) {
                countX++;
            } else {
                if (figure == Figure.O) {
                    countO++;
                }
            }
        }

        if (countX == line.length) {
            return Figure.X;
        }
        else {
            if (countO == line.length) {
                return Figure.O;
            }
            else {
                return null;
            }
        }
    }



    // Метод формирования массива по левой диагонали (слева направо)
    Figure[] getLeftDiagonal(Field field) throws InvalidPointException {

        final int MAX_SIZE = field.getSize();
        Figure[] leftLine = new Figure[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            Point point = new Point(i, i);
            leftLine[i] = field.getFigure(point);
        }

        return leftLine;
    }



    // Метод формирования массива по правой диагонали (справа налево)
    Figure[] getRightDiagonal(final Field field) throws InvalidPointException {

        final int MAX_SIZE = field.getSize();
        Figure[] rightLine = new Figure[MAX_SIZE];


        for (int i = MAX_SIZE-1; i >= 0; i--) {
            Point point = new Point(i, MAX_SIZE-i-1);
            rightLine[i] = field.getFigure(point);
        }

        return rightLine;
    }
}
