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

    //Méthodes de créations ( par cmd / interface graphique ? ) -------------------


    public void modifier(){
        //Modification d'un pylone
    }

    public void supprimer(){
        //Supprimer un pylone (et les antennes attachées)
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
        //Liste des antennes attachées à ce pylone (noeuds attachés à ce pylone)
        
    }
    */
}
