package hw3;

public class InPlaceIntHeapSort {
	public static void main(String[] args)
	{
		int[] x = { 2, 4, 3, 8, 5,132, 17, 18, 100 };
		heapSort(x);

		for (int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + " , ");
		}
	}

	public static <E extends Comparable<E>> void heapSort(int[] array)
	{
		// TODO Auto-generated method stub
		for (int i = 1; i < array.length; i++)
		{
			int currentIndex = i;
			while (currentIndex > 0)
			{
				int parentIndex = (currentIndex - 1) / 2;
				if (array[currentIndex] > array[parentIndex])
				{
					// swap current i with parent
					int temp = array[currentIndex];
					array[currentIndex] = array[parentIndex];
					array[parentIndex] = temp;
				} else
					break;

				currentIndex = parentIndex;
			}
		}
		for(int i = array.length - 1; i >= 1; i--)
		{
			//extract
			int removedInt = array[0];
			array[0] = array[i];
			array[i] = removedInt;
			int currentIndex = 0;
			while (currentIndex < i)
			{
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;

				if ( leftChildIndex >= i)
				{
					break;
				}
				int maxIndex = leftChildIndex;
				if(rightChildIndex < i)
				{
					if(array[maxIndex] < array[rightChildIndex] ){
						maxIndex = rightChildIndex;
					}
				}
				//compare current node to the max child
				if(array[currentIndex] < array[maxIndex] )
				{
					int temp = array[currentIndex];
					array[currentIndex] = array[maxIndex];
					array[maxIndex] = temp;
					currentIndex = maxIndex;
				}
				else
					break;
			}
		}
	}
}
