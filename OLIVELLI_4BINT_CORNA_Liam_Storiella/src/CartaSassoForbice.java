import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CartaSassoForbice{
	public String nomePlayer;
	public String nomeCPU;
	public int winPlayer;
	public int winCPU;
	public int mossaPlayer;
	public int mossaCPU;
	public int turni;
	
	public CartaSassoForbice() { //costruttore
		nomePlayer="";
		nomeCPU="";
		winPlayer=0;
		winCPU=0;
		mossaPlayer=0;
		mossaCPU=0;
		turni=0;
	}
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader tastiera = new BufferedReader(input);
	//input mossa del giocatore
	public void MossaPlayer() throws NumberFormatException, IOException {
		System.out.println("1-carta 2-sasso 3-forbice ");
		do {
			mossaPlayer = Integer.valueOf(tastiera.readLine()).intValue();

		}while(!(mossaPlayer>0 && mossaPlayer<4));
	}
	//random mossa CPU
	public void MossaCPU() {
		
		mossaCPU=(int) (Math.random()*3+1);
	}
	//calcola il vincitore del turno
	public void chiVince() {
	
		switch(mossaPlayer) {
		case 1:
			switch(mossaCPU) {
			case 1:
				System.out.println(nomePlayer+" sceglie carta e "+nomeCPU+" carta");
				System.out.println("Pareggio");
				break;
			case 2:
				System.out.println(nomePlayer+" sceglie carta e "+nomeCPU+" sasso");
				System.out.println("Turno vinto da "+nomePlayer);
				winPlayer++;
				break;
			case 3:
				System.out.println(nomePlayer+" sceglie carta e "+nomeCPU+" forbice");
				System.out.println("Turno vinto da "+nomeCPU);
				winCPU++;
				break;
			}
			break;
		case 2:
			switch(mossaCPU) {
			case 1:
				System.out.println(nomePlayer+" sceglie sasso e "+nomeCPU+" carta");
				System.out.println("Turno vinto da "+nomeCPU);
				winCPU++;
				break;
			case 2:
				System.out.println(nomePlayer+" sceglie sasso e "+nomeCPU+" sasso");
				System.out.println("Pareggio");
				break;
			case 3:
				System.out.println(nomePlayer+" sceglie sasso e "+nomeCPU+" forbice");
				System.out.println("Turno vinto da "+nomePlayer);
				winPlayer++;
				break;
			}
			break;
		case 3:
			//1 carta  2 sasso 3 forbice
			switch(mossaCPU) {
			case 1:
				System.out.println(nomePlayer+" sceglie forbice e "+nomeCPU+" carta");
				System.out.println("Turno vinto da "+nomePlayer);
				winPlayer++;
				break;
			case 2:
				System.out.println(nomePlayer+" sceglie forbice e "+nomeCPU+" sasso");
				System.out.println("Turno vinto da "+nomeCPU);
				winCPU++;
				break;
			case 3:
				System.out.println(nomePlayer+" sceglie forbice e "+nomeCPU+" forbice");
				System.out.println("Pareggio");
				break;
			}
			break;
		}
	}
	//ho richiamato tutti gli altri metodi qui dentro 
	public void partita() throws NumberFormatException, IOException {
		System.out.println("quanti turni vuoi giocare? ");
		do {
			turni=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(turni>0));
		
		for(int i=1;i<=turni;i++) {
			System.out.println("TURNO "+i);
			System.out.println(nomePlayer+" : "+winPlayer+"   "+nomeCPU+" : "+winCPU);
			MossaPlayer();
			MossaCPU();
			chiVince();
			
		}
		if(winPlayer>winCPU) {
			System.out.println("La partita è stata vinta da "+nomePlayer);
		}else {
			if(winPlayer<winCPU) {
				System.out.println("La partita è stata vinta da "+nomeCPU);
			}else {
				System.out.println("La partita è finita in pareggio");
			}
		}
	}
public static void main(String[]args) throws IOException {
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader tastiera = new BufferedReader(input);
	CartaSassoForbice p = new CartaSassoForbice();
	int s=0;
	//input nome giocatore
	do {
		System.out.println("Come ti chiami?");
		p.nomePlayer=tastiera.readLine();
		System.out.println("ti chiami "+p.nomePlayer+" giusto?");
		System.out.println("1-si  2-no");
		do {
			s=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(s==1 && s==2));
		
	}while(!(s==1));
	//input nome CPU
	do {
		System.out.println("Come si chiama il tuo avversario?");
		p.nomeCPU=tastiera.readLine();
		System.out.println("si chiama "+p.nomeCPU+" giusto?");
		System.out.println("1-si  2-no");
		do {
			s=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(s==1 && s==2));
	}while(!(s==1));
	p.partita();
}
}
