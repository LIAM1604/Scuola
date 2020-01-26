import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Data {
	public int giorno;
	public int mese;
	public int anno;
	public boolean cristo;
	public boolean bisestile;
	public Data(){
		giorno=0;
		mese=0;
		anno=0;
		bisestile=false;
		cristo=true;
	}

	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader tastiera = new BufferedReader(input);
//controlla se l'anno è bisestile
	public void Bisestile() {
		if(anno%4==0) {
			bisestile=true;
		}
	}
//prendo in input da tastiera la data
	public void impostaData() throws NumberFormatException, IOException {
		System.out.println("inserisci l'anno");
		anno=Integer.valueOf(tastiera.readLine()).intValue();
		Bisestile();
		System.out.println("inserisci il mese");
		do {
			mese=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(mese>0 && mese<13));
		System.out.println("inserisci il giorno");
		switch(mese) {
		case 4:
		case 6:
		case 9:
		case 11:
			do {
				giorno=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(giorno>0 && giorno<31));
			break;
		case 2:
			if(bisestile==true) {
				do {
					giorno=Integer.valueOf(tastiera.readLine()).intValue();
				}while(!(giorno>0 && giorno<30));
			}else {
				do {
					giorno=Integer.valueOf(tastiera.readLine()).intValue();
				}while(!(giorno>0 && giorno<29));
			}
			break;
		default:
			do {
				giorno=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(giorno>0 && giorno<32));
		}

	}
//avanza la data 
	public void sistemaData() {
		switch(mese) {
		case 4:
		case 6:
		case 9:
		case 11:
			if(giorno==31) {
				giorno=1;
				mese++;
			}
			break;
		case 2:
			if(bisestile==true) {
				if(giorno==30) {
					giorno=1;
					mese++;
				}
			}else {
				if(giorno==29) {
					giorno=1;
					mese++;
				}
			}
			break;
		default:
			if(giorno==32) {
				giorno=1;
				mese++;
			}
		}
		if(mese==13) {
			mese=1;
			anno++;
		}
	}
	//aumenta i giorni i mesi o gli anni
	public void aumentaData() throws NumberFormatException, IOException {
		int scelta;
		System.out.println("aumenta data   1:giorni  2:mesi  3:anni  4:tutti gli altri tasti");
		do {
			scelta=Integer.valueOf(tastiera.readLine()).intValue();
			if(scelta==1) {
				giorno++;
			}else {
				if(scelta==2) {
					mese++;
				}else {
					if(scelta==3) {
						anno++;
					}
				}

			}
			sistemaData();
			System.out.println("è il "+giorno+" / "+mese+" / "+anno);
		}while(scelta==1 || scelta==2 || scelta==3);
	}
	public static void main(String[]args) throws NumberFormatException, IOException {
		Data d1 = new Data();
		d1.impostaData();
		d1.Bisestile();
		System.out.println("è il "+d1.giorno+" / "+d1.mese+" / "+d1.anno);
		d1.aumentaData();
	}
}
