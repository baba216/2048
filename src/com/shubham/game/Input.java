package com.shubham.game;

import java.util.Scanner;

public class Input {

  enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT
  }

  Direction captureArrow() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (input.charAt(0) == 'a' || input.charAt(0) == 'A') {
      return Direction.LEFT;
    } else if (input.charAt(0) == 'd' || input.charAt(0) == 'D') {
      return Direction.RIGHT;
    } else if (input.charAt(0) == 'w' || input.charAt(0) == 'W') {
      return Direction.UP;
    } else if (input.charAt(0) == 's' || input.charAt(0) == 'S') {
      return Direction.DOWN;
    } else {
      System.out.println("invalid selection");
      return captureArrow();
    }
  }
}
