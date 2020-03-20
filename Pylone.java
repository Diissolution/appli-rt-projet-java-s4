import java.util.*;

public class Pylone {

    //Constantes
    private final String IDPYLONE = "0";
    private final double[] COORDGPS = {0.0,0.0} ;
    private final int NBANTENNES = 0 ;
    private final ArrayList<String> ANTENNECONNECT = new ArrayList<String>();
    private final String NOEUDCONNECT = "aucun";

    //Variables d'instance
    private String idPylone ;
    private double[] coordGps ;
    private int nbAntennes ;
    private ArrayList<String> antenneConnect ;
    private String noeudConnect ;
    
    public static int nbPylone=0;
    

    public Pylone(){
        this.coordGps=COORDGPS;
        this.nbAntennes=NBANTENNES;
        this.antenneConnect=ANTENNECONNECT;
        this.noeudConnect=NOEUDCONNECT;
        this.idPylone=IDPYLONE;
        nbPylone++;
    }

    public Pylone(String idPylone, double[] coordGps, int nbAntennes, ArrayList<String> antenneConnect, String noeudConnect){
        this.coordGps=coordGps;
        this.nbAntennes=nbAntennes;
        this.antenneConnect=antenneConnect;
        this.noeudConnect=noeudConnect;
        this.idPylone=idPylone;
        nbPylone++;
    }

    //Accesseurs -----------------------------------------------------------------
    public String getIdPylone(){
        return idPylone;
    }

    public double[] getCoordGps(){
        return coordGps;
    }

    public int getNbAntennes(){
        return nbAntennes;
    }

    public ArrayList<String> getAntenneConnect(){
        return antenneConnect;
    }

    public String getNoeudConnect(){
        return noeudConnect;
    }

    //Set -------------------------------------------------------------------------

    public void setIdPylone(String idPylone){
        this.idPylone=idPylone;
    }

    public void setCoordGps(double[] coordGps){
        this.coordGps=coordGps;
    }

    public void setNbAntennes(int nbAntennes){
        this.nbAntennes=nbAntennes;
    }

    public void setAntenneConnect(ArrayList<String> antenneConnect){
        this.antenneConnect=antenneConnect;
    }

    public void setNoeudConnect(String noeudConnect){
        this.noeudConnect=noeudConnect;
    }

    //MÃ©thodes de crÃ©ations ( par cmd / interface graphique ? ) -------------------


    public void modifier(){
    	
    	Scanner sc = new Scanner(System.in);
    	
		System.out.println("1. Coordonnées ");
		System.out.println("2. Nombres d'antennes connectées");
		System.out.println("3. Liste des antennes connectées");
		System.out.println("4. Noeud connecté");
		
		int choix = sc.nextInt();
		
		switch(choix) {
		case 1:
			System.out.println("Entrez la nouvelle latitude:(double avec virgule)");
	        double coord1 = sc.nextDouble();
	        System.out.println("Entrez la nouvelle longitude:(double avec virgule)");
	        double coord2 = sc.nextDouble();
	        double coords[] = {coord1,coord2};
	        this.setCoordGps(coords);
			break;
			
		case 2:
			System.out.println("Entrez le nouveau nombre d'antennes connectées:(int)");
	        this.setNbAntennes(sc.nextInt());
	        sc.nextLine();
			break;
			
		case 3:
			ArrayList<String> antennesConnectees = new ArrayList<String>();
			System.out.println("Entrez les ID des antennes connectées séparés par des virgules:");
	        String antennes = sc.nextLine();
	        String[] antennesSeparees = antennes.split(",");
	        for (int i = 0; i < antennesSeparees.length; i++) {
	            antennesConnectees.add(antennesSeparees[i]);
	        }
	        this.setAntenneConnect(antennesConnectees);
			break;
			
		case 4:
			System.out.println("Entrez l'ID du noeud auquel le pylône est connecté:(String)");
	        this.setNoeudConnect(sc.nextLine());
			break;
		}
		
		sc.close();

    }

    public void supprimer(){
        //Supprimer un pylone (et les antennes attachÃ©es)
    }
    
    public void affiche(){
        String id=this.idPylone;
        double[] coord = this.coordGps;
        int nb = this.nbAntennes;
        ArrayList<String> antenne = this.antenneConnect;
        String noeud = this.noeudConnect;
        
        System.out.println("ID: "+id+"\nCoordonnées GPS: "+Arrays.toString(coord)+"\nNb antennes connectées: "+nb+"\nListe antennes connectées: "+antenne.toString()+"\nNoeud connecté: "+noeud);
    }

    /*
    public ArrayList<String> listeAntenne(){
        //Liste des antennes attachÃ©es Ã  ce pylone (noeuds attachÃ©s Ã  ce pylone)
        
    }
    */
}
