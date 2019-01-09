import java.util.Hashtable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Grafica{
    public Hashtable<String,Integer> vertices;
    public Hashtable<String,LinkedList<String>> adyacencias;
    public LinkedList<Arista> aristas;
    public Hashtable<String,Hashtable<String,Arista>> relaciones;
    
    public Grafica(){
	vertices = new Hashtable<>();
	aristas = new LinkedList<>();
	adyacencias = new Hashtable<>();
	relaciones = new Hashtable<>();
    }
   
    public void addVe(String s,int i){
	vertices.put(s,i);
    }
   
    public void addAr(Arista a){
	aristas.add(a);
    }
   
    public void putNe(String v1,String v2){
	if(adyacencias.containsKey(v1)){
	    adyacencias.get(v1).add(v2);
	}else{
	    LinkedList<String> l = new LinkedList<>();
	    l.add(v2);
	    adyacencias.put(v1,l);
	}
    }
    
    public void putArs(String v1,String v2,Arista a){
	if(relaciones.containsKey(v1)){
	    Hashtable<String,Arista> u = relaciones.get(v1);
	    u.put(v2,a);
	}else{
	    Hashtable<String,Arista> h = new Hashtable<>();
	    h.put(v2,a);
	    relaciones.put(v1,h);
	}
    }
}
