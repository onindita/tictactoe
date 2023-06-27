package com.onindita.tictactoe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tictactoe {
	public static boolean over = false;
	public static String[][] board = new String[3][3];
	public static Scanner scanner = new Scanner(System.in);

	public static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		initializeBoard();

		int i = 0;

		while(i < 9){

			if(i % 2 == 0) playGame(1, "X");
			else playGame(2, "O");
			printBoard();

			if(!checkForWin().equals("None")){
				String winner = checkForWin();
				if(winner.equals("X")) System.out.println("\nPlayer 1 wins!");
				else System.out.println("\nPlayer 2 wins!");
				break;
			}

			i++;
		}

		if(i == 9) System.out.println("\nSorry, it's a tie!!");

	}

	private static void printBoard() {
		System.out.println();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 2) {
					System.out.println((board[i][j]));
				} else {
					System.out.print((board[i][j]) + " | ");
				}
			}
			if (i < 2) System.out.println("---------");
		}
	}

	public static void playGame(int player, String symbol){
		System.out.print("\nPlayer " + player + " (" + symbol + "): ");
		int input = scanner.nextInt();

		// checking for slots already been played
		while(set.contains(input)) {
			System.out.print("Oops.. that's taken. Enter another number: ");
			input = scanner.nextInt();
		}
		set.add(input);

		// updating array with appropriate symbol
		switch (input){
			case 1: board[0][0] = symbol; break;
			case 2: board[0][1] = symbol; break;
			case 3: board[0][2] = symbol; break;
			case 4: board[1][0] = symbol; break;
			case 5: board[1][1] = symbol; break;
			case 6: board[1][2] = symbol; break;
			case 7: board[2][0] = symbol; break;
			case 8: board[2][1] = symbol; break;
			case 9: board[2][2] = symbol; break;
			default:
				System.out.println("Wrong input!");
		}
	}

	public static String checkForWin() {

		// 3 horizontal
		if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
			return board[0][0];
		} else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
			return board[1][0];
		} else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
			return board[2][0];

		// 3 vertical
		} else if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) {
			return board[0][0];
		} else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) {
			return board[0][1];
		} else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) {
			return board[0][2];

		// 2 diagonal
		} else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
			return board[0][0];
		} else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
			return board[0][2];
		}
		return "None";
	}

	public static void initializeBoard() {

		int count = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = String.valueOf(count++);
			}
		}

		printBoard();
	}
}
