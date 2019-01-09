import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main{

    public static void main(String[] args) {

	String archivo = args[0];
	String opcion = args[1];
	String linea;
	String[] fake = null;
	int[] real = null;
	Ordenamiento ob = new Ordenamiento();

	try {

	    FileReader fi = new FileReader(archivo);
	    BufferedReader li = new BufferedReader(fi);

	    while((linea = li.readLine()) != null){
		fake = linea.split(" ");
	    }

	    real = new int[fake.length];
	    for(int i = 0; i < fake.length; i++){
		real[i] = Integer.parseInt(fake[i]);
	    }

	    int n = real.length;

	    switch(opcion){
	    case "counting":
		System.out.println(Arrays.toString(ob.countingSort(real)));
		break;
		
	    case "radix":
		System.out.println(Arrays.toString(ob.radixSort(real, n)));
		break;
		
	    case "bucket":
		System.out.println(Arrays.toString(ob.bucketSort(real)));
		break;
	    }
	} catch(IOException e) {
	    
	}
    }
}
