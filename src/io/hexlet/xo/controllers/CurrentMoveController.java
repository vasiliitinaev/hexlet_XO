package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        Figure result;

        int countX = 0;
        int countY = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Point point = new Point(i, j);
                if (field.getFigure(point) == Figure.X) {
                    countX++;
                } else {
                    if (field.getFigure(point) == Figure.O) {
                        countY++;
                    }
                }
            }
        }

        if (countX <= countY) {
            result = Figure.X;
        } else {
            result = Figure.O;
        }
        return result;
    }

}
