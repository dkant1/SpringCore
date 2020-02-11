package hello.beans;

import java.util.Arrays;
import java.util.Comparator;

import org.springframework.stereotype.Component;

@Component
public class Sorter {

	public void sort(final int[] arr) {

		int n = arr.length - 1;

		while (n >= 0) {

			for (int i = 0; i < n; i++) {

				if (arr[i] > arr[i + 1]) {

					int tmp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = tmp;

				}
				System.out.println(Arrays.toString(arr));
			}

			
			System.out.println("--------------------------");

			n--;

		}

	}

}
