import java.io.*;
import java.util.*;

public class Ordenamiento{
    
    public int[] countingSort(int[] array) {
	
	int[] aux = new int[array.length];
	
	int min = array[0];
	int max = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i] < min) {
		min = array[i];
	    } else if (array[i] > max) {
		max = array[i];
	    }
	}

	int[] counts = new int[max - min + 1];
	
	for (int i = 0;  i < array.length; i++){
	    counts[array[i] - min]++;
	}
	
	counts[0]--;
	for (int i = 1; i < counts.length; i++){
	    counts[i] = counts[i] + counts[i-1];
	}
	
	
	for (int i = array.length - 1; i >= 0; i--){
	    aux[counts[array[i] - min]--] = array[i];
	}
	return aux;
    }
    

   
    static int getMax(int arr[], int n){
	int mx = arr[0];
	for (int i = 1; i < n; i++)
	    if (arr[i] > mx)
		mx = arr[i];
	return mx;
    }


    static int[] countSort(int arr[], int n, int exp){

	int output[] = new int[n]; 
	int i;
	int count[] = new int[10];
	Arrays.fill(count,0);

	for (i = 0; i < n; i++)
	    count[ (arr[i]/exp)%10 ]++;

	for (i = 1; i < 10; i++)
	    count[i] += count[i - 1];

	for (i = n - 1; i >= 0; i--){
		output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
		count[ (arr[i]/exp)%10 ]--;
	    }

	for (i = 0; i < n; i++){
	    arr[i] = output[i];
	}
	return output;
    }


    public int[] radixSort(int arr[], int n){

	int m = getMax(arr, n);
	int[] output = null;

	for (int exp = 1; m/exp > 0; exp *= 10)
        output = countSort(arr, n, exp);

	return output;
    }

    public int[] bucketSort(int[] arreglo){
	return arreglo;
    }





}
