package array;

public class ArrayNExample {

    public static void main(String[] args) {
        
        System.out.println("===== 2차원 배열 생성 방법 (1) =====");
        int[][] a = new int[4][3]; //4*3
        a[0][0]=1;
        a[0][1]=2;
        a[3][2]=5;
        
        for (int i = 0; i < a.length; i++) { 
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("===== 2차원 배열 생성 방법 (2) (불규칙 가능) =====");
        int[][] b = new int[3][];  
        b[0] = new int[4]; //3*4
        b[1] = new int[5]; //3*5
        b[2] = new int[6]; //3*6

        for (int i = 0; i < b.length; i++) { 
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("===== 2차원 배열 생성 방법 (3) =====");
        int    [][]c = new int[][] {{1,2,3,4,5},{2,3,4,5,6},{6,7,8,9,0}}; //3*5
        
        for (int i = 0; i < c.length; i++) { 
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("===== 2차원 배열 생성 방법 (4) =====");
        int    [][]d = {{1,2,3,4,5},{2,3,4,5,6},{6,7,8,9,0}};  //3*5
        
        for (int i = 0; i < d.length; i++) { 
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("===== searching : array[i] - i번째 요소찾기(1) (d[2][3]) =====");
        System.out.println(c[1][3]);
        System.out.println(b[2][3]);
        // System.out.println(d[4][3]); // error : java.lang.ArrayIndexOutOfBoundsException:
        
        System.out.println("===== 배열의 크기 찾기 - array.length =====");
        System.out.println(c.length + " * " + c[0].length );
        
        System.out.println("===== Iteration(반복)으로 순차적으로 읽기 - for =====");
        
        for (int i = 0; i < c.length; i++) { 
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}
