package tictactoe;
import java.util.Scanner;

/**
 * UI class
 */
public class UI //reflect the values of the state variables, updates the display when change in state variables

{

    Scanner scanner; //initializes scanner object

    public UI() {
        scanner = new Scanner(System.in);         
    }

    // Utility methods
    public String getXOrO(int whoseMove) { //returns X if whose move is -1, O if 1, space character if neither
        if (whoseMove == -1) {
             return "X";
        }else if (whoseMove == 1) {
            return "O";
        }else{
            return " ";
        }
    }
    
        public String getPlayerName(int whoseMove, String xName, String yName) { //returns player name based on whoseMove
        return (whoseMove == -1) ? xName : yName;
    }

    public boolean isLegalMove(State state, int row, int col) { //Checks if move at row/column is legal
        return 1 <= row && row <= Constants.BOARD_SIZE && //check row
        1 <= col && col <= Constants.BOARD_SIZE && //check col
        state.getBoardCell(row-1, col-1) == Constants.BLANK; //checks if cell is empty
    }

    // Prompt for input methods
    public String promptForName(String player) { //reads user's input from console using Scanner
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }

    public int getMoveRow(int whoseMove, String xName, String oName) { //prompts user for row placement
        int row = 0; //loop around until gets valid val for row
        boolean isLegalMove = false;
        while (isLegalMove != true) {
            try {
                System.out.printf(Constants.GET_ROW_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                row = scanner.nextInt();
                isLegalMove = true;
            } catch (Exception e) {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                scanner.next();
            }
        }
        while (row <= 0 || row >= 4) {
            try {
                System.out.printf(Constants.GET_ROW_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                row = scanner.nextInt();
                if (row <= 0 || row >= 4){
                    System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                scanner.next();
            }
        }
        return row;
    }

    public int getMoveCol(int whoseMove, String xName, String oName) { //prompts user for column placement
        int col = 0; //loop around until gets valid value for col
        boolean isLegalMove = false;
        while (isLegalMove != true) {
            try {
                System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                col = scanner.nextInt();
                isLegalMove = true;
            } catch (Exception e) {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                scanner.next();
            }
        }
        while (col <= 0 || col >= 4) {
            try {
                System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                col = scanner.nextInt();
                if (col <= 0 || col >= 4){
                    System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                scanner.next();
            }
        }
        return col;
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next(); //gets input
        return yesOrNo.equals ("Y") || yesOrNo.equals ("y")|| yesOrNo.equals ("yes")|| yesOrNo.equals ("Yes"); //equals method for equality on a string (== compares memory addresses of objects, not actual content)
    }

    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row, 0)), getXOrO(state.getBoardCell(row, 1)), getXOrO(state.getBoardCell(row, 2)));
            System.out.println();
            System.out.println(Constants.DIVIDER_STRING);
        }
    }

    public void printInvalidRowOrColumn() {
        System.out.printf(Constants.INVALID_ROW_OR_COLUMN);
    }

    public void printInvalidMove(int row, int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
    }

    public void printMove(State state, int row, int col) {
        System.out.printf(
            Constants.PRINT_MOVE, 
            getXOrO(state.getWhoseMove()), 
            getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()),
            row, 
            col
        );
        System.out.println();
    } 

    public void printWinner(State state) {
        System.out.printf(
            Constants.WINNER, 
            getXOrO(state.getWhoseMove()), 
            getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()
            ));
        System.out.println();
    }

    public void printTieGame() {
        System.out.println(Constants.TIE_GAME);
    }
}
