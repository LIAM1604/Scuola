
public class Armatura {
public String nome;
public int CA;
public Armatura() {
	nome="nope";
	CA=(int) (Math.random()*8+1);
}
public static void main(String[]args) {
	Armatura Arm=new Armatura();
	System.out.println(Arm.CA);
}
}
