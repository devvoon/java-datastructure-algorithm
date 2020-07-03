package array;

public class ArrayExample {

	public static void main(String[] args) {

		int[] numbers1 = new int[4];
		String[] strings = new String[4];
		
		System.out.println("===== insertion / deletion :  array[i] = data  =====");
		
		numbers1[0] = 10;
		numbers1[1] = 20;
		numbers1[2] = 30;
	
		strings[0] = "hello";
		strings[1] = "world";
		strings[2] = "java";
		
		int[] numbers2 = {10, 20, 30, 40}; //배열생성방법 
		int[] numbers3 = new int[] {10, 20, 30, 40}; //배열 생성방법 
		
		System.out.println("===== search : i번째 요소찾기 array[i]   =====");
		System.out.println(numbers1[0]);
		
		System.out.println("===== search (2) : i번째 요소찾기(2) - 값이 없는 경우 =====");
		System.out.println(numbers1[3] + " : int는 0출력 ");
		System.out.println(strings[3] + " : string은 null 출력");
		
		System.out.println("===== 배열의 크기 찾기 - array.length =====");
		System.out.println(numbers1.length);
		
		System.out.println("===== access: 순차적으로 읽기(1) - while =====");		
		int i = 0;
		while(numbers1.length>i) {
			System.out.println(numbers1[i]);
			i++;
		}
		
		System.out.println("===== access : 순차적으로 읽기(2) - for =====");
		for (int j = 0; numbers1.length > j; j++) {
			System.out.println(numbers1[j]);
		}
		
		
	}

}
