package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State //represents current state of tictactoe game
{
    private int gameState = Constants.STANDBY; //current game state
    private int whoseMove = Constants.X; //keeps track of whose move it is
    private String xName = ""; //keeps track of player names
    private String oName = ""; 
    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE]; //keeps track of state of board

    public boolean isWinner() { //determines if winner
        int total;
        for (int row=0; row<Constants.BOARD_SIZE; row++) { //Check for winning combinations in rows
            total = getBoardCell(row, 0) + getBoardCell(row,1) + getBoardCell(row,2);
            if (total == -3 || total == 3) return true;
        }
        for (int col=0; col<Constants.BOARD_SIZE; col++) { //Check for winning combinations in columns
            total = getBoardCell(0, col) + getBoardCell(1,col) + getBoardCell(2, col);
            if (total == -3 || total == 3) return true;
        }
        total = getBoardCell(0, 0) + getBoardCell(1,1) + getBoardCell(2, 2); //Check for winning combinations in diagonals
        if (total == -3 || total == 3) return true;
        total = getBoardCell(2, 0) + getBoardCell(1,1) + getBoardCell(0, 2);
        if (total == -3 || total == 3) return true;
        return false; //If no winning combinations found, return false
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_SIZE; row++) { //Iterate over each cell in the game board
            for (int col=0; col<Constants.BOARD_SIZE; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) { //If any cell is blank, the game is not a tie
                    return false;
                }
            }
        }
        return true; //If all cells filled and no winner detected, tie game
    }

    public int getGameState() { //gets current state of game: standby, get player names, making moves, etc.
        return gameState;
    }

    public void setGameState(int gameState) { //updates the gameState field w/ new value (from constants)
        this.gameState = gameState;
    }

    public int getWhoseMove() { //either Constants.X or Constants.O
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove){ //updates int whoseMove representing whose turn it is with provided value
        this.whoseMove = whoseMove;
    }

    public String getXName() { //returns the value of the xName variable stored in gameState object
        return xName;
    }

    public void setXName(String xName) { //updates value of the xName variable in the game state to "PlayerX"
        this.xName = xName;
    }

    public String getOName() { //allows you to access the name of player O during the game
        return oName;
    }

    public void setOName(String oName) { //allows to set O name during the game
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) { //returns value of board cell at the specified row and column
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {//sets value of board cell at the specified row and column with provided integer value, 
        //(ex: updates the value of the specified cell on the game board with "X", indicating that player X made a move in that cell)
        this.board[row][col] = value;
    }

    public void reset() { //Set relevant state variables to their initial values
        this.gameState = Constants.STANDBY; //set game to standby
        this.whoseMove = Constants.X; //indicates x player turn, starts game with player x
        this.xName = ""; //resets x name
        this.oName = ""; //resets o name
        this.board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE]; //initializes board array, clears board
    }
}
