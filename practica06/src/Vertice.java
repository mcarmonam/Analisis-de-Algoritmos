
public class Vertice implements Comparable<Vertice>{
    public String nombre;
    public int weight;
    
    public Vertice(String n,int w){
	nombre = n;
	weight = w;
    }

    public void setPeso(int i){
	weight = i;
    }
    
    @Override
    public int compareTo(Vertice v){
	int resultado=0;
        if (this.weight<v.weight) {resultado = -1;}
        else if (this.weight>v.weight) {resultado = 1;}
        else {resultado = 0;}
        return resultado;
    }
}
