import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Storiella {
	public static void cls() {
		for(int i=0;i<13;i++) {
			System.out.println();

		}
	}
	public static void main(String[]args) throws IOException {
		InputStreamReader input= new InputStreamReader(System.in);
		BufferedReader tastiera=new BufferedReader(input);
		int s=0;
		//Persona p1= new Persona(17, 55.0f, 175, "liam" ,"al so mia","marroni","verdi");//per il debug
		//fa inserire i dati del personaggio
		System.out.println("Creazione personaggio in corso inserire in seguenti dati");

		System.out.println("inserisci il nome");
		String nome=tastiera.readLine();

		System.out.println("inserisci gli anni");
		int anni=Integer.valueOf(tastiera.readLine()).intValue();

		System.out.println("inserisci l'altezza in cm");
		int altezza=Integer.valueOf(tastiera.readLine()).intValue();

		System.out.println("inserisci il peso");
		float peso=Float.valueOf(tastiera.readLine()).floatValue();

		System.out.println("inserisci il colore degli occhi");
		String occhi=tastiera.readLine();

		System.out.println("inserisci il colore dei capelli");
		String capelli=tastiera.readLine();

		System.out.println("inserisci l'hobby");
		String hobby=tastiera.readLine();


//inizializzazione della persona
		Persona p1= new Persona(anni, peso, altezza, nome,hobby,capelli,occhi);
		
		do {
			
			System.out.println("riepilogo:");
			System.out.println("nome: "+p1.nome);
			System.out.println("anni: "+p1.anni);
			System.out.println("altezza: "+p1.altezza);
			System.out.println("peso: "+p1.peso);
			System.out.println("occhi: "+p1.occhi);
			System.out.println("capelli: "+p1.capelli);
			System.out.println("hobby: "+p1.hobby);

			System.out.println("vuoi cambiare qualcosa?   1-si   2-no");

			do {
				s=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(s==1 || s==2));
			if(s==1) {
				
				System.out.println("cosa vuoi cambiare?");
				System.out.println("1-nome");
				System.out.println("2-anni");
				System.out.println("3-altezza");
				System.out.println("4-peso");
				System.out.println("5-occhi");
				System.out.println("6-capelli");
				System.out.println("7-hobby");
				do {
					s=Integer.valueOf(tastiera.readLine()).intValue();
				}while(!(s>0 && s<8));
				switch(s) {
				case 1:
					p1.nome=tastiera.readLine();
					break;
				case 2:
					p1.anni=Integer.valueOf(tastiera.readLine()).intValue();
					break;
				case 3:
					p1.altezza=Integer.valueOf(tastiera.readLine()).intValue();
					break;
				case 4:
					p1.peso=Float.valueOf(tastiera.readLine()).floatValue();
					break;
				case 5:
					p1.occhi=tastiera.readLine();
					break;
				case 6:
					p1.capelli=tastiera.readLine();
					break;
				case 7:
					p1.hobby=tastiera.readLine();
					break;
				}
			}
		}while(!(s==2));

		System.out.println("DRIIIIIN!!! squilla il telefono di "+p1.nome+" è la banca che vuole prendere un'appuntamento");
		System.out.println("banchiere: buongiorno "+p1.nome+" a che ora preferisce l'appuntamento?");
		Orologio ora=new Orologio();
		
		
		do {
			ora.impostaOra();
			System.out.println(ora.ora+":"+ora.minuti+":"+ora.secondi+" ho capito bene?");
			System.out.println("1-si  2-no");
			s=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(s==1));
		System.out.println("Ok a dopo :)");

		System.out.println(p1.nome+" sfrutta l'occasione di andare in banca per portare a spasso ''cane''");
		System.out.println("hey ''cane'' non mi sembra un bel nome per il tuo cucciolo, diamogli un nome?");
		Cane cane=new Cane("",0,4.6f,0);
		do {
			cane.nome=tastiera.readLine();
			System.out.println("si chiama "+cane.nome+" giusto?");
			System.out.println("1-si  2-no");
			s=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(s==1));
		int tempo=(int) (Math.random()*120+30);
		p1.corri(tempo);
		System.out.println(p1.nome+" imposta Sport Tracker e parte di corsa per la banca");
		System.out.println("Sport Tracker: Sei arrivato a destnazione in "+tempo+" minuti, dopo aver corso pesi "+p1.peso+" Kg");
		System.out.println(p1.nome+" e "+cane.nome+" sono molto affamati, quindi si recano al bancomant per prelevare i soldi con cui pranzare");
		Contocorrente conto = new Contocorrente(12000f);
		
		do {
			System.out.println("BANCOMAT: che operazione vuole fare 1-prelievo 2-deposito");
			s=Integer.valueOf(tastiera.readLine()).intValue();
			if(s==2) {
				System.out.println(p1.nome+" non ha soldi da depositare e quindi prova a depositare "+cane.nome+" ma fallisce");
				System.out.println("BANCOMAT: dom preleva che almeno vai a mangiare");
			}else {
				conto.prelievo();
			}
		}while(!(s==1));
		System.out.println("CAMERIERE: quanti panini vuole?");
		System.out.println("aspetti solo un secondo che tiro un dado a 32 facce per decidere");
		Dado dado=new Dado(32);
		s=dado.lancia(32);
		System.out.println("il dado ha deciso, mangerò "+s+" panini");
		p1.mangia(s);
		System.out.println("dopo aver mangiato "+p1.nome+" pesa "+ p1.peso+" Kg");
		System.out.println("anche "+cane.nome+" ha fame, quante crocchette vuoi dargli?");
		do {
			s=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(s>0));
		cane.mangia(s);
		System.out.println("dopo aver mangiato "+cane.nome+" pesa "+ cane.peso+" Kg");
		System.out.println("sono le "+ora.ora+":"+ora.minuti+" è ora di andare in banca");
		System.out.println("BANCHIERE:buongiorno l'ho chiamata solo per dirle che");
		conto.UltimoMovimento();
		System.out.println("in che data vuole il prossimo appuntamento?");
		Data data=new Data();
		do {
			data.impostaData();
			System.out.println(data.giorno+"/"+data.mese+"/"+data.anno+" ho capito bene?");
			System.out.println("1-si  2-no");
			s=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(s==1));
		System.out.println("ok perfetto ci vediamo il "+data.giorno+"/"+data.mese+"/"+data.anno);
		
		System.out.println("uscito dalla banca "+p1.nome+" incontra il suo caro amico Piergianni con cui gioca a carta sasso forbice");
		CartaSassoForbice partita = new CartaSassoForbice();
		partita.nomeCPU="Piergianni";
		partita.nomePlayer=p1.nome;
		partita.partita();
		System.out.println("FINE DELLA STORIA");
	}
	
}
