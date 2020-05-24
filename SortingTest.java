import java.io.*;
import java.util.*;

public class SortingTest
{
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try
		{
			boolean isRandom = false;	// 입력받은 배열이 난수인가 아닌가?
			int[] value;	// 입력 받을 숫자들의 배열
			String nums = br.readLine();	// 첫 줄을 입력 받음
			if (nums.charAt(0) == 'r')
			{
				// 난수일 경우
				isRandom = true;	// 난수임을 표시

				String[] nums_arg = nums.split(" ");

				int numsize = Integer.parseInt(nums_arg[1]);	// 총 갯수
				int rminimum = Integer.parseInt(nums_arg[2]);	// 최소값
				int rmaximum = Integer.parseInt(nums_arg[3]);	// 최대값

				Random rand = new Random();	// 난수 인스턴스를 생성한다.

				value = new int[numsize];	// 배열을 생성한다.
				for (int i = 0; i < value.length; i++)	// 각각의 배열에 난수를 생성하여 대입
					value[i] = rand.nextInt(rmaximum - rminimum + 1) + rminimum;
			}
			else
			{
				// 난수가 아닐 경우
				int numsize = Integer.parseInt(nums);

				value = new int[numsize];	// 배열을 생성한다.
				for (int i = 0; i < value.length; i++)	// 한줄씩 입력받아 배열원소로 대입
					value[i] = Integer.parseInt(br.readLine());
			}

			// 숫자 입력을 다 받았으므로 정렬 방법을 받아 그에 맞는 정렬을 수행한다.
			while (true)
			{
				int[] newvalue = (int[])value.clone();	// 원래 값의 보호를 위해 복사본을 생성한다.

				String command = br.readLine();

				long t = System.currentTimeMillis();
				switch (command.charAt(0))
				{
					case 'B':	// Bubble Sort
						newvalue = DoBubbleSort(newvalue);
						break;
					case 'I':	// Insertion Sort
						newvalue = DoInsertionSort(newvalue);
						break;
					case 'H':	// Heap Sort
						newvalue = DoHeapSort(newvalue);
						break;
					case 'M':	// Merge Sort
						newvalue = DoMergeSort(newvalue);
						break;
					case 'Q':	// Quick Sort
						newvalue = DoQuickSort(newvalue);
						break;
					case 'R':	// Radix Sort
						newvalue = DoRadixSort(newvalue);
						break;
					case 'X':
						return;	// 프로그램을 종료한다.
					default:
						throw new IOException("잘못된 정렬 방법을 입력했습니다.");
				}
				if (isRandom)
				{
					// 난수일 경우 수행시간을 출력한다.
					System.out.println((System.currentTimeMillis() - t) + " ms");
				}
				else
				{
					// 난수가 아닐 경우 정렬된 결과값을 출력한다.
					for (int i = 0; i < newvalue.length; i++)
					{
						System.out.println(newvalue[i]);
					}
				}

			}
		}
		catch (IOException e)
		{
			System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] DoBubbleSort(int[] value)
	{
		// TODO : Bubble Sort 를 구현하라.
		// value는 정렬안된 숫자들의 배열이며 value.length 는 배열의 크기가 된다.
		// 결과로 정렬된 배열은 리턴해 주어야 하며, 두가지 방법이 있으므로 잘 생각해서 사용할것.
		// 주어진 value 배열에서 안의 값만을 바꾸고 value를 다시 리턴하거나
		// 같은 크기의 새로운 배열을 만들어 그 배열을 리턴할 수도 있다.
		int length = value.length;
		for (int i = 0; i < length; i++){
			for (int j = 0; j < length - i - 1; j++){
				if (value[j] > value[j + 1]){
					int temp = value[j + 1];
					value[j + 1] = value[j];
					value[j] = temp;
				}
			}
		}
		return (value);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] DoInsertionSort(int[] value)
	{
		// TODO : Insertion Sort 를 구현하라.
		int length = value.length;
		for (int i = 1 ; i < length; i++){
			int temp = value[i];
			int j;
			for (j = i - 1; j > - 1; j--){
				if (temp < value[j]){
					value[j + 1] = value[j];
				} else {
					break;
				}
			}
			value[j + 1] = temp;
		}
		return (value);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] DoHeapSort(int[] value)
	{
		// TODO : Heap Sort 를 구현하라.
		int length = value.length;
		for (int i = length / 2 - 1; i >= 0; i--){
			percolateDown(value, i, length);
		}

		for (int j = length - 1; j >= 1; j--){
			int temp = value[0];
			value[0] = value[j];
			value[j] = temp;
			percolateDown(value, 0, j);
		}
		return (value);
	}

