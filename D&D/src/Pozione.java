
public class Pozione extends Oggetto{
	private boolean effetto; //true = cura  false = danno
	private String colore;
	private boolean isLancio;
	private int modHp;
	public Pozione() {
		int rand;
		rand = (int) (Math.random()*5+1);
		switch(rand) {
		case 1:
			nome=("cura base");
			rarit�=1;
			costo=10;
			peso=0.3f;
			colore="verde";
			isLancio=false;
			effetto=true;
			modHp=20;
			break;
		case 2:
			nome=("cura OP");
			rarit�=7;
			costo=250;
			peso=1f;
			colore="verde plutonio";
			isLancio=false;
			effetto=true;
			modHp=50;
			break;
		case 3:
			nome=("danno base");
			rarit�=3;
			costo=10;
			peso=1.f;
			colore="verde plutonio";
			isLancio=true;
			effetto=false;
			modHp=20;
			break;
		case 4:
			nome=("danno OP");
			rarit�=9;
			costo=300;
			peso=1.f;
			colore="nero pece";
			isLancio=true;
			effetto=false;
			modHp=80;
			break;

		}
	}
}
