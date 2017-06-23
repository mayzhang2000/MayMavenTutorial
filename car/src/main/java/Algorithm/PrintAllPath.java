package Algorithm;

/**
 * Created by mayz985 on 11/1/16.
 */
public class PrintAllPath {

    public static void main(String[] args) {
        String[][] grid = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
                };
        printPath(grid, 0, 0, "");
    }

    public static void printPath(String[][] grid, int row, int column, String path) {
        //At the very end
        if (row >= grid.length-1  & column >= grid[0].length-1 ) {
            path = path + grid[row][column];
            System.out.println(path);
            return;
        };

        //At the last row
        if (row == grid.length-1) {
            path = path + grid[row][column];
            printPath(grid, row, column+1, path);

        }

        //At the last column
        if (column == grid[0].length) {
            path = path + grid[row][column];
            printPath(grid, row+1, column, path);
        }

        path = path + grid[row][column];
        printPath(grid, row+1, column, path);
        printPath(grid, row, column +1, path);
    }
}
