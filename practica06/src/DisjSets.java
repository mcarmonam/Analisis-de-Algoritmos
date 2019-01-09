
public class DisjSets{
    private int[][] set;
    
    public int getRe(int i){
	if(i==set[i][1]) return i;
	else return getRe(set[i][1]);
    }
    
    public DisjSets(int i){
	set = new int[i+1][2];
	for (int j = 1;j<i+1;j++){
	    set[j][0] = j;
	    set[j][1] = j;
	}
    }
    
    public void union(int i, int j, int re1,int re2){
	if(re1>re2){
	    set[re2][1] = re1;
	}else{
	    set[re1][1] = re2;
	}
    }
}
