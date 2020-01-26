
public class Meteo {
	public String mese;
	public static int temperatura[][];
	public int max;
	public int min;
	public int media;

	public Meteo() { //costruttore
		max=0;
		min=0;
		temperatura = new int [12][30];
		for (int j = 0 ; j < 12 ; j++) {
			for(int i=0;i<30;i++) {
				temperatura[j][i]=(int) (Math.random()*45+(-15));
			}
		}

	}

	public void MaxMin(){ //calcolo max e min
		int i=0;
		int max=temperatura[0][0];
		int min=temperatura[0][0];
		for(i=0;i<12;i++) {
			for (int j = 0 ; j < 30 ; j++) {
				if (min > temperatura[i][j]) min = temperatura[i][j];
				if (max < temperatura[i][j]) max = temperatura[i][j];
			}
		}
		System.out.println("la temperatura massima è stata "+max+" la temperatura minima  è stata "+min);
	}
	
	public void StampaTemp() {
		for(int i = 0;i<12;i++) {
			System.out.print("Mese "+(i+1));
			for (int j = 0 ; j < 30 ; j++) {
				System.out.print(" , "+temperatura[i][j] + " , ");
			}
			System.out.println();
		}
	}
	
	public void calcolaMedia() {
		int media = 0;
		for(int i = 0;i<12;i++) {
			System.out.print("\n\nMedia Mese "+(i+1));
			for (int j = 0 ; j < 30 ; j++) {
				media += temperatura[i][0];
			}
			System.out.print("\t" + (media/30));
			media = 0;
		}
	}

	public static void main(String[]args) {  //main
		Meteo m1 = new Meteo();
		m1.StampaTemp();
		m1.MaxMin();
		System.out.println();
		m1.calcolaMedia();
	}
}
