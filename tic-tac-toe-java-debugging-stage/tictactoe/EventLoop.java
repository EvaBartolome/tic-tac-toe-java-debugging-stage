package tictactoe;

public class EventLoop { //the code checks the values of its state variables and updates the user interface as required

    // Instance variables for the UI and State classes
    State state = new State(); //represents current state of tictactoe game
    UI ui = new UI(); //represents the user interface for game - handling interactions with the user
    int row, col; //used to store row and column values for users moves

    public static void main(String [] args) {
        EventLoop eventLoop = new EventLoop(); //instantiate instance of eventloop
        eventLoop.run(); //call run method
    }

    public void run() { 
        while (state.getGameState() != Constants.QUIT_PROGRAM) { // continuously checks the current game state
            int gameState = state.getGameState(); //retrieves current game state and stored in variable gameState
            if (gameState == Constants.STANDBY) {
                state.setGameState(Constants.GET_X_NAME); //using the setGameState method, you set the game to GET_X_NAME

            } else if (gameState == Constants.GET_X_NAME) {
                state.setXName(ui.promptForName("X"));
                state.setGameState(Constants.GET_O_NAME);

            } else if (gameState == Constants.GET_O_NAME) {
                state.setOName(ui.promptForName("O"));
                state.setGameState(Constants.GET_X_MOVE);

            } else if (gameState == Constants.GET_X_MOVE) {
                ui.printBoard(state);
                row = ui.getMoveRow(state.getWhoseMove(), state.getXName(), state.getOName());
                col = ui.getMoveCol(state.getWhoseMove(), state.getXName(), state.getOName());
                if (ui.isLegalMove(state, row, col)) {
                    state.setGameState(Constants.MAKE_MOVE);
                }
            } else if (gameState == Constants.GET_O_MOVE) {
                ui.printBoard(state);
                row = ui.getMoveRow(state.getWhoseMove(), state.getXName(), state.getOName());
                col = ui.getMoveCol(state.getWhoseMove(), state.getXName(), state.getOName());
                if (ui.isLegalMove(state, row, col)) {
                    state.setGameState(Constants.MAKE_MOVE);
                }
            } else if (gameState == Constants.MAKE_MOVE) {
                ui.printMove(state, row, col);
                state.setBoardCell(row-1, col-1, state.getWhoseMove());
                state.setGameState(Constants.CHECK_IF_WINNER);

            } else if (gameState == Constants.CHECK_IF_WINNER) {
                if (state.isWinner()) {
                    if (state.getWhoseMove() == Constants.X) {
                        state.setGameState(Constants.X_WINS);
                    } else {
                        state.setGameState(Constants.O_WINS);
                    }
                } else {
                    state.setGameState(Constants.CHECK_IF_TIE);
                }
            } else if (gameState == Constants.CHECK_IF_TIE) {
                if (state.isTie()) {
                    ui.printTieGame();
                    state.setGameState(Constants.GAME_OVER);
                } else {
                    state.setWhoseMove(state.getWhoseMove() * -1);
                    if (state.getWhoseMove() == Constants.X) {
                        state.setGameState(Constants.GET_X_MOVE);
                    } else {
                        state.setGameState(Constants.GET_O_MOVE);
                    }
                }
            } else if (gameState == Constants.X_WINS) {
                ui.printWinner(state);
                state.setGameState(Constants.GAME_OVER);

            } else if (gameState == Constants.O_WINS) {
                ui.printWinner(state);
                state.setGameState(Constants.GAME_OVER);
            } else if (gameState == Constants.GAME_OVER) {
                if (ui.startNewGame()) {
                    state.setGameState(Constants.STANDBY);
                    state.reset(); //reset board
                } else {
                    state.setGameState(Constants.QUIT_PROGRAM);
                }
            }
        }
    }
}
