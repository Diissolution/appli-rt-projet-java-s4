import java.util.*;

public class Pylone {

    //Constantes
    private final String IDPYLONE = "0";
    private final double[] COORDGPS = {0.0,0.0} ;
    private final int NBANTENNES = 0 ;
    private final String ANTENNECONNECT = "";
    private final String NOEUDCONNECT = "";

    //Variables d'instance
    private String idPylone ;
    private double[] coordGps ;
    private String tempAntenneConnect ;
    private String noeudConnect ;
    
    public static int nbPylone=0;
    

    public Pylone(){
        this.coordGps=COORDGPS;
        this.tempAntenneConnect=ANTENNECONNECT;
        this.noeudConnect=NOEUDCONNECT;
        this.idPylone=IDPYLONE;
        nbPylone++;
    }
    public Pylone(String idPyl){
        this.coordGps=COORDGPS;
        this.tempAntenneConnect=ANTENNECONNECT;
        this.noeudConnect=NOEUDCONNECT;
        this.idPylone=idPyl;
        nbPylone++;
    }

    public Pylone(String idPylone, double[] coordGps, String noeudConnect){
        this.coordGps=coordGps;
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

    public String getTempAntenneConnect(){
        return tempAntenneConnect;
    }

    public String getNoeudConnect(){
        return noeudConnect;
    }
    public int getNbPylone(){
        return nbPylone;
    }

    //Set -------------------------------------------------------------------------

    public void setIdPylone(String idPylone){
        this.idPylone=idPylone;
    }

    public void setCoordGps(double[] coordGps){
        this.coordGps=coordGps;
    }

    public void setTempAntenneConnect(String tempAntenneConnect){
    	this.tempAntenneConnect=tempAntenneConnect;
	}
    
    public void setNoeudConnect(String noeudConnect){
        this.noeudConnect=noeudConnect;
    }

   
	
	
    //MÃ©thodes de création -> dans le StartApp !


    public void modifier(Scanner sc){
    	
    	
		System.out.println("1. Coordonnees ");
		System.out.println("2. Noeud connecte");
		
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
			System.out.println("Entrez l'ID du noeud auquel le pylone est connecte:(String)");
	        this.setNoeudConnect(sc.nextLine());
			break;
		}
		
    }
    
    public void affiche(){ //Préférer l'utilisation de -> caracteristiquePylone
        String id=this.idPylone;
        double[] coord = this.coordGps;
        String antenne = this.tempAntenneConnect;
        String noeud = this.noeudConnect;
        
        System.out.println("ID: "+id+"\nCoordonnees GPS: "+Arrays.toString(coord)+"\nListe antennes connectees: "+antenne.toString()+"\nNoeud connecte: "+noeud);
    }
    
    public HashMap caracteristiquePylone(){
		HashMap<String, String> liste = new HashMap<String, String>();
		liste.put("idPylone",idPylone);
		liste.put("Coordonees",Arrays.toString(coordGps));
		liste.put("Liste des id des antennes connectees",tempAntenneConnect);
		liste.put("Noeud connecte",noeudConnect);
		return liste;
		}
    
    public HashMap cooPyl() {
    	HashMap<String, double[]> liste = new HashMap<String, double[]>();
    	liste.put("Coordonees",coordGps);
    	return liste;
    }

    /*
    public ArrayList<String> listeAntenne(){
        //Liste des antennes attachÃ©es Ã  ce pylone (noeuds attachÃ©s Ã  ce pylone)
        
    }
    */
}
