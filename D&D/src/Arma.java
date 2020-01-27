

public class Arma {
	public String nome;
	public int DannoBase;
	public int magia;
	public boolean isElementale;
	public String elemento;
	public int danniElementali;
	public boolean dueMani;
	public float danno;

	public Arma(){
		nome="Spada solenne";
		DannoBase=(int) (Math.random()*8+1);
		magia=(int) (Math.random()*5+0);
		isElementale=true;
		elemento="fuoco";
		if(isElementale==true) {
			danniElementali=(int) (Math.random()*6+1);
		}else {
			danniElementali=0;
		}
		dueMani=false;
		if(dueMani==true) {
			danno=(DannoBase+magia+danniElementali)*1.5f;
		}else {
			danno=DannoBase+magia+danniElementali;
		}
	}
	public static void main(String[]args) {
		Arma A=new Arma();
		System.out.println(A.danno);
	}
}
