
public class Oggetto {
protected String nome;
protected int costo;
protected int rarità;
protected float peso;

public Oggetto() {
	
}

public static void main(String[]args) {
	Oggetto o1 = new Oggetto();
	System.out.println(o1.nome+o1.rarità+o1.costo+o1.peso);
}
}
