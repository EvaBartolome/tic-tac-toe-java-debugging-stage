package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    public int whosemove(){
        return this.whoseMove;
    }

    public String xName(){
        return this.xName;
    }

    public String oName(){
        return this.oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public boolean isWinner() {
        // winning player is the one stored in the whoseMove state variable.  
    }

    public boolean isTie() {
        // You will write this code too!!
    }

}

