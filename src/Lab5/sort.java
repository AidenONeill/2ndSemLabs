package Lab5;

public class sort {

	public static void mergeSort(int[] ar) 
	{
		if (ar.length >= 2) {
			int[] left = new int[ar.length / 2];
			int[] right = new int[ar.length-ar.length / 2];

			for (int i = 0; i < left.length; i++)
			{
				left[i] = ar[i]; 
			}
			for (int i = 0; i < right.length; i++)
			{
				right[i] = ar[i + ar.length / 2];
			}
			mergeSort(left);
			mergeSort(right);

			merge(ar, left, right);
		}
	}

	public static void merge(int[] workspace, int[] left, int[] right) 
	{
		int x = 0;
		int y = 0;
		for (int i = 0; i < workspace.length; i++)
		{
			if (y >= right.length || (x < left.length && left[x] >(right[y])))

			{
				workspace[i] = left[x];
				x++;
			} 
			else 
			{
				workspace[i] = right[y];
				y++;
			}
		}
	}
	public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if      (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j])  c[k] = a[i++];
            else                    c[k] = b[j++];
        }
        return c;
    }

    public static double[] mergesort2(double[] input) {
        int N = input.length;
        if (N <= 1) return input;
        double[] a = new double[N/2];
        double[] b = new double[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return merge(mergesort2(a), mergesort2(b));
    }
    public static void bubbleSort(double[] intArray) {
        
        
       
        int n = intArray.length;
        double temp = 0;
       
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                       
                        if(intArray[j-1] < intArray[j]){
                                //swap the elements!
                                temp = intArray[j-1];
                                intArray[j-1] = intArray[j];
                                intArray[j] = temp;
                        }
                       
                }
        }




}
}
