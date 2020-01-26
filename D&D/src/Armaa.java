
public class Armaa {
	public String nome;
	public int DannoBase;
	public int magia;
	public boolean isElementale;
	public String elemento;
	public int danniElementali;
	public float danno;
	public float moltiplicatore;
	public Armaa(int n){
		moltiplicatore=1;
		nome="Spada di legno";
		DannoBase=(int) (Math.random()*n+1);
		magia=(int) (Math.random()*5+0);
		isElementale=false;
		elemento="";
		if(isElementale==true) {
			danniElementali=(int) (Math.random()*6+1);
		}else {
			danniElementali=0;
		}
		danno=(DannoBase+magia+danniElementali)*moltiplicatore;
	}
	public static void main(String[]args) {
		
		Ascia a=new Ascia(false);
		a.moltiplicatore=0;
		
	}
}
