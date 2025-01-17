import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Initializing the game board
        char[][] board = new char[3][3];

        //Populating the board with default values
        for (char[] rows : board)
            Arrays.fill(rows, ' ');

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        int index;

        while (!gameOver) {
            print(board);
            System.out.println("-------------------");
            System.out.print( player+"'s move : ");
            index = scanner.nextInt();
            if(isValid(board, index)) {
                board[(index-1)/3][(index-1)%3] = player;
                if(haveWon(board,player)){
                    print(board);
                    System.out.println("Player "+player+" won the match...");
                    gameOver = true;
                }
                if(isDraw(board)) {
                    print(board);
                    System.out.println("This match is a draw...");
                    gameOver = true;
                }
                player = (player == 'X') ? 'O' : 'X';
            }
            else
                System.out.println("Invalid move...Try again");
        }
    }

        //Checks if the game is still in play
        private static boolean isDraw(char[][] board) {
            for(char[] rows : board) {
                for(char col : rows) {
                    if(col == ' ')
                        return false;
                }
            }
            return true;
        }

        private static boolean haveWon(char[][] board, char player) {

            // Checks rows
            for (int i = 0; i < board.length; i++) {
                if(board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    return true;
            }

            // Checks columns
            for (int i = 0; i < board.length; i++) {
                if(board[0][i] == player && board[1][i] == player && board[2][i] == player)
                    return true;
            }

            // Checks either of the diagonals
            return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
        }

        private static boolean isValid(char[][] board, int index) {
            return index >=1 && index <=9 && board[(index-1)/3][(index-1)%3] == ' ';
        }

        //Prints out the board in the console
        private static void print(char[][] board) {
            for(char[] rows : board) {
                for (char col : rows)
                    System.out.print(" [ "+col+" ] ");
                System.out.println();
            }
        }
}