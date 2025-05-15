package java_app.game_service.model;

public class Piece {
    private PieceType type;
    private Color color;

    public Piece(PieceType type, Color color) {
        this.type = type;
        this.color = color;
    }

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}

