package levelOne;

import java.util.ArrayList;
import java.util.List;

public class perfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 1000;
		int result = 0;

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i < n+1; i++) {
			
			List<Integer> temp = new ArrayList<>();

			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					temp.add(j);
//					System.out.println(j);
				}
			}

//			System.out.println();

			for (int k : temp) {
				result = result + k;
//				System.out.print(result);
			}

			if (result == i) {
				list.add(result);
			}
			
			result = 0;

		}

		for (int i : list) {
			System.out.println(i);
		}

	}

}
