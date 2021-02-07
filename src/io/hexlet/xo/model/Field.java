package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MAX_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = MAX_SIZE;

    private  final Figure[][] field = new Figure[MAX_SIZE][MAX_SIZE];

    public int getSize() {
        return MAX_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) throw new InvalidPointException();
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint (final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

}
