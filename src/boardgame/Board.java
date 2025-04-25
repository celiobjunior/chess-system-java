package boardgame;

public class Board
{
    private int rows;
    private int cols;
    private Piece[][] pieces;

    public Board(int cols, int rows)
    {
        if (cols < 1 || rows < 1)
            throw new BoardException("Error creating the board: it requires at least one column and one row");
        this.cols = cols;
        this.rows = rows;
        pieces = new Piece[rows][cols];
    }

    public int getRows()
    {
        return rows;
    }

    public int getCols()
    {
        return cols;
    }

    public Piece piece(int row, int col)
    {
        if (!positionExists(row, col))
            throw new BoardException("Error accessing the piece: position does not exist");
        return pieces[row][col];
    }

    public Piece piece(Position pos)
    {
        return piece(pos.getRow(), pos.getCol());
    }

    public void placePiece(Piece piece, Position pos)
    {
        if (thereIsAPiece(pos))
            throw new BoardException("Error placing the piece: there is already a piece on the position " + pos);
        pieces[pos.getRow()][pos.getCol()] = piece;
        piece.position = pos;
    }

    public Piece removePiece(Position pos)
    {
        if(!positionExists(pos)) throw new BoardException("Error accessing the piece: position " +  pos + " does not exist");

        if (piece(pos) == null) return null;

        Piece p = piece(pos);
        p.position = null;
        pieces[pos.getRow()][pos.getCol()] = null;
        return p;
    }


    private boolean positionExists(int row, int col)
    {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean positionExists(Position pos)
    {
        return positionExists(pos.getRow(), pos.getCol());
    }

    public boolean thereIsAPiece(Position pos)
    {
        if (!positionExists(pos))
            throw new BoardException("Error accessing the piece: position does not exist");
        return piece(pos) != null;
    }
}
