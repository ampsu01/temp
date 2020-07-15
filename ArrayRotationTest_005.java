package exam05.lgcns.com;

class Solution{
	public int[][] solution(int n, int[][] A, int cnt) {
		int[][] result = new int[n][n];
		int[][] rotate = new int[n][n];
		
		//TODO
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotate[i][j] = A[n - 1 - j][i];
				result[i][j] = rotate[i][j] + A[i][j];
			}
		}
		
		// 90 이상 회전 시
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = A[i][j];
			}
		}
		for (int c = 0; c < cnt; c++) {
			
			int[][] temp2 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp2[i][j] = temp[i][j];
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j] = temp2[n - 1 - j][i];
				}
			}
		}

		return temp;
	}
	
}
public class ArrayRotationTest_005 {
	
	
	public static void main(String[] args) {
		  
        int[][] A = { { 5, 4, 7}, 
					  { 1, 5, 4}, 
					  { 7, 6, 8} };
        
		
        /*
        int[][] A = { { 2,7,11,9}, 
					  { 13,8,12,3}, 
					  { 31,18,5,6},
					  {7,17,14,7}};		        
        */
        Solution sol = new Solution();
        int[][] res = sol.solution(A.length, A, 2);
        printAry(res);

    }    

	//확인용
    public static void printAry(int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                System.out.print(array[i][j] + "\t ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


/*
 
 문제설명

NxN 이차원 배열에 양의 정수로 채워져 있다. 
이 배열을 시계 방향으로 90도 회전하면 새로운 값의 배치를 얻을 수 있다. 
원본 배열과 오른쪽으로 90도 회전하여 얻어진 배열을 더하여 결과를 얻는 프로그램을 작성하시오.
 

입력
N 크기가 100을 넘지 않는 2차원 배열에 양의 정수가 채워져 제공된다.


출력
입력으로 주어진 2차원 배열을 오른쪽(시계 방향)으로 회전하여 얻어진 배열과 
원본 배열의 같은 인덱스 값을 더하여 2차원 배열을 만든다.


첫번째입력예
5	 4	 7	 
1	 5	 4	 
7	 6	 8	 

결과
12	 5	 12	 
7	 10	 8	 
15	 10	 15


두번째 입력
2	 7	 11	 9	 
13	 8	 12	 3	 
31	 18	 5	 6	 
7	 17	 14	 7


두 배열 더한 결과
9	 38	 24	 11	 
30	 26	 20	 10	 
45	 23	 17	 17	 
14	 23	 17	 16
*/