	private static void percolateDown(int[] sequence, int i, int n){
		int child = i * 2 + 1;
		int right_child = i * 2 + 2;
		
		if (child <= n - 1){
			if (right_child <= n - 1 && sequence[child] < sequence[right_child]){
				child = right_child;
			}
			if (sequence[i] < sequence[child]){
				int temp2 = sequence[i];
				sequence[i] = sequence[child];
				sequence[child] = temp2;
				percolateDown(sequence, child, n);
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] DoMergeSort(int[] value)
	{
		// TODO : Merge Sort 를 구현하라.
		int length = value.length;
		if (length == 1){
			return (value);
		} else {
			mergeSort(value, 0, length - 1);
		}
		return (value);
	}
	 
	private static void mergeSort(int[] sequence, int low, int high){
		if (low < high){
			int mid = (high + low) / 2;
			mergeSort(sequence, low, mid);
			mergeSort(sequence, mid + 1, high);
			merge(sequence, low, mid, high);
		}
	}

	private static void merge(int[] sequence, int low, int mid, int high){
		int length = sequence.length;
		int[] temp = new int[length];
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high){
			if (sequence[i] <= sequence[j]){
				temp[k++] = sequence[i++];
			} else {
				temp[k++] = sequence[j++];
			}
		}

		while (i <= mid){
			temp[k++] = sequence[i++];
		}

		while (j <= high){
			temp[k++] = sequence[j++];
		}

		for (int l = low; l <= high; l++){
			sequence[l] = temp[l];
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] DoQuickSort(int[] value)
	{
		// TODO : Quick Sort 를 구현하라.
		int length = value.length;
		if (length == 1){
			return (value);
		} else {
			quickSort(value, 0, length - 1);
		}
		return (value);
	}

	private static void quickSort(int[] sequence, int low, int high){
		if (low < high){
			int p = partition(sequence, low, high);

			quickSort(sequence, low, p - 1);
			quickSort(sequence, p + 1, high);
		}
	}

	private static int partition(int[] sequence, int low, int high){
		int pivot = sequence[high];
		int i = low - 1;
		int j;

		for (j = low; j <= high - 1; j++){
			if (sequence[j] <= pivot){
				i++;
				int temp = sequence[j];
				sequence[j] = sequence[i];
				sequence[i] = temp;
			}
		}
		int temp2 = sequence[i + 1];
		sequence[i + 1] = sequence[high];
		sequence[high] = temp2;
		return i + 1;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] DoRadixSort(int[] value)
	{
		// TODO : Radix Sort 를 구현하라.
		int length = value.length;
		int max_value;
		int min_value;
		if (length == 0){
			return value;
		}

		int count_negatives = 0;
		max_value = value[0];
		min_value = value[0];
		for (int i = 0; i < length; i++){
			if (value[i] > 0 && value[i] > max_value){
				max_value = value[i];
			}
			if (value[i] < 0 && value[i] < min_value){
				min_value = value[i];
			}
			if (value[i] < 0){
				count_negatives = count_negatives + 1;
			}
		}

		int[] negatives = new int[count_negatives];
		int[] positives = new int[length - count_negatives];

		int num_negative = 0;
		int num_positive = 0;
		for (int i = 0; i < length; i++){
			if (value[i] < 0){
				negatives[num_negative] = value[i] * (-1);
				num_negative = num_negative + 1;
			} else {
				positives[num_positive] = value[i];
				num_positive = num_positive + 1;
			}
		}

		for (int exponent = 1; max_value / exponent > 0; exponent *= 10){
			stableSort(positives, exponent, length - count_negatives);
		}
		for (int exponent = 1; (min_value * (-1)) / exponent > 0; exponent *= 10){
			stableSort(negatives, exponent, count_negatives);
		}

		for (int i = count_negatives - 1; i >= 0; i--){
			value[count_negatives - i - 1] = negatives[i] * (-1);
		}
		for (int i = count_negatives; i < length; i++){
			value[i] = positives[i - count_negatives];
		}


		return (value);
	}

	private static void stableSort(int[] sequence, int exponent, int length){
		int[] count = new int[10];
		int remainder;
		int[] temp = new int[length];

		for (int i = 0; i < length; i++){
			temp[i] = 0;
		}

		for (int i = 0; i < length; i++){
			remainder = (sequence[i] / exponent) % 10;
			if (remainder < 0){
				remainder *= -1;
			}
			count[remainder] = count[remainder] + 1;
		}

		for (int i = 1; i < 10; i++){
			count[i] = count[i] + count[i - 1];
		}

		for (int i = length - 1; i >= 0; i--){
			remainder = (sequence[i] / exponent) % 10;
			if (remainder < 0){
				remainder *= -1;
			}
			temp[count[remainder] - 1] = sequence[i];
			count[remainder] = count[remainder] - 1;
		}

		for (int i = 0; i < length; i++){
			sequence[i] = temp[i];
		}
	}
}
