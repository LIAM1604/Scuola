import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[]args) throws NumberFormatException, IOException {
		InputStreamReader input= new InputStreamReader(System.in);
		BufferedReader tastiera=new BufferedReader(input);

		int n;
		String nom;
		do {
			System.out.println("dai un nome al tuo personaggio");
			do {

				nom=tastiera.readLine();
				System.out.println("Hai scelto "+nom+" giusto?");
				System.out.println("1-SI  2-NO");
				n=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(n>0 && n<3));
		}while(n!=1);
		String clas="";
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
				clas="Barbaro";
				break;
			case 2:
				clas="Bardo";
				break;
			case 3:
				clas="Chierico";
				break;
			case 4:
				clas="Druido";
				break;
			case 5:
				clas="Guerriero";
				break;
			case 6:
				clas="Ladro";
				break;
			case 7:
				clas="Mago";
				break;
			case 8:
				clas="Monaco";
				break;
			case 9:
				clas="Paladino";
				break;
			case 10:
				clas="Ranger";
				break;
			case 11:
				clas="Stregone";
				break;
			case 12:
				clas="Warlock";
				break;
			}
			System.out.println("Hai scelto "+clas+" va bene?");
			System.out.println("1-SI  2-NO");
			do {
				n=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(n>0 && n<3));
		}while(n!=1);

		String razza="";
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
				razza="Elfo";
				break;
			case 2:
				razza="Halfling";
				break;
			case 3:
				razza="Nano";
				break;
			case 4:
				razza="Umano";
				break;
			case 5:
				razza="Dragonide";
				break;
			case 6:
				razza="Gnomo";
				break;
			case 7:
				razza="Mezzelfo";
				break;
			case 8:
				razza="Mezzorco";
				break;
			case 9:
				razza="Ranger";
				break;

			}
			System.out.println("Hai scelto "+razza+" va bene?");
			System.out.println("1-SI  2-NO");
			do {
				n=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(n>0 && n<3));
		}while(n!=1);
		int s;
		boolean b;
		do {
			System.out.println("la spada la vuoi tenere a 1-una mano 2-due mani");
			do {
				s=Integer.valueOf(tastiera.readLine()).intValue();
				System.out.println("Hai scelto "+s+" giusto?");
				System.out.println("1-SI  2-NO");
				n=Integer.valueOf(tastiera.readLine()).intValue();
			}while(!(n>0 && n<3));
		}while(n!=1);
		if(s==1) {
			b=true;
		}else {
			b=false;
		}
		Spada spada =new Spada(b);
		spada.nome="spada normale";
		Armatura armatura = new Armatura();
		armatura.nome="armatura normle";
		armatura.CA=1;
	
		Personaggio G1 = new Personaggio(spada,armatura,nom,clas,razza);
		System.out.println(G1.nome+" ha "+G1.hp+" hp");
		System.out.println("A "+G1.nome+" viene donata una spada infuocata e una corazza di ferro da un imperatore orientale");
		G1.armatura.nome="corazza di ferro";
		G1.armatura.CA=3;
		G1.spada.isElementale=true;
		G1.spada.elemento="fuoco";
		System.out.println(" entra in una cripta e viene colpito da un gas che gli toglie il 40% della vita"+"\n");
		G1.hp-=G1.hp*0.4;
		
		System.out.println(G1.nome+" ha "+G1.hp+" hp"+"\n");
		System.out.println(G1.nome+" apre uno scrigno e trova una pozione"+"\n");
		G1.inventario[(int) (Math.random()*(G1.inventario.length)+0)]=new Pozione();
		for(int i=0;i<G1.inventario.length;i++) {
		if(G1.inventario[i].nome=="cura base" || G1.inventario[i].nome=="cura OP") {
			Pozione a =new Pozione();
			a=(Pozione) G1.inventario[i];
				G1.hp+=a.getModHp();
				System.out.println(G1.nome+" usa la pozione e si cura di "+a.getModHp()+"\n");
				System.out.println(G1.nome+" ha "+G1.hp+" hp"+"\n");
				G1.inventario[i]=null;
				if(G1.hp>G1.hpmax) {
					G1.hp=G1.hpmax;
				}
			}
		}
		
		System.out.println("Dalla penombra arriva una figura umanoide che attacca "+G1.nome+"\n");
		Spada spada2 = new Spada(false);
		spada2.nome="spada delle tenebre";
		spada2.isElementale=true;
		spada2.elemento="terrore";
		Armatura armatura2 = new Armatura();
		armatura2.nome="corazza di roccia muschiosa";
		armatura2.CA=3;
		Personaggio G2 = new Personaggio(spada2,armatura2,"Umanoide","Umanoide","Umanoide");
		G2.combattimento(G1);
if(G1.hp>G2.hp) {
	System.out.println(G1.nome+" riceve 50 monete"+"\n");
	System.out.println(G1.nome+" aumenta di livello e vengono gli ripristinati gli hp"+"\n");
	G1.monete+=50;
	G1.livello++;
	G1.hp=(G1.hpmax/(G1.livello-1))*G1.livello;
	System.out.println(G1.nome+" ha "+G1.hp+" hp"+"\n");
}else {
	System.out.println("GAME OVER");
}
}
}
