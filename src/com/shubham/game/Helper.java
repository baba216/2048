package com.shubham.game;

public class Helper {

  private final int[][] board;

  private final int row;

  private final int col;

  public Helper(int[][] board, int row, int col) {
    this.board = board;
    this.row = row;
    this.col = col;
  }

  public void moveLeft() {
    for (int i = 0; i < row; i++) {
      groupLeft(board[i]);
    }
  }

  private static void groupLeft(int[] input) {
    int i = 0;
    int anchor = 0;
    while (i < input.length) {
      while (i < input.length && input[i] == 0) {
        i++;
      }
      if (i < input.length && anchor != i && input[i] != 0) {
        if(input[anchor] == input[i]){
          input[anchor] += input[i];
          anchor++;
        }else if(input[anchor] == 0){
          input[anchor] = input[i];
        }else if(input[anchor] != input[i]){
          anchor++;
          input[anchor] = input[i];
        }
        input[i] = 0;
      }
      i++;
    }
  }

  public void moveRight() {
    for (int i = 0; i < row; i++) {
      groupRight(board[i]);
    }
  }

  private static void groupRight(int[] input) {
    int anchor = Integer.MIN_VALUE;
    int lastMergedElem = Integer.MIN_VALUE;
    for (int j = 0; j < input.length; j++) {
      if (input[j] != 0 && anchor == Integer.MIN_VALUE) {
        anchor = j;
        continue;
      }
      if (input[j] != 0 && anchor != Integer.MIN_VALUE) {
        if (input[j] == input[anchor]) {
          input[j] += input[anchor];
          input[anchor] = 0;
          anchor = Integer.MIN_VALUE;
          if (lastMergedElem != Integer.MIN_VALUE) {
            input[j - 1] = input[lastMergedElem];
            input[lastMergedElem] = 0;
          }
          lastMergedElem = j;
        } else {
          anchor = j;
        }
      } else if (input[j] == 0 && anchor != Integer.MIN_VALUE) {
        input[j] = input[anchor];
        input[anchor] = 0;
        anchor = j;
      }
    }
    if (lastMergedElem != Integer.MIN_VALUE && input[input.length - 1] == 0) {
      input[input.length - 1] = input[lastMergedElem];
      input[lastMergedElem] = 0;
    }
  }
  //might have bug
  public void moveDown() {
    for (int i = 0; i < col; i++) {
      ColumnWrapper columnWrapper = new ColumnWrapper(board, i);
      groupRight(columnWrapper.getWrapperCol());
      columnWrapper.mapColumnToOriginalMatrix();
    }
  }

  public  void moveUp() {
    for (int i = 0; i < col; i++) {
      ColumnWrapper columnWrapper = new ColumnWrapper(board, i);
      groupLeft(columnWrapper.getWrapperCol());
      columnWrapper.mapColumnToOriginalMatrix();
    }
  }
}
