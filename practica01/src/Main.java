import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.lang.IllegalArgumentException;

public class Main {

    public static Grafica creaGrafica(File archivo){
	Grafica grafica = new Grafica();
	try{
	    BufferedReader lector = new BufferedReader(new FileReader(archivo));
	    boolean primeraVez = true;
	    String linea = null;
	    String[] arreglo = null;
	    while((linea = lector.readLine()) != null){
		arreglo = linea.split(",");
		if(primeraVez){
		    for(int i = 0; i < arreglo.length; i++){
			grafica.addVertice(arreglo[i]);
		    }
		    primeraVez = false;
		}
		else{
		    if(arreglo.length != 2)
			throw new IllegalArgumentException();
		    grafica.conecta(arreglo[0], arreglo[1]);
		}
	    }
	}catch(IllegalArgumentException e){
	    System.out.println("");
	}catch(Exception e){
	    System.out.println(e.getMessage());
	} 
	return grafica;
    }
 
    
    
    public static void main(String[] args){
	File archivo = new File(args[0]);
	Grafica grafica = creaGrafica(archivo);
	LinkedList<Grafica.Vertice> independiente = grafica.getConjIndependiente();
	String conjunto = "";
	for(Grafica.Vertice e: independiente){
	    conjunto = conjunto + e.id + ", ";
	}
	System.out.println(conjunto.substring(0, conjunto.length() - 2));

    }
}
