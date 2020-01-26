
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contocorrente {
	public float money;
	public float ultimoMovimento;
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader tastiera = new BufferedReader(input);

	public Contocorrente(float m) {
		money = m;
		ultimoMovimento = 0;
	}

	public void deposito() throws NumberFormatException, IOException {
		System.out.println("Quanto vuoi depositare?");
		do {
			ultimoMovimento = Float.valueOf(tastiera.readLine()).floatValue();
		} while (!(ultimoMovimento > 0));
		money += ultimoMovimento;
	}

	public void prelievo() throws NumberFormatException, IOException {
		System.out.println("Quanto vuoi prelevare?");
		do {
			ultimoMovimento = Float.valueOf(tastiera.readLine()).floatValue();
		} while (!(ultimoMovimento > 0));

		money -= ultimoMovimento;
		ultimoMovimento *= -1;
	}

	public void UltimoMovimento() {
		if (ultimoMovimento < 0) {
			ultimoMovimento *= -1;
			System.out.println("il  suo ultimo movimento è stato un prelievo di " + ultimoMovimento + " $");
			ultimoMovimento *= -1;
		} else {
			System.out.println("il  suo ultimo movimento è stato un deposito di " + ultimoMovimento + " $");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		System.out.println("scegli  1-conto corrente vuoto  2-conto corrente esistente");
		int s;
		Contocorrente c;
		do {
			s = Integer.valueOf(tastiera.readLine()).intValue();
		} while (!(s == 1 || s == 2));
		if (s == 1) {
			c = new Contocorrente(0.0f);
		} else {
			System.out.println("Quanti soldi hai sul conto?");
			float solch = Float.valueOf(tastiera.readLine()).floatValue();
			
			c = new Contocorrente(solch);
		}

		int sc;
		do {
			System.out.println("scegli  1-deposita  2-preleva 3-visuaizza conto 4-ultimo movimento 5-esci");
		
		do {
			sc = Integer.valueOf(tastiera.readLine()).intValue();
		} while (!(sc > 0 && sc < 5));
			switch(sc) {
		case 1:
			c.deposito();
			break;
		case 2:
			c.prelievo();
			break;
		case 3:
			System.out.println("nel tuo conto ci sono "+c.money+" $");
			break;
		case 4:
			c.UltimoMovimento();
			default:
				break;
		}
		}while(!(sc==5));
		
	}
}
