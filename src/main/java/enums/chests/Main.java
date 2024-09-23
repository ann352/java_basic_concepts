package enums.chests;

public class Main {
    public static void main(String[] args) {
        printMove(ChestType.PAWN, "C4");

    }

    public static String printMove(ChestType chestType, String move){
        System.out.println("I move "+ chestType.getSymbol() + " " + chestType.getDescription() + " to the field " + move);
        return move;
    }
}
