package application;

import boardgame.Position;

public class Main
{
    public static void main(String[] args)
    {
        Position pos = new Position(0, 0);
        Position pos2 = new Position(0, 1);
        Position pos3 = new Position(1, 0);

        System.out.println(pos);
        System.out.println(pos2);
        System.out.println(pos3);
    }
}
