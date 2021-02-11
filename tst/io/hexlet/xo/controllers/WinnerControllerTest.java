package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertEquals(Figure.X,winnerController.getWinner(field));
        }
    }


    @Test
    public void getWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);
            assertEquals(null,winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.X);
            assertEquals(Figure.X,winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.O);
            assertEquals(null,winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerDiagonal1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i,i), Figure.X);
        }

        assertEquals(Figure.X,winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                field.setFigure(new Point(i,i), Figure.X);
            }
            else {
                field.setFigure(new Point(i,i), Figure.O);
            }
        }

        assertEquals(null,winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenWinnerDiagonal2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i,field.getSize()-1-i), Figure.X);
        }

        assertEquals(Figure.X,winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                field.setFigure(new Point(i,field.getSize()-1-i), Figure.X);
            }
            else {
                field.setFigure(new Point(i,field.getSize()-1-i), Figure.O);
            }
        }

        assertEquals(null,winnerController.getWinner(field));
    }



}