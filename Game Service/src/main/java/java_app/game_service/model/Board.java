package java_app.game_service.model;

public class Board {
    private Piece[][] squares = new Piece[8][8];

    public Board() {
        initialize();
    }

    public void initialize() {
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                squares[r][c] = null;

        for (int c = 0; c < 8; c++) {
            squares[1][c] = new Piece(PieceType.PAWN, Color.BLACK);
            squares[6][c] = new Piece(PieceType.PAWN, Color.WHITE);
        }

        squares[0][0] = new Piece(PieceType.ROOK, Color.BLACK);
        squares[0][7] = new Piece(PieceType.ROOK, Color.BLACK);
        squares[7][0] = new Piece(PieceType.ROOK, Color.WHITE);
        squares[7][7] = new Piece(PieceType.ROOK, Color.WHITE);

    }

    public Piece getPieceAt(Position pos) {
        return squares[pos.getRow()][pos.getCol()];
    }

    public void setPieceAt(Position pos, Piece piece) {
        squares[pos.getRow()][pos.getCol()] = piece;
    }

    public Piece[][] getSquares() {
        return squares;
    }
}
