package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State //serves as repo for game info - gameState, xName, oName, etc.
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    public boolean isWinner() {
        int total;
        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            total = getBoardCell(row, 0) + getBoardCell(row,1) + getBoardCell(row,2);
            if (total == -3 || total == 3) return true;
        }
        for (int col=0; col<Constants.BOARD_SIZE; col++) {
            total = getBoardCell(0, col) + getBoardCell(1,col) + getBoardCell(2, col);
            if (total == -3 || total == 3) return true;
        }
        total = getBoardCell(0, 0) + getBoardCell(1,1) + getBoardCell(2, 2);
        if (total == -3 || total == 3) return true;
        total = getBoardCell(2, 0) + getBoardCell(1,1) + getBoardCell(0, 2);
        if (total == -3 || total == 3) return true;
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            for (int col=0; col<Constants.BOARD_SIZE; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() { //current state of game: standby, get player names, making moves, etc.
        return gameState;
    }

    public void setGameState(int gameState) { //updates the gameState field w/ new value
        this.gameState = gameState;
    }

    public int getWhoseMove() { //Constants.X or Constants.O
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove){
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }
    
    public void reset() {
        this.gameState = Constants.STANDBY; //set game to standby
        this.whoseMove = Constants.X; //indicates x player turn, starts game with player x
        this.xName = ""; //resets x name
        this.oName = ""; //resets o name
        this.board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE]; //initializes board array, clears board
    }
}
