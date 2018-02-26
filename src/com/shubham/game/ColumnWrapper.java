package com.shubham.game;

public class ColumnWrapper {

  private final int[][] original2DArray;

  private final int column;

  private int[] wrapperCol;

  public ColumnWrapper(int[][] original2DArray, int column) {
    this.original2DArray = original2DArray;
    this.column = column;
    setWrapperColumn();
  }

  private void setWrapperColumn() {
    wrapperCol = new int[original2DArray.length];
    for (int i = 0; i < original2DArray.length; i++) {
      wrapperCol[i] = original2DArray[i][column];
    }
  }

  public void mapColumnToOriginalMatrix() {
    for (int i = 0; i < wrapperCol.length; i++) {
      original2DArray[i][column] = wrapperCol[i];
    }
  }

  public int[] getWrapperCol() {
    return wrapperCol;
  }
}
