import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Grafica{
    
    protected class Vertice{
        public LinkedList<Vertice> vecinos;
	private String id;
	private boolean visitado;
	
	public Vertice(String name){
	    this.vecinos = new LinkedList<>();
	    this.id = name;
	    this.visitado = false;
	}

	public void addVecino(Vertice neighbour){
	    vecinos.addLast(neighbour);
	}

	public String getId(){
	    return id;
	}
	    
	public void visita(){
	    this.visitado = true;
	}

	public void reset(){
	    this.visitado = false;
	}
	
	public boolean isVisited(){
	    return visitado;
	}

    }

    private LinkedList<Vertice> vertices;
    private int aristas;

    public Grafica(){
	this.vertices = new LinkedList<>();
	this.aristas = 0;
    }
    
    public void addVertice(String id){
	if(!this.contiene(id)){
	    Vertice nuevo = new Vertice(id);
	    vertices.add(nuevo);
	}
    }

    public boolean contiene(String ident){
	for(Vertice e: vertices){
	    if(ident.compareTo(e.id) == 0)
		return true;
	}
	return false;
    }

    public Vertice getVertice(String ident){
	for(Vertice e: vertices){
	    if(ident.compareTo(e.id) == 0)
		return e;
	}
	throw new NoSuchElementException();
    }

    public void conecta(String idA, String idB){
	if(!contiene(idA))
	    System.out.println(idA);
	else if(!contiene(idB))
	    System.out.println(idB);
	else{
	    Vertice A = this.getVertice(idA);
	    Vertice B = this.getVertice(idB);
	    A.addVecino(B);
	    B.addVecino(A);
	    aristas++;
	}	    
    }

    public boolean sonVecinos(String idA, String idB){
	if(!contiene(idA) || !contiene(idB))
	    throw new NoSuchElementException();
	return getVertice(idA).vecinos.contains(getVertice(idB));
    }

    
    public Grafica DFS(String IDroot){
	LinkedList<Vertice> pila = new LinkedList<>();
	Grafica arbolGenerador = new Grafica();
	Vertice vert = getVertice(IDroot);
	pila.addFirst(vert);
	vert.visita();
	arbolGenerador.addVertice(vert.getId());
	while(!pila.isEmpty()){
	    vert = pila.remove();
	    for(Vertice v: vert.vecinos){
		if(!v.isVisited()){
		    pila.addFirst(v);
		    v.visita();
		    arbolGenerador.addVertice(v.getId());
		    arbolGenerador.conecta(vert.getId(), v.getId());
		}
	    }
	}
	resetGrafica();
	return arbolGenerador;
    }
    
    public Grafica BFS(String IDroot){
	LinkedList<Vertice> cola = new LinkedList<>();
	Grafica arbolGenerador = new Grafica();
	Vertice vert = getVertice(IDroot);
	cola.addLast(vert);
	vert.visita();
	arbolGenerador.addVertice(vert.getId());
	while(!cola.isEmpty()){
	    vert = cola.remove();
	    for(Vertice v: vert.vecinos){
		if(!v.isVisited()){
		    cola.addLast(v);
		    v.visita();
		    arbolGenerador.addVertice(v.getId());
		    arbolGenerador.conecta(vert.getId(), v.getId());
		}
	    }
	}
	resetGrafica();
	return arbolGenerador;
    }

    public void printGrafica(){
	String vrtcs = "";
	for(Vertice v: vertices){
	    vrtcs = vrtcs + v.getId() + ", ";
	}
	vrtcs = vrtcs.substring(0, vrtcs.length() - 2);
	for(Vertice v: vertices){
	    for(Vertice u: v.vecinos){
		if(!u.isVisited()){
		    System.out.println(v.getId() + ", " + u.getId());
		}
	    }
	    v.visita();
	}
	resetGrafica();
    }
    
    private void resetGrafica(){
	for(Vertice v: vertices){
	    v.reset();
	}
    }
}
