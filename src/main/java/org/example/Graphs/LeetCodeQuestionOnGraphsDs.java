package org.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCodeQuestionOnGraphsDs {

    public static void main(String[] ars) {
        /*int arr[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int rotting = rottenOrangesProblem(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
*/
        char[][] a = {{'1','0'},{'0','1'}};

        System.out.println("total islands .."+findTotalNumberOfIslands(a));
    }


    public static int findTotalNumberOfIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1') {
                   count=count+  dfs(grid, i, j);

                }
            }
        }


        return count;
    }

    public static int dfs(char[][] grid, int i, int j) {

        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0' ){
            return 0;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return 1;

    }

    public static int rottenOrangesProblem(int[][] grid) {
        int totalMinutes = 0;
        int freshOranges = 0;
        int rottenOranges = 0;
        int rows = grid.length;
        Queue<OrangePosition> rottenOrages = new LinkedList<OrangePosition>();
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    rottenOrages.add(new OrangePosition(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        List<OrangePosition> movePositions = new ArrayList<>();
        movePositions.add(new OrangePosition(1, 0));
        movePositions.add(new OrangePosition(-1, 0));
        movePositions.add(new OrangePosition(0, 1));
        movePositions.add(new OrangePosition(0, -1));
        while (!rottenOrages.isEmpty() && freshOranges > 0) {
            OrangePosition currentPosition = rottenOrages.remove();
            for (OrangePosition op : movePositions) {
                currentPosition.row = currentPosition.row + op.row;
                currentPosition.column = currentPosition.column + op.column;
                if ((currentPosition.row < 0 || currentPosition.column < 0) ||
                        (currentPosition.row >= rows || currentPosition.column >= columns) ||
                        grid[currentPosition.row][currentPosition.column] == 2 || grid[currentPosition.row][currentPosition.column] == 0) {
                    continue;
                }

                grid[currentPosition.row][currentPosition.column] = 2;
                rottenOrages.add(new OrangePosition(currentPosition.row, currentPosition.column));
                freshOranges--;

            }

            totalMinutes++;

        }
        return freshOranges == 0 ? totalMinutes : -1;
    }


}


class OrangePosition {
    int row;
    int column;

    public OrangePosition(int r, int c) {
        row = r;
        column = c;
    }
}