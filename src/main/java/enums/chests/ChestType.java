package enums.chests;

public enum ChestType {
    PAWN("♟", "pawn"),
    ROOK("♜", "rook"),
    QUEEN("♛", "quenn");

    private final String description;
    private final String symbol;

    ChestType(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
}
