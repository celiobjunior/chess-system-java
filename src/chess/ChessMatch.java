package chess;

import boardgame.Board;
import chess.pieces.King;

public class ChessMatch
{
    private Board board;

    public ChessMatch()
    {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces()
    {
        ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getCols()];

        for (int i = 0; i < board.getRows(); i++)
            for (int j = 0; j < board.getCols(); j++)
                chessPieces[i][j] = (ChessPiece) board.piece(i, j);

        return chessPieces;
    }

    private void placeNewPiece(char col, int row, ChessPiece piece)
    {
        board.placePiece(piece, new ChessPosition(col, row).toPosition());
    }

    private void initialSetup()
    {
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
    }

}
