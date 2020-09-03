package DP.Fibonacci;

public class Fibonacci {
    public static int count = 0;
    public static void main(String[] args) {
        int tempcount = 0;
        for(int i = 3 ; i< 50;++i){
            tempcount = count;
            System.out.println(violentFib(i));
            System.out.println("count:" + count);
            System.out.println("tempcount:" + tempcount);
            // 黄金比例
            System.out.println("minus:" + (count - tempcount));
            if(tempcount != 0){
                System.out.println("count/tempcount:" + ((float)count / (float)tempcount));
                System.out.println("count/tempcount:" + ((float)tempcount / (float)count));
            }

            System.out.println("*****************");
        }
    }
    public static int violentFib(int N){
        count++;
        if (N == 1 || N == 2) {
            return 1;
        }
        return violentFib(N - 1) + violentFib(N - 2);
    }
}

