
public class Dado {
	public int nfaccie;
	public int risultato;

	public Dado(int nfac) { //costruttore
		nfaccie=nfac;
		risultato=0;
	}
//lancia il dado con un random
	public int lancia(int Nfaccie) {
		int risultat;
		risultat=(int) (Math.random()*Nfaccie+1);
		return risultat;
	}
	public static void main(String[]args) {
		int facce=6;
		Dado d1= new Dado(facce);

		d1.risultato=d1.lancia(facce);
		System.out.println("è uscito il numero "+d1.risultato);


	}
}
