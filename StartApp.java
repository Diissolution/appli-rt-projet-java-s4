import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StartApp {	
	
	public static void creerNoeud() {
	
			  }		 
	
	//Fonctions pour Antennes
	
	/*ic void addPyloneConnect() {
		System.out.println("Veuillez saisir l'ID du noeud auquel ajouter :");
		System.out.println("Veuillez saisir l'ID du pylone :");
		String idNoeud = sc.nextLine();
		String idPylone = sc.nextLine();
		System.out.println("Le pylone " +"AJOUTE l'ID DU PYLONNE DU CON" + " est désormais connecté à ce noeud.");
	}*/
	
	//fonction createAntenne
		static Antenne x = new Antenne();
		public static ArrayList<Antenne> CreateAntenne(ArrayList<Antenne> Antlist,boolean isEmpty) {
			int idAntenne= x.getNbAntenne();
			Scanner user = new Scanner(System.in);
			if (isEmpty==true) {
				Antlist.add(new Antenne(Integer.toString(idAntenne)));
			}else {
				System.out.println("Entrer la Valeur du gain (Chiffre) ");
				float gain = user.nextFloat();
				System.out.println("Entrer la Valeur de la frequence (Chiffre) ");
				float frequence = user.nextFloat();
				System.out.println("Entrer la Valeur de la puissance (Chiffre) ");
				float puissance = user.nextFloat();
				System.out.println("Entrer la Valeur de la sensibilite (Chiffre) ");
				float sensibilite = user.nextFloat();
				System.out.println("Choisir le type de l'antenne (selection) ");
				int choixType = user.nextInt();
				String type="NULL";
				if(choixType==1){
					type="omnidirectionelle";
					}
				if(choixType==2){
					type="directive";
					}
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
				Antlist.add(new Antenne(Integer.toString(idAntenne),gain,frequence,puissance,sensibilite,polarisation,type));
			}
			return Antlist;
		}
		
		//fonction DelelteAntenne
		
		public static ArrayList<Antenne> DeleteAntenne(ArrayList<Antenne> Antlist,int numDel){
			HashMap<String, String> test = new HashMap<String, String>();
			for(int i=0;i<Antlist.size();i++){
				test=Antlist.get(i).caracteristiqueAntenne();
				if(Integer.parseInt(test.get("idAntenne"))==numDel) {
					Antlist.remove(i);
				}
			}
			
			return Antlist;
		}
	
	
	public static void main (String args[]){
		
		//scanner pour faire les choix
		Scanner sc = new Scanner(System.in);
		
		//Liste des Antennes,Pylone et Noeud dans le programme
		ArrayList<Antenne> ListA = new ArrayList<Antenne>();
		ArrayList<Pylone> ListP = new ArrayList<Pylone>();
		ArrayList<Noeud> ListN = new ArrayList<Noeud>();
		
		int run=1;
		while (run==1) {
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1. Créer une antenne");
		System.out.println("2. Créer un pylone");
		System.out.println("3. Créer un noeud");
		System.out.println("4. Ajouter une antenne à un pylone");
		System.out.println("5. Ajouter un pylone à un noeud");
		System.out.println("6. Supprimer une antenne");
		System.out.println("7. Supprimer un pylone");
		System.out.println("8. Supprimer un noeud");
		System.out.println("9. Afficher les caractérisitques d'une antenne");
		System.out.println("10. Afficher les caractérisitques d'un pylone");
		System.out.println("11. Afficher les caractérisitques d'un noeud");
		System.out.println("12. Afficher les informations sur les antennes");
			
			int choix = sc.nextInt();
			
			//création d'une antenne
			if(choix ==1){
				int run2=1;
				while(run2==1) {
				int choixAntenne = sc.nextInt();
				System.out.println("voulez-vous créé une antenne vide ou remplir ses paramètres ?");
				System.out.println("1. Créer une Antenne vide?");
				System.out.println("2. Créer une Antenne et remplir ses paramètres");
				System.out.println("3. Revenir en arrière");
				if(choixAntenne==1) {
					ListA=CreateAntenne(ListA,true);
				}
				else if(choixAntenne==2) {
					ListA=CreateAntenne(ListA,false);
				}
				else if(choixAntenne==3) {
					run2=0;
					}
				else {
					System.out.println("Veuillez choisir un chiffre attitré à une option");
				}
				}
			}
			
			
			//création d'un Noeud
			if(choix ==3){ 
				creerNoeud();
				}
			//supprimer une antenne
			if(choix ==6){ 
				int run2=1;
				while(run2==1) {
					int choixAntenne = sc.nextInt();
					for(int i=0;i<ListA.size();i++){
						System.out.println(ListA.get(i).caracteristiqueAntenne());
					}
					}
				}
			
			//ajout d'un pylone au Noeud
			if(choix ==5){ 
				
				}
					
	
		}
	 }
}
