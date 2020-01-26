import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Orologio {
	public int ora;
	public int minuti;
	public int secondi;

	public Orologio(){
		ora=0;
		minuti=0;
		secondi=0;
	}

	InputStreamReader input= new InputStreamReader(System.in);
	BufferedReader tastiera=new BufferedReader(input);
	//prendo in input da tastiera l'ora
	public void impostaOra() throws NumberFormatException, IOException{
		System.out.println("inserisci ora ");
		do {
			ora=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(ora<=47 && ora>=0));
		System.out.println("inserisci minuti ");
		do {
			minuti=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(minuti<=119 && minuti>=0));
		System.out.println("inserisci secondi ");
		do {
			secondi=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(secondi<=119 && secondi >=0));

	}
//fa avanzare l'otologio se per esempio arriva a 60 secondi
	public void avanzaOrologio() {
		if(secondi==60) {
			secondi-=0;
			minuti++;
		}
		if(minuti>=60) {
			minuti-=60;
			ora++;
		}
		if(ora>=24) {
			ora-=24;
		}
	}
//permette di aumentare l'orario
	public void aumentaOrario() throws NumberFormatException, IOException {
		int scelta;
		System.out.println("aumenta orario   1:secondi  2:minuti  3:ore  esci:tutti gli altri tasti");
		do {
			scelta=Integer.valueOf(tastiera.readLine()).intValue();
			if(scelta==1) {
				secondi++;
			}else {
				if(scelta==2) {
					minuti++;
				}else {
					if(scelta==3) {
						ora++;
					}
				}

			}
			avanzaOrologio();
			System.out.println("sono le "+ ora + " : "+minuti+" : "+secondi);
		}while(scelta==1 || scelta==2 || scelta==3);

	}
	public static void main(String[]args) throws NumberFormatException, IOException{
		Orologio o1 =new Orologio();
		o1.impostaOra();
		o1.avanzaOrologio();
		System.out.println("sono le "+ o1.ora + " : "+o1.minuti+" : "+o1.secondi);
		o1.aumentaOrario();

		System.out.println("sono le "+ o1.ora + " : "+o1.minuti+" : "+o1.secondi);
	}
}

