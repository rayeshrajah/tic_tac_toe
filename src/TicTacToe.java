import java.util.Scanner;
public class TicTacToe {

	public static void main(String[] args) {
		String playerX = "";
		String playerO = "";
		int playerXWinCount = 0;
		int playerOWinCount = 0;
		int gameCount = 0;
		Scanner kb = new Scanner(System.in);
		String [][] array = new String [3][3];
		boolean PlayerWin = false;
		int counterTie = 0;
		boolean answer = true;
		
		while(answer) {
			fillArray(array);
			printArray(array);
			while(!PlayerWin) {
				if (!playerO.equals("O") && !(counterTie == 9)){
					getPosition(array, "X", kb);
					playerX = checkVertical(array, playerX);
					playerX = checkHorizontal(array, playerX);
					playerX = checkDiagonal(array, playerX);
					counterTie = checkBoardFull(array);
					printArray(array);	
				}
				
				if(!playerX.equals("X") && !(counterTie == 9)) {
					getPosition(array, "O", kb);
					playerO = checkVertical(array, playerO);
					playerO = checkHorizontal(array, playerO);
					playerO = checkDiagonal(array, playerO);
					counterTie = checkBoardFull(array);
					printArray(array);	
				}
			
				
				if(playerX.equals("X")) {
					PlayerWin = true;
					playerXWinCount++;
					gameCount++;
				}else if(playerO.equals("O")) {
					PlayerWin = true;
					playerOWinCount++;
					gameCount++;
				}else if(counterTie == 9) {
					PlayerWin = true;
					gameCount++;
				}
			}
			winnerBanner(playerX, playerO, counterTie);
			gameStats(gameCount, playerXWinCount, playerOWinCount);
			answer = userAnswer(kb);
			if(!answer) {
				gameEndStats(gameCount, playerXWinCount, playerOWinCount);
			}
			PlayerWin = false;
			counterTie = 0;
			playerX = "";
			playerO = "";
		}
		
	}
	
	public static void winnerBanner(String PlayerX, String PlayerO, int counter) {
		if(PlayerX.equals("X")) {
			System.out.println("--> We have a winner! Congratulations Player X <--");
		}else if(PlayerO.equals("O")) {
			System.out.println("--> We have a winner! Congratulations Player O <--");			
		}else if(counter == 9) {
			System.out.println("This game is a tie");
		}
	}
	
	public static void getPosition(String [][] array, String player, Scanner kb) {
		boolean positionValid = false;
		int position;
		
		while(!positionValid) {
			if(player.equals("X")) {
				System.out.print("PlayerX - Enter your position: ");
				position = kb.nextInt();
			}else {
				System.out.print("PlayerO - Enter your position: ");
				position = kb.nextInt();
			}
			
			switch(position) {
		 case 1:
			if(array[0][0].equals("X") || array[0][0].equals("O")) {
				System.out.println("That position is not available.");
			}else {
			   array[0][0] = player;
			   positionValid = true;
				
			}
			break;
		 case 2:
			 if(array[0][1].equals("X") || array[0][1].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[0][1] = player;
				   positionValid = true;
					
				}
			break;
		 case 3:
			 if(array[0][2].equals("X") || array[0][2].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[0][2] = player;
				   positionValid = true;
					
				}
			break;
		 case 4:
			 if(array[1][0].equals("X") || array[1][0].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[1][0] = player;
				   positionValid = true;
					
				}
			break;
		 case 5:
			 if(array[1][1].equals("X") || array[1][1].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[1][1] = player;
				   positionValid = true;
					
				}
			break;
		 case 6:
			 if(array[1][2].equals("X") || array[1][2].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[1][2] = player;
				   positionValid = true;
					
				}
			break;
		 case 7:
			 if(array[2][0].equals("X") || array[2][0].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[2][0] = player;
				   positionValid = true;
					
				}
			break;
		 case 8:
			 if(array[2][1].equals("X") || array[2][1].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[2][1] = player;
				   positionValid = true;
					
				}
			break;
		 case 9:
			 if(array[2][2].equals("X") || array[2][2].equals("O")) {
					System.out.println("That position is not available.");
				}else {
				   array[2][2] = player;
				   positionValid = true;
				}
			break;
		default:
			System.out.println("That is not a valid position – must be between 1 and 9 inclusive");
			break;
		}
	}
			
		
	}
	
