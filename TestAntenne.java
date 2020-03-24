import java.util.ArrayList;
import java.util.Scanner;
public class TestAntenne {
	
	
	public static ArrayList<Antenne> CreateAntenne(boolean isEmpty) {
		ArrayList<Antenne> Antlist = new ArrayList<Antenne>();
		int idAntenne=0;
		Scanner user = new Scanner(System.in);
		if (isEmpty==true) {
			idAntenne++;
			Antlist.add(new Antenne(Integer.toString(idAntenne)));
		}else {
			idAntenne++;
			System.out.println("Entrer la Valeur de gain (Chiffre) ");
			float gain = user.nextFloat();
			System.out.println("Entrer la Valeur de frequence (Chiffre) ");
			float frequence = user.nextFloat();
			System.out.println("Entrer la Valeur de puissance (Chiffre) ");
			float puissance = user.nextFloat();
			System.out.println("Entrer la Valeur de sensibilite (Chiffre) ");
			float sensibilite = user.nextFloat();
			System.out.println("Choisir le type de polarisation :");
			System.out.println("1. Horizontale ");
			System.out.println("2. Verticale ");
			System.out.println("3. Gauche ");
			System.out.println("4. Droite ");
			int choixPol = user.nextInt();
			String polarisation="NULL";
			if(choixPol==1){
				polarisation="horizontale";
				}
			if(choixPol==2){
				polarisation="verticale";
				}
			if(choixPol==3){
				polarisation="gauche";
				}
			if(choixPol==4){
				polarisation="droite";
				}
			Antlist.add(new Antenne(Integer.toString(idAntenne),gain,frequence,puissance,sensibilite,polarisation));
		}
		return Antlist;
	}
	
	
	 public static void main (String args[]){
		ArrayList<Antenne> x=CreateAntenne(false);
		System.out.println(x.get(0));
		for(int i=0;i<x.size();i++){
			System.out.println(x.get(i).caracteristiqueAntenne());
		}
		x.get(0).modifier();
		for(int i=0;i<x.size();i++){
			System.out.println(x.get(i).caracteristiqueAntenne());
		}
	 }
}
