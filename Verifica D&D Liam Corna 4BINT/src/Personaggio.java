import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Personaggio {
	public int livello;
	public String nome;
	public String classe;
	public String razza;
	public int hp;
	public int hpmax;
	public float difesa;
	public int txc;
	public Spada spada=new Spada(false);
	public Armatura armatura;
	public int forza;
	public int destrezza;
	public int costituzione;
	public int intelligenza;
	public int saggezza;
	public int carisma;
	public int modf;
	public int moddes;
	public int modcos;
	public int modint;
	public int modsag;
	public int modcar;
	public int monete;
	public Oggetto[]inventario;

	public Personaggio(Spada spad, Armatura armatur,String nom,String clas,String raz) {
		livello=(int) (Math.random()*20+1);
		nome=nom;
		classe=clas;
		razza=raz;

		spada=spad;
		armatura=armatur;
		forza=(int) (Math.random()*8+1)+(int) +(Math.random()*8+1)+(int) +(Math.random()*8+1);
		destrezza=(int) (Math.random()*8+1)+(int) +(Math.random()*8+1)+(int) +(Math.random()*8+1);
		costituzione=(int) (Math.random()*8+1)+(int) +(Math.random()*8+1)+(int) +(Math.random()*8+1);
		intelligenza=(int) (Math.random()*8+1)+(int) +(Math.random()*8+1)+(int) +(Math.random()*8+1);
		saggezza=(int) (Math.random()*8+1)+(int) +(Math.random()*8+1)+(int) +(Math.random()*8+1);
		carisma=(int) (Math.random()*8+1)+(int) +(Math.random()*8+1)+(int) +(Math.random()*8+1);
		modf=(forza-10)/2;
		moddes=(destrezza-10)/2;
		modcos=(costituzione-10)/2;
		modint=(intelligenza-10)/2;
		modsag=(saggezza-10)/2;
		modcar=(carisma-10)/2;
		monete=0;
		difesa=10+moddes+armatura.CA;
		txc=(int) (Math.random()*20+1)+livello+modf+spada.magia;
		hp=((int) (Math.random()*10+1)+modcos)*livello;
		hpmax=hp;
		inventario=new Oggetto[10+modf];
		for(int i=0;i<inventario.length;i++) {
			inventario[i]=new Oggetto();
		}
	}
	public void combattimento(Personaggio pers) {
		int i = 1;
		do {

			System.out.println(" ");
			System.out.println("*********************************************");
			System.out.println("Turno "+i);
			System.out.println(" ");
			System.out.println("     "+this.nome+"        		  "+pers.nome);
			System.out.println("HP:"+this.hp+"  TXC:"+this.txc+"          HP:"+pers.hp+"  TXC:"+pers.txc);
			this.txc=(int) (Math.random()*10+1)+this.livello+this.modf+this.spada.magia;
			pers.txc=(int) (Math.random()*10+1)+pers.livello+pers.modf+pers.spada.magia;

			if(this.txc>=pers.difesa) {
				pers.hp-=(this.spada.danno+this.modf);
				System.out.println(this.nome+" ha un txc di "+this.txc+" quindi "+"fa un danno di "+(this.spada.danno+this.modf));
			}else {
				System.out.println(this.nome+" ha un txc di "+this.txc+" quindi "+"missa il colpo");
			}
			System.out.println(" ");


			System.out.println(" ");

			System.out.println("     "+this.nome+"        		  "+pers.nome);
			System.out.println("HP:"+this.hp+"  TXC:"+this.txc+"          HP:"+pers.hp+"  TXC:"+pers.txc);
				if(pers.hp>0) {
								if(pers.txc>=this.difesa) {
				this.hp-=pers.spada.danno;
				System.out.println(pers.nome+" ha un txc di  "+pers.txc+" quindi "+"fa un danno di "+(this.spada.danno+this.modf));
			}else {
				System.out.println(pers.nome+" ha un txc di  "+pers.txc+" quindi "+"missa il colpo");
			}
				}

			i++;
		}while(this.hp>0 && pers.hp>0);
		if(this.hp<=0) {
			System.out.println(pers.nome+" ha vinto ");
		}else {
			System.out.println(this.nome+" ha vinto ");
		}
	}
	
	public static void main(String[]args) throws NumberFormatException, IOException {
		InputStreamReader input= new InputStreamReader(System.in);
		BufferedReader tastiera=new BufferedReader(input);
		
		String nome1; String classe1 = null; String razza1 = null; int n;
		do {
			System.out.println("EIIII giocatore 1 dai un nome al tuo personaggio");
			do {
				nome1=tastiera.readLine();
				System.out.println("Hai scelto "+nome1+" giusto?");
				System.out.println("1-SI  2-NO");
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<3));
		}while(n!=1);
		
		do {
			System.out.println("Quale classe vuoi? ");
		System.out.println("1-Barbaro	7-Mago");
		System.out.println("2-Bardo		8-Monaco");
		System.out.println("3-Chierico	9-Paladino");
		System.out.println("4-Druido	10-Ranger");
		System.out.println("5-Guerriero	11-Stregone");
		System.out.println("6-Ladro		12-Warlock");
		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<13));
		switch(n) {
		case 1:
			classe1="Barbaro";
			break;
		case 2:
			classe1="Bardo";
			break;
		case 3:
			classe1="Chierico";
			break;
		case 4:
			classe1="Druido";
			break;
		case 5:
			classe1="Guerriero";
			break;
		case 6:
			classe1="Ladro";
			break;
		case 7:
			classe1="Mago";
			break;
		case 8:
			classe1="Monaco";
			break;
		case 9:
			classe1="Paladino";
			break;
		case 10:
			classe1="Ranger";
			break;
		case 11:
			classe1="Stregone";
			break;
		case 12:
			classe1="Warlock";
			break;
		}
		System.out.println("Hai scelto "+classe1+" va bene?");
		System.out.println("1-SI  2-NO");
		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<3));
		}while(n!=1);
		
		do {
			System.out.println("Quale razza vuoi? ");
		System.out.println("1-Elfo		6-Gnomo");
		System.out.println("2-Halfling	7-Mezzelfo");
		System.out.println("3-Nano		8-Mezzorco");
		System.out.println("4-Umano		9-Ranger");
		System.out.println("5-Dragonide");

		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<10));
		switch(n) {
		case 1:
			razza1="Elfo";
			break;
		case 2:
			razza1="Halfling";
			break;
		case 3:
			razza1="Nano";
			break;
		case 4:
			razza1="Umano";
			break;
		case 5:
			razza1="Dragonide";
			break;
		case 6:
			razza1="Gnomo";
			break;
		case 7:
			razza1="Mezzelfo";
			break;
		case 8:
			razza1="Mezzorco";
			break;
		case 9:
			razza1="Ranger";
			break;

		}
		System.out.println("Hai scelto "+razza1+" va bene?");
		System.out.println("1-SI  2-NO");
		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<3));
		}while(n!=1);
		
		String nome2; String classe2 = null; String razza2 = null;
		do {
			System.out.println("EIIII giocatore 2 dai un nome al tuo personaggio");
			do {
				nome2=tastiera.readLine();
				System.out.println("Hai scelto "+nome2+" giusto?");
				System.out.println("1-SI  2-NO");
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<3));
		}while(n!=1);
		
		do {
			System.out.println("Quale classe vuoi? ");
		System.out.println("1-Barbaro	7-Mago");
		System.out.println("2-Bardo		8-Monaco");
		System.out.println("3-Chierico	9-Paladino");
		System.out.println("4-Druido	10-Ranger");
		System.out.println("5-Guerriero	11-Stregone");
		System.out.println("6-Ladro		12-Warlock");
		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<13));
		switch(n) {
		case 1:
			classe2="Barbaro";
			break;
		case 2:
			classe2="Bardo";
			break;
		case 3:
			classe2="Chierico";
			break;
		case 4:
			classe2="Druido";
			break;
		case 5:
			classe2="Guerriero";
			break;
		case 6:
			classe2="Ladro";
			break;
		case 7:
			classe2="Mago";
			break;
		case 8:
			classe2="Monaco";
			break;
		case 9:
			classe2="Paladino";
			break;
		case 10:
			classe2="Ranger";
			break;
		case 11:
			classe2="Stregone";
			break;
		case 12:
			classe2="Warlock";
			break;
		}
		System.out.println("Hai scelto "+classe2+" va bene?");
		System.out.println("1-SI  2-NO");
		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<3));
		}while(n!=1);
		
		do {
			System.out.println("Quale razza vuoi? ");
		System.out.println("1-Elfo		6-Gnomo");
		System.out.println("2-Halfling	7-Mezzelfo");
		System.out.println("3-Nano		8-Mezzorco");
		System.out.println("4-Umano		9-Ranger");
		System.out.println("5-Dragonide");

		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<10));
		switch(n) {
		case 1:
			razza2="Elfo";
			break;
		case 2:
			razza1="Halfling";
			break;
		case 3:
			razza2="Nano";
			break;
		case 4:
			razza2="Umano";
			break;
		case 5:
			razza2="Dragonide";
			break;
		case 6:
			razza2="Gnomo";
			break;
		case 7:
			razza2="Mezzelfo";
			break;
		case 8:
			razza2="Mezzorco";
			break;
		case 9:
			razza2="Ranger";
			break;

		}
		System.out.println("Hai scelto "+razza2+" va bene?");
		System.out.println("1-SI  2-NO");
		do {
			n=Integer.valueOf(tastiera.readLine()).intValue();
		}while(!(n>0 && n<3));
		}while(n!=1);
		


		Spada spa1=new Spada(true);
		Armatura arm1=new Armatura();
		//Personaggio p1=new Personaggio(spa1,arm1,nome1,classe1,razza1);	
		Personaggio p1=new Personaggio(spa1,arm1,"liam",null,null);	
		Spada spa2=new Spada(true);
		Armatura arm2=new Armatura();
		//Personaggio p2=new Personaggio(spa2,arm2,nome2,classe2,razza2);
		Personaggio p2=new Personaggio(spa2,arm2,"gino",null,null);
		
		
		/* PER CONTROLLO CALCOLI
		System.out.println("livello "+p1.livello);
		System.out.println("hp "+p1.hp);
		System.out.println("difesa "+p1.difesa);
		System.out.println("txc "+p1.txc);
		System.out.println("forza "+p1.forza);
		System.out.println("destrezza "+p1.destrezza);
		System.out.println("costituzione "+p1.costituzione);
		System.out.println("intelligenza "+p1.intelligenza);
		System.out.println("saggezza "+p1.saggezza);
		System.out.println("carisma"+p1.carisma);
		System.out.println("modf "+p1.modf);
		System.out.println("moddes "+p1.moddes);
		System.out.println("modcos "+p1.modcos);
		System.out.println("modint "+p1.modint);
		System.out.println("modsag "+p1.modsag);
		System.out.println("modcar "+p1.modcar);
		System.out.println("modcar "+p1.modcar);
		System.out.println("magia spada "+p1.spada.magia);
		System.out.println("CA "+p1.armatura.CA);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("livello "+p2.livello);
		System.out.println("hp "+p2.hp);
		System.out.println("difesa "+p2.difesa);
		System.out.println("txc "+p2.txc);
		System.out.println("forza "+p2.forza);
		System.out.println("destrezza "+p2.destrezza);
		System.out.println("costituzione "+p2.costituzione);
		System.out.println("intelligenza "+p2.intelligenza);
		System.out.println("saggezza "+p2.saggezza);
		System.out.println("carisma"+p2.carisma);
		System.out.println("modf "+p2.modf);
		System.out.println("moddes "+p2.moddes);
		System.out.println("modcos "+p2.modcos);
		System.out.println("modint "+p2.modint);
		System.out.println("modsag "+p2.modsag);
		System.out.println("modcar "+p2.modcar);
		System.out.println("magia spada "+p2.spada.magia);
		System.out.println("CA "+p2.armatura.CA);*/
System.out.println("ciao");

		p1.combattimento(p2);


	}
}