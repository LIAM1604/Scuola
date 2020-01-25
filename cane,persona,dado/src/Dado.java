
public class Dado {
public int nfaccie;
public int risultato;

public Dado(int nfac) {
	nfaccie=nfac;
	risultato=0;
}

public int lancia(int Nfaccie) {
	int risultat;
	risultat=(int) (Math.random()*Nfaccie+1);
	return risultat;
}
public static void main(String[]args) {
	int facce=6;
	Dado d1= new Dado(facce);
	
		d1.risultato=d1.lancia(facce);
		System.out.println(d1.risultato);
	
	
}
}
