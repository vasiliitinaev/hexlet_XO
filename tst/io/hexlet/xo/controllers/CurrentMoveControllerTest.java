package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveEmpty() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveX() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(2,1), Figure.O);

        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveO() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(2,2), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(1,0), Figure.X);

        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }
}