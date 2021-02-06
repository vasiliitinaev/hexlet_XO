package io.hexlet.xo.model;

import java.awt.*;

public class Field {

    private static final int MAX_SIZE = 3;

    private  final Figure[][] field = new Figure[MAX_SIZE][MAX_SIZE];

    public int getSize() {
        return MAX_SIZE;
    }

    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, Figure figure) {
        field[point.x][point.y] = figure;
    }

}
