package chess;

import boardgame.Board;

public class ChessMatch
{
    private Board board;

    public ChessMatch()
    {
        board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces()
    {
        ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getCols()];

        for (int i = 0; i < board.getRows(); i++)
            for (int j = 0; j < board.getCols(); j++)
                chessPieces[i][j] = (ChessPiece) board.piece(i, j);

        return chessPieces;
    }
}
