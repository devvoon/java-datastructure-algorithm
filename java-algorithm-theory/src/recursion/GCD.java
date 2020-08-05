package recursion;

public class GCD {

    public static void main(String[] args) {

        int p = 35;
        int q = 125;
        System.out.println("p : "  + p + " q : " + q);
        
        /* 최대공약수 구하기 */
        //recursion
        System.out.println("=====recusrion으로 최대공약수 구하기1=====");
        int iGcdRecrusion = gcdRecursion(p,q);
        System.out.println("GCD : " + iGcdRecrusion);
        
        System.out.println("=====recusrion으로 최대공약수 구하기2=====");
        int iGcdRecrusion2 = gcdRecursion2(p,q);
        System.out.println("GCD : " + iGcdRecrusion2);
        
        System.out.println("=====recusrion으로 최소공배수 구하기=====");
        int ilcmRecursion = lcmRecursion(p,q);
        System.out.println("LCD : " + ilcmRecursion);
        
        System.out.println("=====while 문으로 최대공약수 구하기=====");
        int iGcdFor = gcdWhile(p,q);
        System.out.println("GCD : " + iGcdFor);
        
    }

    /**
     * 최대 공약수 구하기 Recursion
     * @param m
     * @param n
     * @return
     */
    public static int gcdRecursion(int p, int q) {
        int temp = 0;
        prints(p,q);

        //유클리드 호제법 : 같은 수가 될 때까지 큰수/작은수  
        if (q==0) {
            return p;
        }else {
            return gcdRecursion(q, p%q);
        }
    }
    
    /**
     * 최대 공약수 구하기 Recursion2
     * @param p
     * @param q
     * @return
     */
    public static int gcdRecursion2(int p, int q) {
        int temp = 0;
        prints(p,q);
        //공통약수 중 가장 큰 수 -> 같은 수가 될 때까지 큰 수-작은 수를 뺌 
        if( p == q ) {
            temp = p;
        }else if( p > q ) {
            temp = gcdRecursion(p-q , q );
        }else if (p < q) {
            temp = gcdRecursion(p, q-p);
        }
        return temp;
    }
    
    /**
     * 최소 공배수 구하기 Recursion
     * @param p
     * @param q
     * @return
     */
    public static int lcmRecursion(int p, int q) {
        // 두 수의 곱을 최소공배수로 나눔  
        return (p*q)/gcdRecursion(p,q);
    }
    
    /**
     * 최대 공약수 구하기 while
     * @param p
     * @param q
     * @return
     */
    public static int gcdWhile(int p, int q) {
        int temp=0;
        prints(p,q);
        while( p != q ) {
            if( p > q ) {
                p = p-q ;
            }else if( q > p ) {
                q = q-p;
            }
        }
        return p;
    }

    /**
     * 계산하는 과정 출력
     * @param p
     * @param q
     */
    public static void prints(int p, int q) {
        System.out.println("("+ p +", " + q + ")");
    }
    
}
