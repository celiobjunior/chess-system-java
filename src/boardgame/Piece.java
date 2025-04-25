package boardgame;

public abstract class Piece
{
    protected Position position;
    private Board board;

    public Piece(Board board)
    {
        this.board = board;
        position = null;
    }

    protected Board getBoard()
    {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position pos)
    {
        return possibleMoves()[position.getRow()][position.getCol()];
    }
    public boolean isThereAnyPossibleMove()
    {
        boolean[][] aux = possibleMoves();
        for(int i = 0; i < aux.length; i++)
        {
            for (int j = 0; j < aux.length; j++)
            {
                if(aux[i][j]) return true;
            }
        }
        return false;
    }
}
