package shortest_path;

import java.util.Scanner;

public class floyd {
    private static int N = 3;
    private static int map[][] = new int[4][4];
    private static int map2[][] = new int[4][4];
    private static int path[][] = new int[4][4];

    public static void main(String[] args) {

        //打印路径：
        Scanner input=new Scanner(System.in);
        //接受String类型
        int u= Integer.parseInt(input.next()) - 1;

        Scanner s=new Scanner(System.in);
        //输入数组的长度
        int v = Integer.parseInt(s.next()) - 1;
        int tmp = u;
        init();
        floyd();
        System.out.print((u + 1));
        while (tmp != v) {
            // 输出路径，之前记录用的方法：path[i][j] = path[i][k];
            System.out.print("-->"+ (path[tmp][v]+ 1));
            tmp = path[tmp][v];
        }
        System.out.println();
        System.out.println("cost: " + (map[u][v]));
    }

    /**
     * 初始化floyd矩阵
     *  0 2 6  4
     *  * 0 3  *
     *  7 * 0  1
     *  5 * 12 0
     */
    public static void init() {
        int i, j;
        for (i = 0; i <= N; i++) {
            for (j = 0; j <= N; j++) {
                map[i][j] = 9999999;
                path[i][j] = j;
            }
        }
        map[0][0] = 0;
        map[0][1] = 2;
        map[0][2] = 6;
        map[0][3] = 4;
//        map[1][0] = 999999;
        map[1][1] = 0;
        map[1][2] = 3;
//        map[1][3] = 999999;
        map[2][0] = 7;
//        map[2][1] = 999;
        map[2][2] = 0;
        map[2][3] = 1;
        map[3][0] = 5;
//        map[3][1] = 99999;
        map[3][2] = 12;
        map[3][3] = 0;
    }

    /**
     * 计算最短路径
     */
    public static void floyd() {
        int i, j, k;
        for (k = 0; k <= N; k++) {
            for (i = 0; i <= N; i++) {
                for (j = 0; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        // 倒序记录路径， 例如1 -> 2 ->3 ->4 ->5
                        // path15 = 2,path 25= 3,path 35=4，path 45=5
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }
}
