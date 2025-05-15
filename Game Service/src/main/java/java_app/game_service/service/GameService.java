package java_app.game_service.service;


import java_app.game_service.model.*;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Board board;
    private Color currentTurn;

    public GameService() {
        resetGame();
    }

    public void resetGame() {
        board = new Board();
        currentTurn = Color.WHITE;
    }

    public Board getBoard() {
        return board;
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }

    public boolean makeMove(Position from, Position to) {
        Piece piece = board.getPieceAt(from);

        if (piece == null || piece.getColor() != currentTurn) {
            return false;
        }

        if (!isValidMove(piece, from, to)) {
            return false;
        }

        board.setPieceAt(to, piece);
        board.setPieceAt(from, null);

        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;

        return true;
    }

    private boolean isValidMove(Piece piece, Position from, Position to) {
        if (!isInBounds(to)) return false;

        Piece destPiece = board.getPieceAt(to);
        if (destPiece != null && destPiece.getColor() == piece.getColor()) return false;

        switch (piece.getType()) {
            case PAWN:
                return validatePawnMove(piece, from, to);
            case ROOK:
                return validateRookMove(from, to);
            default:
                return false;
        }
    }

    private boolean isInBounds(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < 8 && pos.getCol() >= 0 && pos.getCol() < 8;
    }

    private boolean validatePawnMove(Piece pawn, Position from, Position to) {
        int direction = (pawn.getColor() == Color.WHITE) ? -1 : 1;
        int startRow = (pawn.getColor() == Color.WHITE) ? 6 : 1;

        int rowDiff = to.getRow() - from.getRow();
        int colDiff = to.getCol() - from.getCol();

        Piece destPiece = board.getPieceAt(to);

        if (colDiff == 0) {
            if (rowDiff == direction && destPiece == null) {
                return true;
            }
            if (rowDiff == 2 * direction && from.getRow() == startRow && destPiece == null) {
                Position intermediate = new Position(from.getRow() + direction, from.getCol());
                if (board.getPieceAt(intermediate) == null) {
                    return true;
                }
            }
        }

        if (Math.abs(colDiff) == 1 && rowDiff == direction && destPiece != null && destPiece.getColor() != pawn.getColor()) {
            return true;
        }

        return false;
    }

    private boolean validateRookMove(Position from, Position to) {
        int rowDiff = to.getRow() - from.getRow();
        int colDiff = to.getCol() - from.getCol();

        if (rowDiff != 0 && colDiff != 0) {
            return false;
        }

        int rowStep = Integer.signum(rowDiff);
        int colStep = Integer.signum(colDiff);

        int currentRow = from.getRow() + rowStep;
        int currentCol = from.getCol() + colStep;

        while (currentRow != to.getRow() || currentCol != to.getCol()) {
            if (board.getPieceAt(new Position(currentRow, currentCol)) != null) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }

        return true;
    }
}
