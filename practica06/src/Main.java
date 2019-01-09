import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;

public class Main{
    public Grafica g = new Grafica();
    
    public void procesar(String name){
	Lector lector = new Lector(name);
	String[] vertices = lector.vertices;
	ArrayList<String[]> aristas = lector.aristas;
	for (int i=0;i<vertices.length;i++){
	    g.addVe(vertices[i],i+1);
	}
	for (int i = 0;i<aristas.size() ;i++ ) {
	    Arista a = new Arista(Integer.toString(i+1),Integer.parseInt(aristas.get(i)[2]),aristas.get(i)[0],aristas.get(i)[1]);
	    g.addAr(a);
	    g.putNe(aristas.get(i)[0],aristas.get(i)[1]);
	    g.putNe(aristas.get(i)[1],aristas.get(i)[0]);
	    g.putArs(aristas.get(i)[0],aristas.get(i)[1],a);
	    g.putArs(aristas.get(i)[1],aristas.get(i)[0],a);
	}
    }
    
    public Main(String name, String alg){
	procesar(name);
	switch(alg){
	case "kruskal":
	    Kruskal k = new Kruskal(g,name);
	    break;
	case "prim":
	    Prim p = new Prim(g,name);
	    break;
	default:
	    System.err.print("prim o kruskal");
	}
    }
    public static void main(String[] args) {
	if(args.length >= 2){
	    String archivo = args[0]; 
	    String algoritmo = args[1];
	    new Main(archivo,algoritmo);
    	}else{
	    System.err.println("Mala ejecucion, lea el Readme.");
	}
    }
}
