public class Arista implements Comparable<Arista>{
    public final String ID;
    public final int WEIGHT;
    public final String EXTREMO1;
    public final String EXTREMO2;
    
    public Arista(String id,int w, String a, String b){
	ID = id;
	WEIGHT = w;
        EXTREMO1 = a;
        EXTREMO2 = b;
    }
    @Override
    public int compareTo(Arista a){
	int resultado=0;
        if (this.WEIGHT<a.WEIGHT) {resultado = -1;}
        else if (this.WEIGHT>a.WEIGHT) {resultado = 1;}
        else {resultado = 0;}
        return resultado;
    }
    @Override 
    public String toString(){
	return WEIGHT+"";
    }
} 
