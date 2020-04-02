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
		public ArrayList<Antenne> CreateAntenne(ArrayList<Antenne> Antlist,boolean isEmpty, Scanner user) {
			int idAntenne= x.getNbAntenne();
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
				System.out.println("1. Omnidirectionelle ");
				System.out.println("2. Directive ");
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
				System.out.println("choisir l'id du pylone à associer :");
				String pylonesConnect="NULL";
				String choixPolId = user.nextLine();
				pylonesConnect=choixPolId;
				Antlist.add(new Antenne(Integer.toString(idAntenne),gain,frequence,puissance,sensibilite,polarisation,type,pylonesConnect));
			}
			return Antlist;
		}
		
		public HashMap <String, String> searchAntenne(ArrayList<Antenne> Antlist,int numDel) {
			HashMap<String, String> antenne = new HashMap<String, String>();
			HashMap<String, String> result = new HashMap<String, String>();
			for(int i=0;i<Antlist.size();i++){
				antenne=Antlist.get(i).caracteristiqueAntenne();
				if(Integer.parseInt(antenne.get("idAntenne"))==numDel) {
					result=antenne;
				}
			}
			
			return result;
		}
		
		//fonction DelelteAntenne
		
		public ArrayList<Antenne> DeleteAntenne(ArrayList<Antenne> Antlist,int numDel){
			HashMap<String, String> test = new HashMap<String, String>();
			for(int i=0;i<Antlist.size();i++){
				test=Antlist.get(i).caracteristiqueAntenne();
				if(Integer.parseInt(test.get("idAntenne"))==numDel) {
					Antlist.remove(i);
				}
			}
			
			return Antlist;
		}
	
	// ================================= FONCTIONS PYLÔNE ===========================================
		
		// Création d'un pylône
		static Pylone pyl = new Pylone();
	    public ArrayList<Pylone> CreatePylone(ArrayList<Pylone> Pylonelist,boolean isEmpty, Scanner sc) { 
	  
	    	
	    	int idPyl = pyl.getNbPylone();
	        ArrayList<String> antennesConnectees = new ArrayList<String>();
	        
	        if (isEmpty==true) {
				Pylonelist.add(new Pylone(Integer.toString(idPyl)));
			}else {
				System.out.println("Entrez la latitude:(double avec virgule)");
				double coord1 = sc.nextDouble();
				System.out.println("Entrez la longitude:(double avec virgule)");
				double coord2 = sc.nextDouble();
	        
				System.out.println("Entrez le nombre d'antennes connectées:(int)");
				int nbAntennes = sc.nextInt();
				sc.nextLine();
	        
				System.out.println("Entrez les ID des antennes connectées séparés par des virgules:");
				String antennes = sc.nextLine();
	        
				System.out.println("Entrez l'ID du noeud auquel le pylône est connecté:(String)");
				String idNoeud = sc.nextLine();
	        
				double coords[] = {coord1,coord2};
	        
				String[] antennesSeparees = antennes.split(",");
				for (int i = 0; i < antennesSeparees.length; i++) {
					antennesConnectees.add(antennesSeparees[i]);
				}
			
				Pylonelist.add(new Pylone(Integer.toString(idPyl),coords,nbAntennes,antennesConnectees,idNoeud) );
				}
	        return Pylonelist;
	       
	    }
	    
	    //Recherche d'un pylône
	    public HashMap <String, String> searchPylone(ArrayList<Pylone> Pylonelist,int numRech) {
			HashMap<String, String> pylone = new HashMap<String, String>();
			HashMap<String, String> result = new HashMap<String, String>();
			for(int i=0;i<Pylonelist.size();i++){
				pylone=Pylonelist.get(i).caracteristiquePylone();
				if(Integer.parseInt(pylone.get("idPylone"))==numRech) {
					result=pylone;
				}
			}
			
			return result;
		}
	    
	    //Suppression d'un pylône
	    public ArrayList<Pylone> DeletePylone(ArrayList<Pylone> Pylonelist,int numDel){
			HashMap<String, String> testPyl = new HashMap<String, String>();
			for(int i=0;i<Pylonelist.size();i++){
				testPyl=Pylonelist.get(i).caracteristiquePylone();
				if(Integer.parseInt(testPyl.get("idPylone"))==numDel) {
					Pylonelist.remove(i);
				}
			}
			
			return Pylonelist;
		}
	    
	 // ================================= FIN PYLÔNE =================================================
	
	public void testConnecAnt (ArrayList <Antenne> Antlist) {
		ConvDist convDist = new ConvDist();
		AntenneOmnidirectionnelle omni = new AntenneOmnidirectionnelle();
		AntenneDirective direct = new AntenneDirective();
		
		int idAntenne = 0; //a supprimer, présent juste pour ne pas avoir d'erreur
		float frequenceA;
		float puissanceA;
		float sensibiliteA;
		float gainA;
		float ouvertureA;
		float orientationA;
		String typeA;
		String polarisationA;
		double lat_A;
		double lon_A;
		
		//float frequenceB;
		float puissanceB;
		float sensibiliteB;
		float gainB;
		float ouvertureB;
		float orientationB;
		String typeB;
		String polarisationB;
		double lat_B;
		double lon_B;
		
		double distanceAB;
		boolean testConnec;
		
		
		HashMap<String, String> test = new HashMap<String, String>();
		test = searchAntenne(Antlist, idAntenne);
		typeA = test.get("typeAntenne");
		
				if (typeA == "omnidirectionnelle") {
					
					frequenceA = Float.parseFloat(test.get("frequence"));
					puissanceA = Float.parseFloat(test.get("puissance"));
					sensibiliteA = Float.parseFloat(test.get("sensibilite"));
					gainA = Float.parseFloat(test.get("gain"));
					ouvertureA = Float.parseFloat(test.get("ouverture"));
					orientationA = Float.parseFloat(test.get("orientation"));
					polarisationA = test.get("polarisation");
					lat_A = Double.parseDouble(test.get("lat_a"));
					lon_A = Double.parseDouble(test.get("lon_a"));
					
					
				}else { //directive, cad, pas de gainA
					
					frequenceA = Float.parseFloat(test.get("frequence"));
					puissanceA = Float.parseFloat(test.get("puissance"));
					sensibiliteA = Float.parseFloat(test.get("sensibilite"));
					gainA = Float.parseFloat(test.get("gain"));
					ouvertureA = Float.parseFloat(test.get("ouverture"));
					orientationA = Float.parseFloat(test.get("orientation"));
					polarisationA = test.get("polarisation");
					lat_A = Double.parseDouble(test.get("lat_a"));
					lon_A = Double.parseDouble(test.get("lon_a"));
					
				}
				
				for(int i=0;i<Antlist.size();i++){
					test=Antlist.get(i).caracteristiqueAntenne();
					
					//frequenceB = Float.parseFloat(test.get("frequence"));
					puissanceB = Float.parseFloat(test.get("puissance"));
					sensibiliteB = Float.parseFloat(test.get("sensibilite"));
					gainB = Float.parseFloat(test.get("gain"));
					ouvertureB = Float.parseFloat(test.get("ouverture"));
					orientationB = Float.parseFloat(test.get("orientation"));
					polarisationB = test.get("polarisation");
					lat_B = Double.parseDouble(test.get("lat_a"));
					lon_B = Double.parseDouble(test.get("lon_a"));
					
					distanceAB = convDist.distance(lat_A, lon_A, lat_B, lon_B);
					
					if (typeA == "omnidirectionnelle") {
						testConnec = omni.comAntenne(distanceAB, sensibiliteB, puissanceA, ouvertureA, ouvertureB, polarisationA, polarisationB, frequenceA, gainA, gainB, orientationA, orientationB, lat_A, lon_A, lat_B, lon_B);
						if (testConnec = true) {
							System.out.println("les 2 antennes peuvent communiquer");
							//on affiche l'id de cette antenne
						}else {
							System.out.println("les 2 antennes ne peuvent pas communiquer");
							//on fait rien, cette antenne ne peut pas communiquer avec nous
						}
					}else {
						testConnec = direct.comAntenne(distanceAB, sensibiliteB, puissanceA, ouvertureA, ouvertureB, polarisationA, polarisationB, frequenceA, gainB, orientationA, orientationB, lat_A, lon_A, lat_B, lon_B);
						if (testConnec = true) {
							System.out.println("les 2 antennes peuvent communiquer");
							//on affiche l'id de cette antenne
						}else {
							System.out.println("les 2 antennes ne peuvent pas communiquer");
							//on fait rien, cette antenne ne peut pas communiquer avec nous
						}
					
					}
						
			}
	}
	
	
	public static void main (String args[]){
		HashMap<String, String> test = new HashMap<String, String>();
		StartApp Start = new StartApp();
		//scanner pour faire les choix
		Scanner entre = new Scanner(System.in);
		//Liste des Antennes,Pylone et Noeud dans le programme
		ArrayList<Antenne> ListA = new ArrayList<Antenne>();
		ArrayList<Pylone> ListP = new ArrayList<Pylone>();
		ArrayList<Noeud> ListN = new ArrayList<Noeud>();
		while (true) {
		System.out.println("---=== MENU ===---");
		System.out.println("-- Création --");
		System.out.println("1. Créer une antenne");
		System.out.println("2. Créer un pylone");
		System.out.println("3. Créer un noeud");
		System.out.println("5. Ajouter un pylone à un noeud");
		System.out.println("-- Suppression --");
		System.out.println("6. Supprimer une antenne");
		System.out.println("7. Supprimer un pylone");
		System.out.println("8. Supprimer un noeud");
		System.out.println("-- Caractéristiques --");
		System.out.println("9. Afficher les caractérisitques d'une antenne");
		System.out.println("10. Afficher les caractérisitques d'un pylone");
		System.out.println("11. Afficher les caractérisitques d'un noeud");
		System.out.println("12. Afficher les antennes pouvant se connecter entre elles");
		System.out.print(">> ");
		int choix = entre.nextInt();
			//création d'une antenne
		System.out.println(choix);
		if(choix == 1){
			while(true) {
			System.out.println("voulez-vous créé une antenne vide ou remplir ses paramètres ?");
			System.out.println("1. Créer une Antenne vide?");
			System.out.println("2. Créer une Antenne et remplir ses paramètres");
			System.out.println("3. Revenir en arrière");
			System.out.print(">> ");
			int choixAntenne = entre.nextInt();
			if(choixAntenne==1) {
				ListA=Start.CreateAntenne(ListA,true,entre);
				System.out.println("-----------------------------");
				
			}
			else if(choixAntenne==2) {
				ListA=Start.CreateAntenne(ListA,false,entre);
				System.out.println("-----------------------------");
			}
			else if(choixAntenne==3) {
				break;
				}
			else {
				System.out.println("Veuillez choisir un chiffre attitré à une option");
			}
			}
		}
		if(choix==2) {
			int choixPylone;
			while(true) {
				System.out.println("Voulez-vous créer un pylône vide ou remplir ses paramètres ?");
				System.out.println("1. Créer un Pylone vide?");
				System.out.println("2. Créer un Pylone et remplir ses paramètres");
				System.out.println("3. Revenir en arrière");
    				System.out.print(">> ");
				choixPylone =  entre.nextInt();
				entre.nextLine();
					switch(choixPylone) {
						case 1: 
							ListP=Start.CreatePylone(ListP,true,entre);
							break;
						case 2:
							ListP=Start.CreatePylone(ListP,false,entre);
							break;
						case 3:
							break;
						default:
							System.out.println("Erreur dans le choix.");
							break;
				}
    			}
		}
			
	
		if(choix ==3){ 
			creerNoeud();
		}
			//supprimer une antenne
		if(choix ==6){
			//int choixAntenne = entre.nextInt();
			for(int i=0;i<ListA.size();i++){
						System.out.println(ListA.get(i).caracteristiqueAntenne());
			}
		}
			
			//ajout d'un pylone au Noeud
		if(choix ==5){ 
				
		}
			
		if(choix==10) {
			System.out.println("Entrez l'ID du pylône");
			System.out.print(">> ");
			int numRech = entre.nextInt();
			HashMap<String,String> caracs = Start.searchPylone(ListP,numRech);
			System.out.println("-----------------------------");
			System.out.println("- Pylône "+numRech);
			caracs.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("-----------------------------");
			
		}
			
		if(choix==9) {
			System.out.println("Entrez l'ID de l'antenne");
			System.out.print(">> ");
			int numRech = entre.nextInt();
			HashMap<String,String> caracs = Start.searchAntenne(ListA,numRech);
			System.out.println("-----------------------------");
			System.out.println("- Antenne "+numRech);
			caracs.forEach((key, value) -> System.out.println(key + ": " + value));
			System.out.println("-----------------------------");
			
		}
					
	
		}
	 }
}
