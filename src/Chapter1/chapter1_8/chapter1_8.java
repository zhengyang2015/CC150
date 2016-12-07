package Chapter1.chapter1_8;

public class chapter1_8 {
    public void zeroMatrix (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isRowZero = false;
        boolean isColumnZero = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isColumnZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isRowZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                notifyRow(matrix, i);
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                notifyColumn(matrix, j);
            }
        }

        if (isRowZero) {
            notifyRow(matrix, 0);
        }

        if (isColumnZero) {
            notifyColumn(matrix, 0);
        }
    }

    private void notifyColumn(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    private void notifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
}
