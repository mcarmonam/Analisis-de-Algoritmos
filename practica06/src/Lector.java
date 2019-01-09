import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Lector{
    public String[] vertices;
    public ArrayList<String[]> aristas; 
    
    public Lector(String filename){
	
	aristas = new ArrayList<>(); 
	leerArchivo(filename);
    }
    
    public void leerArchivo(String filename){
	
	try(BufferedReader br = new BufferedReader(new FileReader(filename))){
	    String line;
	    for(int i = -1; (line = br.readLine()) != null; i++){
		
		if(i == -1){
		    
		vertices = line.trim().split("\\s*,\\s*"); 
		}else{
		    String[] lineaAristas = line.trim().split("\\s*,\\s*");
		    aristas.add(lineaAristas);
		}
	    }
	}catch(Exception e){
	    System.err.println(e);
	}
	
    }
}
