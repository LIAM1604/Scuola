
public class Cane {
	public String nome;
	public int anni;
	public float peso;
	public int forza;

	public Cane(String n, int a, float p,int f){ //costruttore
		nome=n;
		anni=a;
		peso=p;
		forza=f;
	}
//fa mangiare il cane
	public void mangia(int numCrocchette){
		peso += 0.1*numCrocchette;

	}
//fa mordere il cane
	public float mordi(){
		float danno;
		danno = forza * peso;
		return danno;
	}

	public static void main(String[]args){
		float dannoCane;
		Cane c1 = new Cane("doggo", 3, 12.5f, 10);
		System.out.println("il tuo cane si chiama: " + c1.nome + " ha " + c1.anni + " anni   pesa "+ c1.peso + " chili e ha una forza di " + c1.forza);
		dannoCane=c1.mordi();
		System.out.println("prima di mangiare il cane fa " + dannoCane + " di danno");
		c1.mangia(20);
		dannoCane=c1.mordi();
		System.out.println("dopo aver mangiato il tuo cane pesa: " + c1.peso +" chili e fa " + dannoCane +" di danno");

	}
}

