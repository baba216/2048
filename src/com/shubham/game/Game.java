package com.shubham.game;

import java.util.Random;

public class Game {

  private static final int[][] board = new int[4][4];
  private static final int row = 4;
  private static final int col = 4;
  private static int moves = 0;
  private static final Helper HELPER = new Helper(board, row, col);

  public static void main(String[] args) {
    // (i)  put random 2 numbers anywhere
    // (ii) when player go up add all the same number in a column
    // (iii)when player move side ways add all the same number in a row
    // in either of step 2 and 3, we drop a new number at random position
    // (iv) when after movement, matrix remains same then its lose
    initBoard();
    Input input = new Input();
    while (true) {
      displayBoard();
      Input.Direction direction = input.captureArrow();
      move(direction);
      moves++;
      if (checkLose()) {
        System.out.println("You Lose");
        break;
      }
      assignNumberAtRandom();
    }

  }

  private static void assignNumberAtRandom() {
    int[] emptyCoordinate = getRandomEmptyCoordinate();
    if (moves % 4 == 0) {
      board[emptyCoordinate[0]][emptyCoordinate[1]] = 4;
    } else {
      board[emptyCoordinate[0]][emptyCoordinate[1]] = 2;
    }

  }

  private static boolean checkLose() {
    return false;
  }

  private static void move(Input.Direction direction) {
    switch (direction) {
      case UP: {
        HELPER.moveUp();
        break;
      }
      case DOWN: {
        HELPER.moveDown();
        break;
      }
      case LEFT: {
        HELPER.moveLeft();
        break;
      }
      case RIGHT: {
        HELPER.moveRight();
        break;
      }
      default: {
        System.out.println("Invalid Choice");
      }
    }
  }

  private static void initBoard() {
    int[] emptyCoordinate = getRandomEmptyCoordinate();
    board[emptyCoordinate[0]][emptyCoordinate[1]] = 2;
    int[] emptyCoordinate1 = getRandomEmptyCoordinate();
    board[emptyCoordinate1[0]][emptyCoordinate1[1]] = 2;
  }

  private static void displayBoard() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(" " + board[i][j]);
      }
      System.out.println();
    }
  }

  // prone to stack over flow
  public static int[] getRandomEmptyCoordinate() {
    Random random = new Random();
    int x = random.nextInt(3);
    int y = random.nextInt(3);
    if (board[x][y] != 0) {
      return getRandomEmptyCoordinate();
    }
    int[] emptyCoordinate = new int[2];
    emptyCoordinate[0] = x;
    emptyCoordinate[1] = y;
    return emptyCoordinate;
  }
}
