package kov;

public class Board {

    private Figure figure11 = new Figure(" ");
    private Figure figure12 = new Figure(" ");
    private Figure figure13 = new Figure(" ");
    private Figure figure21 = new Figure(" ");
    private Figure figure22 = new Figure(" ");
    private Figure figure23 = new Figure(" ");
    private Figure figure31 = new Figure(" ");
    private Figure figure32 = new Figure(" ");
    private Figure figure33 = new Figure(" ");


    public void printBoard() {
        System.out.printf("%s|%s|%s\n", figure11.getFigure(), figure12.getFigure(), figure13.getFigure());
        System.out.println("-----");
        System.out.printf("%s|%s|%s\n", figure21.getFigure(), figure22.getFigure(), figure23.getFigure());
        System.out.println("-----");
        System.out.printf("%s|%s|%s\n", figure31.getFigure(), figure32.getFigure(), figure33.getFigure());
    }
}
