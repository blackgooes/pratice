import java.util.Collections;

public class matrixTraversal {
    public static void main(String[] args) {
        int m = 5;
        int n = 4;

        int[][] dp = new int[m][n];
        int[][] copydp = new int[m][n];
        // 赋值
        for (int i = 0; i < m; i++){
            System.out.println();
            for (int j = 0; j < n; j++){
                dp[i][j] = j;
                copydp[i][j] = 0;
                System.out.print(i +"" +j + ":" +dp[i][j]  +" | ");
            }
        }
        System.out.println();
        System.out.println("***********************");
        // 斜遍历
        for (int a = 1; a <= n; a++) {
            for (int i = 0; i <= n - a; i++) {
                int j = a + i - 1;
                copydp[i][j] = dp[i][j];
                System.out.print(i +"" +j + ":" +dp[i][j] +" | ");
            }
            System.out.println();
        }


        for (int i = 0; i < m; i++){
            System.out.println();
            for (int j = 0; j < n; j++){
                System.out.print(i +"" +j + ":" +copydp[i][j]  +" | ");
            }
        }
        printMatrix(copydp,m,n);
    }
    public static void printMatrix(int[][] matrix, int m, int n){
        for (int i = 0; i < m; i++){
            System.out.println();
            for (int j = 0; j < n; j++){
                printEquidistanceValue(matrix, i, j, 2);
//                System.out.print(i +"" +j + ":" +matrix[i][j]  +" | ");
            }
        }
    }

    public static void printEquidistanceValue(int[][] matrix, int i, int j,int length){
        int fillLength;
        if(matrix[i][j] < length * 10){
            int numlength = (int) Math.log10(matrix[i][j])+1;
            fillLength = length - numlength;
        }
        if(matrix[i][j] > length * 10){
            throw new RuntimeException("over max length!");
        }
        String fillChar = "0";
        String fillStr = String.join("", Collections.nCopies(length, fillChar));

        System.out.print(i +"" +j + ":" + fillStr + matrix[i][j]  +" | ");
    }
}
