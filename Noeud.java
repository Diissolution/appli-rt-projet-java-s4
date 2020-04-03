import java.util.ArrayList;
import java.util.HashMap;

public class Noeud {
	
	//constantes
    public static final String DEF="0";

    //variables
    public String idNoeud;
	public String pylonesConnect;	
	public static int nbNoeud=0;
	
	//constructeur par défaut
	public Noeud(){
		this.idNoeud=DEF;
		this.pylonesConnect= "";
		nbNoeud++;
	}
	
	
	//constructeur
		public Noeud(String idNoeud){
			this.idNoeud=idNoeud;
			this.pylonesConnect="";
			nbNoeud++;
		}

	/*//constructeur
	public Noeud(String idNoeud, ArrayList pylonesConnect){
		this.idNoeud=idNoeud;
		this.pylonesConnect=pylonesConnect;
		nbNoeud++;
	}*/
	

	public HashMap caracteristiqueNoeud(){
		HashMap<String, String> liste = new HashMap<String, String>(); 
		liste.put("idNoeud", idNoeud);
		liste.put("pylonesConnect", pylonesConnect);
		return liste;
	}
	
	//accesseurs en lecture
	public String getIdNoeud(){
		return idNoeud;
	}
	
	public String getPylonesConnect(){
		return pylonesConnect;
	}
	
	
	public int getNbNoeud() {
		return nbNoeud;
	}
	
	
	//accesseurs en écriture
	public void setPylonesConnect(String idPylone){
		this.pylonesConnect=idPylone;
	}
		

}