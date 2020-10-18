import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public static Scanner sc = new Scanner(System.in);
	public static Random random = new Random();
	
	public static void initializeBoard(char[][] gameBoard) {
		int place = 0;
		for(int i = 0 ; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				place++;
				gameBoard[i][j] = (char)(place + '0');
			}
		}
	}
	
	public static void printBoard(char[][] gameBoard) {
		System.out.println("=========");
		for(int i = 0 ; i < gameBoard.length; i++) {
			System.out.print("  ");
			for(int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=========");
	}
	public static boolean checkBoardFull(char[][] gameBoard) {
		int place = 0;
		for(int i = 0 ; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				place++;
				if(gameBoard[i][j] == (char)(place + '0'))
					return false;
			}
		}
		return true;
	}
	public static int checkGameStatus(char[][] gameBoard) {
		/* return 0 => Tied
		 * return 1 => X win
		 * return 2 => O win */
		if(gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X')
			return 1;
		if(gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O')
			return 2;
		if(gameBoard[0][1] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][1] == 'X')
			return 1;
		if(gameBoard[0][1] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][1] == 'O')
			return 2;
		if(gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X')
			return 1;
		if(gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O')
			return 2;
		if(gameBoard[0][0] == 'X' && gameBoard[0][1] == 'X' && gameBoard[0][2] == 'X')
			return 1;
		if(gameBoard[0][0] == 'O' && gameBoard[0][1] == 'O' && gameBoard[0][2] == 'O')
			return 2;
		if(gameBoard[1][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[1][2] == 'X')
			return 1;
		if(gameBoard[1][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[1][2] == 'O')
			return 2;
		if(gameBoard[2][0] == 'X' && gameBoard[2][1] == 'X' && gameBoard[2][2] == 'X')
			return 1;
		if(gameBoard[2][0] == 'O' && gameBoard[2][1] == 'O' && gameBoard[2][2] == 'O')
			return 2;
		if(gameBoard[0][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][2] == 'X')
			return 1;
		if(gameBoard[0][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][2] == 'O')
			return 2;
		if(gameBoard[0][2] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][0] == 'X')
			return 1;
		if(gameBoard[0][2] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][0] == 'O')
			return 2;	
		return 0;
	}
	
	public static void changeBoard(char[][] gameBoard, int place, char player) {
		switch(place) {
		case 1: gameBoard[0][0] = player; break;
		case 2: gameBoard[0][1] = player; break;
		case 3: gameBoard[0][2] = player; break;
		case 4: gameBoard[1][0] = player; break;
		case 5: gameBoard[1][1] = player; break;
		case 6: gameBoard[1][2] = player; break;
		case 7: gameBoard[2][0] = player; break;
		case 8: gameBoard[2][1] = player; break;
		case 9: gameBoard[2][2] = player; break;
		default: break;
		}
		return;
	}
	
	public static boolean checkIfPlaceFree(char[][] gameBoard, int place) {
		switch(place) {
		case 1:
			if(gameBoard[0][0] == '1')
				return true; 
			else if(gameBoard[0][0] == 'X' || gameBoard[0][0] == 'O')
				return false;
		case 2:
			if(gameBoard[0][1] == '2')
				return true; 
			else if(gameBoard[0][1] == 'X' || gameBoard[0][1] == 'O')
				return false;
		case 3: 
			if(gameBoard[0][2] == '3')
				return true; 
			else if(gameBoard[0][2] == 'X' || gameBoard[0][2] == 'O')
				return false;
		case 4: 
			if(gameBoard[1][0] == '4')
				return true;
			else if(gameBoard[1][0] == 'X' || gameBoard[1][0] == 'O')
				return false;
		case 5: 
			if(gameBoard[1][1] == '5')
				return true;
			else if(gameBoard[1][1] == 'X' || gameBoard[1][1] == 'O')
				return false;
		case 6: 
			if(gameBoard[1][2] == '6')
				return true;
			else if(gameBoard[1][2] == 'X' || gameBoard[1][2] == 'O')
				return false;
		case 7: 
			if(gameBoard[2][0] == '7')
				return true; 
			else if(gameBoard[2][0] == 'X' || gameBoard[2][0] == 'O')
				return false;
		case 8: 
			if(gameBoard[2][1] == '8')
				return true; 
			else if(gameBoard[2][1] == 'X' || gameBoard[2][1] == 'O')
				return false;
		case 9: 
			if(gameBoard[2][2] == '9')
				return true;
			else if(gameBoard[2][2] == 'X' || gameBoard[2][2] == 'O')
				return false;
		default : break;
		}
		return false;
	}
	
	public static String runGame(char[][] gameBoard) {
		boolean gameOver = false;
		char currentPlayer = 'X';
		int placeToPut = 0, gameStatus = 0;
		String printString = "";
		
		initializeBoard(gameBoard);
		
		while(!gameOver) {
			printBoard(gameBoard);
			System.out.print("Where do you want to put " + currentPlayer + "? [1-9] ");
			placeToPut = sc.nextInt();
			while(!checkIfPlaceFree(gameBoard, placeToPut)) {
				printBoard(gameBoard);
				System.out.print("Your chosen place is not valid... try again:");
				placeToPut = sc.nextInt();
			}
			
			changeBoard(gameBoard, placeToPut, currentPlayer);
			
			gameStatus = checkGameStatus(gameBoard);
			
			if(gameStatus == 0 && checkBoardFull(gameBoard)) {
				gameOver = true;
				printString = "Tied";
			}
			else if(gameStatus == 1) {
				gameOver = true;
				printString =  "X won";
			}	
			else if(gameStatus == 2) {
				gameOver = true;
				printString =  "O won";
			}
			//Switch player:
			if(!gameOver) {
				if(currentPlayer == 'X') 
					currentPlayer = 'O';
				else
					currentPlayer = 'X';
			}
			else
				printBoard(gameBoard);
		}
		
		return printString;
		
	}
	public static String runGameVsComputer(char[][] gameBoard) {
		boolean gameOver = false;
		char currentPlayer = 'X';
		int placeToPut = 0, gameStatus = 0;
		String printString = "";
		
		initializeBoard(gameBoard);
		
		while(!gameOver) {
			printBoard(gameBoard);
			if(currentPlayer == 'X') {
				System.out.print("Where do you want to put " + currentPlayer + "? [1-9] ");
				placeToPut = sc.nextInt();
				while(!checkIfPlaceFree(gameBoard, placeToPut)) {
					printBoard(gameBoard);
					System.out.print("Your chosen place is not valid... try again:");
					placeToPut = sc.nextInt();
				}
			}
			else {
				placeToPut = 1 + random.nextInt(10);
				while(!checkIfPlaceFree(gameBoard, placeToPut))
					placeToPut = 1 + random.nextInt(10);
			}
			changeBoard(gameBoard, placeToPut, currentPlayer);
			
			gameStatus = checkGameStatus(gameBoard);
			
			if(gameStatus == 0 && checkBoardFull(gameBoard)) {
				gameOver = true;
				printString = "Tied";
			}
			else if(gameStatus == 1) {
				gameOver = true;
				printString =  "X won";
			}	
			else if(gameStatus == 2) {
				gameOver = true;
				printString =  "O won";
			}
			//Switch player:
			if(!gameOver) {
				if(currentPlayer == 'X') 
					currentPlayer = 'O';
				else
					currentPlayer = 'X';
			}
			else
				printBoard(gameBoard);
		}
		
		return printString;
		
	}
	
	public static void main(String[] args) {
		
		char[][] gameBoard = new char[3][3];
		System.out.println("##########################################");
		System.out.println("############## Tic Tac Toe ###############");
		System.out.println("Enter 1 - You vs. computer [Easy]");
		System.out.println("Enter 2 - You vs. Nearby");
		System.out.println("Enter 3 - Exit");
		System.out.println("##########################################");

		int userInput = sc.nextInt();
		
		if(userInput == 1)
			System.out.println(runGameVsComputer(gameBoard));
		if(userInput == 2)
			System.out.println(runGame(gameBoard));
		sc.close();
		
	}
}