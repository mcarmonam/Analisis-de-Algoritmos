import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Enumeration;

public class Kruskal{
    
    public Kruskal(Grafica g,String name){
	Grafica tree = new Grafica();
	
	Hashtable<String,Integer> h = g.vertices;
	LinkedList<Arista> l = g.aristas;
	
	Collections.sort(l);
	DisjSets d = new DisjSets(h.size());
	
	for(Arista e : l){
	    int u = h.get(e.EXTREMO1);
	    int v = h.get(e.EXTREMO2);
	    int re1 = d.getRe(u);
	    int re2 = d.getRe(v);
	    if(re1!=re2){
		tree.addAr(e);
		d.union(u,v,re1,re2);
	    }
	}
	
	try {
	    FileWriter fw = new FileWriter("c:\\OutputKruskal"+name);
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
}
