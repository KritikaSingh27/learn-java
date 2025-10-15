package Backtracking;

public class NQueens {
    //cheking if the place is safe to place the queen
    public static boolean isSafe(char board[][], int row, int col){
        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal left up
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    //To print all the possibilities of placing the queens
    public static void nQueensAll(char board[][], int row){
        //base case
        if(row == board.length){
            printBoard(board);
            return;
        }
        //placing the queens by checking right positions using backtracking
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueensAll(board, row+1); //function recursive call
                board[row][j] = 'X'; //backtracking step
            }
        }
    }

    //To print the board
    public static void printBoard(char board[][]){
        System.out.println("----- Chess Board -----");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        //initializing the board
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }
        nQueensAll(board, 0);
    }
}
