import java.io.IOException;
import java.io.FileWriter;
import java.util.PriorityQueue; 
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.LinkedList;

public class Prim {

    public Hashtable<String,Boolean> b = new Hashtable<>();
    
    public Prim(Grafica g, String name){
	Grafica tree = new Grafica();
	
	
	int inf = Integer.MAX_VALUE;
	
	PriorityQueue<Vertice> q = new PriorityQueue<>(); 
	
	Hashtable<String,Integer> h = g.vertices;
	
	int cont = 0;
	for (Enumeration<String> e = h.keys(); e.hasMoreElements();){
	    String s = e.nextElement();
	    if(cont!=0){
		h.replace(s,inf);
	    }else{
		q.add(new Vertice(s,0));
		h.replace(s,0);
		cont++;
	    }
	} 
	
	while(q.size()!=0){
	    Vertice z = q.poll();
	    String x = z.nombre;
	    LinkedList<String> vec = g.adyacencias.get(x);
	    for(String y : vec){
		int pesoArista = g.relaciones.get(x).get(y).WEIGHT;
		if((!isVisited(y)) && (pesoArista < h.get(y)) ){
		    tree.addAr(g.relaciones.get(x).get(y));
		    visited(y);
		    q.add(new Vertice(y,pesoArista));
		    h.replace(y,pesoArista);
		}
	    }
	}
	
	
	try {
	    FileWriter fw = new FileWriter("c:\\outputPrim"+name);
	    LinkedList<Arista> ramas = tree.aristas;
	    for (Enumeration<String> e = h.keys(); e.hasMoreElements();){
		fw.write(e.nextElement()+",");
	    }fw.write("\n");
	    for(Arista rama : ramas){
		fw.write(rama.EXTREMO1+","+rama.EXTREMO2+","+rama.WEIGHT+"\n");
		fw.flush();
	    }
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    public void visited(String s){
	b.put(s,true);	
    }
    
    public boolean isVisited(String s){
	return b.containsKey(s);
    }
}
