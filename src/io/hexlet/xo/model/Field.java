package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MAX_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private final int fieldSize;

    private final Figure[][] field;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new Figure[fieldSize][fieldSize];
    }

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
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field.length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
