
import java.util.ArrayList;
import java.util.HashMap;

public class Noeud {
	
	//constantes
    	public static final String DEF="0";

    	//variables
    	public String idNoeud;
	public ArrayList pylonesConnect;
	public HashMap listeAntennes;
	
	//constructeur par défaut
	public Noeud(){
		this.idNoeud=DEF;
		this.pylonesConnect= new ArrayList<String>();
	}
	
	//constructeur
	public Noeud(String idNoeud, ArrayList pylonesConnect){
		this.idNoeud=idNoeud;
		this.pylonesConnect=pylonesConnect;
	}

	
	public String listeAntennes(String listeAntennes){
		return listeAntennes;
	}
	

	public HashMap caracteristiqueAntenne(){
		HashMap<String, String> liste = new HashMap<String, String>(); 
		liste.put("idNoeud", idNoeud);
		return liste;
	}
	
	//accesseurs en lecture
	public String getIdNoeud(){
		return idNoeud;
	}
	public ArrayList<String> getPylonesConnect(){
		return pylonesConnect;
	}
	
	//accesseurs en écriture
	public void addPylonesConnect(String idPylone){
		pylonesConnect.add(idPylone);
	}
	
	public void delPylonesConnect(int num){
		pylonesConnect.remove(num);
	}	
}
