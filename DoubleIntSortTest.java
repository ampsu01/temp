import java.util.Arrays;

public class DoubleIntSortTest {

	public static void main(String[] args) {
		int[][] data = { {16, 13,  6,  7,  5, 11,  2, 33,  1,  3},
						 { 6, 13,  2, 17,  5,  4,  2,  3,  2,  8},
						 { 8, 17,  8, 71,  5,  9,  2,  3,  1, 11},
						 { 7,  1,  9,  6,  5,  4,  2,  8, 22,  3}};
		
		System.out.println("<<원본배열>>");
		printArray(data);
		System.out.println();
		
		sortByRow(data);
		System.out.println("<<행 단위 오름정렬>>");
		printArray(data);
		System.out.println();
		
		sortByCol(data);
		System.out.println("<<열 단위 오름정렬>>");
		printArray(data);
		System.out.println();
	}
	
	// 2차원 배열을 각 행 단위로 오름정렬 
	public static void sortByRow(int[][] data) {
		for(int row=0; row<data.length; row++) {
			Arrays.sort(data[row]);
		}
	}
	
	// 2차원 배열을 각 열 단위로 오름정렬 
	public static void sortByCol(int[][] data) {
		for(int col=0; col<data[0].length; col++) {
			int[] tmp = new int[data.length];
			
			for(int i=0; i<data.length; i++)
				tmp[i] = data[i][col];
			
			Arrays.sort(tmp);
				
			for(int i=0; i<data.length; i++)
				data[i][col] = tmp[i];
		}
	}
	
	public static void printArray(int[][] data) {
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
