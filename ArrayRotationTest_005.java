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
		
		// 90 �̻� ȸ�� ��
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

	//Ȯ�ο�
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
 
 ��������

NxN ������ �迭�� ���� ������ ä���� �ִ�. 
�� �迭�� �ð� �������� 90�� ȸ���ϸ� ���ο� ���� ��ġ�� ���� �� �ִ�. 
���� �迭�� ���������� 90�� ȸ���Ͽ� ����� �迭�� ���Ͽ� ����� ��� ���α׷��� �ۼ��Ͻÿ�.
 

�Է�
N ũ�Ⱑ 100�� ���� �ʴ� 2���� �迭�� ���� ������ ä���� �����ȴ�.


���
�Է����� �־��� 2���� �迭�� ������(�ð� ����)���� ȸ���Ͽ� ����� �迭�� 
���� �迭�� ���� �ε��� ���� ���Ͽ� 2���� �迭�� �����.


ù��°�Է¿�
5	 4	 7	 
1	 5	 4	 
7	 6	 8	 

���
12	 5	 12	 
7	 10	 8	 
15	 10	 15


�ι�° �Է�
2	 7	 11	 9	 
13	 8	 12	 3	 
31	 18	 5	 6	 
7	 17	 14	 7


�� �迭 ���� ���
9	 38	 24	 11	 
30	 26	 20	 10	 
45	 23	 17	 17	 
14	 23	 17	 16
*/