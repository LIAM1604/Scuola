
public class Pozione extends Oggetto{
	private String colore;
	private boolean isLancio;
	private int modHp;
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public boolean isLancio() {
		return isLancio;
	}
	public void setLancio(boolean isLancio) {
		this.isLancio = isLancio;
	}
	public int getModHp() {
		return modHp;
	}
	public void setModHp(int modHp) {
		this.modHp = modHp;
	}
	public Pozione() {
		int rand;
		rand = (int) (Math.random()*2+1);
		switch(rand) {
		case 1:
			nome=("cura base");
			rarità=1;
			costo=10;
			peso=0.3f;
			colore="verde";
			isLancio=false;
			
			modHp=10;
			break;
		case 2:
			nome=("cura forte");
			rarità=7;
			costo=250;
			peso=1f;
			colore="verde plutonio";
			isLancio=false;
			
			modHp=30;
			break;

		}
	}
	public static void usaPozione(Personaggio pg, Pozione poz) {
		for(int i=0;i<pg.inventario.length;i++) {
			//if()
		}
	}
}