	public static void fillArray(String [][] array) {
		int counter = 1;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				array[i][j] = Integer.toString(j + counter);
			}
			counter += array.length;
		}
	}
	
	public static void printArray(String [][] array) {
		System.out.println();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static String checkVertical(String[][] array, String whichPlayer) {
		if(array[0][0] == "X" && array[0][1] == "X" && array[0][2] == "X") {
			whichPlayer = "X";
		}
		else if(array[1][0] == "X" && array[1][1] == "X" && array[1][2] == "X") {
			whichPlayer = "X";
		}
		else if(array[2][0] == "X" && array[2][1] == "X" && array[2][2] == "X") {
			whichPlayer = "X";
		}
		else if(array[0][0] == "O" && array[0][1] == "O" && array[0][2] == "O") {
			whichPlayer = "O";
		}
		else if(array[1][0] == "O" && array[1][1] == "O" && array[1][2] == "O") {
			whichPlayer = "O";
		}
		else if(array[2][0] == "O" && array[2][1] == "O" && array[2][2] == "O") {
			whichPlayer = "O";
		}
		return whichPlayer;
	}
	
	public static String checkHorizontal(String[][] array, String whichPlayer) {
		if(array[0][0] == "X" && array[1][0] == "X" && array[2][0] == "X") {
			whichPlayer = "X";
		}
		else if(array[0][1] == "X" && array[1][1] == "X" && array[2][1] == "X") {
			whichPlayer = "X";
		}
		else if(array[0][2] == "X" && array[1][2] == "X" && array[2][2] == "X") {
			whichPlayer = "X";
		}
		else if(array[0][0] == "O" && array[1][0] == "O" && array[2][0] == "O") {
			whichPlayer = "O";
		}
		else if(array[0][1] == "O" && array[1][1] == "O" && array[2][1] == "O") {
			whichPlayer = "O";
		}
		else if(array[0][2] == "O" && array[1][2] == "O" && array[2][2] == "O") {
			whichPlayer = "O";
		}
		return whichPlayer;
		
	}
	
	public static String checkDiagonal(String[][] array, String whichPlayer){
		if(array[0][0] == "X" && array[1][1] == "X" && array[2][2] == "X") {
			whichPlayer = "X";
		}
		else if(array[0][2] == "X" && array[1][1] == "X" && array[2][0] == "X") {
			whichPlayer = "X";
		}
		else if(array[0][0] == "O" && array[1][1] == "O" && array[2][2] == "O") {
			whichPlayer = "X";
		}
		else if(array[0][2] == "O" && array[1][1] == "O" && array[2][0] == "O") {
			whichPlayer = "O";
		}
		return whichPlayer;
	}
	
	public static int checkBoardFull(String [][] array) {
		int counter = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[i][j].equals("X") || array[i][j].equals("O")) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static boolean userAnswer(Scanner kb) {
		System.out.print("Do you want to play again?(yes/no) ");
		String answer = kb.next();
		if(answer.equals("yes")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void gameStats(int gamesPlayed, int playerX, int playerY) {
		System.out.println("Games played to date " + gamesPlayed);
		System.out.println("Player X has won " + playerX + " game;" + " Player O has won " + playerY +  " games." );
	}
	
	public static void gameEndStats(int totalGames, int playerX, int playerY) {
		double playerXValue =  ((((double)playerX) / totalGames) * 100);
		double playerYValue =  ((((double)playerY) / totalGames) * 100);
		int finalPlayerXValue = (int) Math.round(playerXValue);
		int finalPlayerYValue = (int) Math.round(playerYValue);
		System.out.println("Total number of games played " + totalGames);
		System.out.println("Player X has won " + playerX + " " + "(" + finalPlayerXValue + "%)" + " game;" + " Player O has won " + playerY + " " + "(" +  finalPlayerYValue  + "%)" +  " games." );
	}
}
