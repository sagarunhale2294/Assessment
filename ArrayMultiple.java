import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayMultiple {

	public static void main(String[] args) {
		// int arr[] = {10,77,92,1,30,81,1,4,1,20,17,1,16,33};
		int arr[] = {10,3,8,9,2,6,9,4,2,6,7};
		// int X = 1, Z = 10;
		int X = 2, Z = 3;
		processArray(arr, X, Z);

	}

	private static void processArray(int[] arr, int x, int z) {
		int size = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<size; i++) {
			if(arr[i] == x) {
				int temp = arr[i];
				int k;
				for(k=i; k<arr.length-1; k++) {
					arr[k]=arr[k+1];
				}
				arr[k]= temp;
				size--;
			}
		}
		for(int i=0; i<size; i++) {
			if(arr[i]%z == 0) {
				map.put(i, arr[i]);
			}
		}
		System.out.println("Expected Out Put : Y="+ Arrays.toString(arr));
		System.out.print("Multiple of "+ z +" are :->");
		map.entrySet().stream().sorted((i1, i2)-> i1.getValue().compareTo(i2.getValue())).forEach(entry-> {
			System.out.print(String.format("index %d and value %d\n", entry.getKey(), entry.getValue()));
		});
	}

}
