
public class Persona {
	public int anni;
	public float peso;
	public int altezza;
	public String nome;
	public String hobby;
	public String capelli;
	public String occhi;

	public Persona(int A,float p,int a,String n,String h,String c,String o) {
		anni=A;
		peso=p;
		altezza=a;
		nome=n;
		hobby=h;
		capelli=c;
		occhi=o;

	}
	//fa mangiare 
	public void mangia(int nPanini) {
		peso+=0.250*nPanini;
	}
	//fa correre
	public void corri(int min) {
		peso-=0.01*min;
	}
	//fa invecchiare
	public void invecchia() {
		anni++;
	}
	public static void main(String[]args){
		Persona p1= new Persona(32, 62.5f, 182, "piero", "tour dei bar della valle", "neri", "verdi");
		System.out.println("ciao mi chiamo "+p1.nome+" ho "+p1.anni+" anni, sono alto "+p1.altezza+"cm, ho gli occhi " + p1.occhi+" e i capelli "+ p1.capelli+ " peso "+ p1.peso +" chili, il mio hobby è il  "+p1.hobby);
		p1.mangia(6);
		System.out.println("dopo aver mangiato peso "+p1.peso+" chili");
		int minuti=90;
		p1.corri(minuti);
		System.out.println("dopo aver corso peso "+p1.peso+" chili");
		System.out.println("le variazioni di peso sono basate su una stima non veritiera pertanto non sperate di dimagrire velocemente come "+ p1.nome);
	}
}
