import java.util.ArrayList;
import java.util.HashMap;

public class Antenne{

	public String idAntenne;
	public float gain;
	public float frequence;
	public float puissance;
	public float sensibilite;	
	public String polarisation;
	ArrayList<String> pylonesConnect = new ArrayList<String>();
	
	public Antenne (){
		this.idAntenne="NULL";
		this.gain=0;
		this.frequence=0;
		this.puissance=0;
		this.sensibilite=0;
		this.polarisation="NULL";
		}
	
	public Antenne (String idAntenne, float gain, float frequence, float puissance, float sensibilite,String polarisation){
		this.idAntenne=idAntenne;
		this.gain=gain;
		this.frequence=frequence;
		this.puissance=puissance;
		this.sensibilite=sensibilite;
		this.polarisation=polarisation;
		}
		
			//accesseur en lecture

	public String getIdAntenne(){
				return idAntenne;
				}
	public float getFrequence(){
				return frequence;
				}
				
	public float getGain(){
				return gain;
				}
				
	public float getPuissance(){
				return puissance;
				}
				
	public float getSensibilite(){
				return sensibilite;
				}
				
	public String getPolarisation(){
				return polarisation;
				}

				
				
				
				
	public void setIdAntenne(String idAntenne){
				this.idAntenne=idAntenne;
				}
				
	public void setFrequence(float frequence){
				this.frequence=frequence;
				}
				
	public void setGain(float gain){
				this.gain=gain;
				}
				
	public void setPuissance(float puissance){
				this.puissance=puissance;
				}
	
	public void setSensibilite(float sensibilite){
				this.sensibilite=sensibilite;
				}
				
	public void setPolarisation(String polarisation){
				this.polarisation=polarisation;
				}
				
	public void addPylonesConnect(String textAdd){
		pylonesConnect.add(textAdd);
		}
	
	public void delPylonesConnect(int num){
		pylonesConnect.remove(num);
		}
	
	
	public void cree(){
		
		}
		
	public void modifier(){
		
		}
		
	public void supprimer(){
		
		}
	public HashMap caracteristiqueAntenne(){
		HashMap<String, String> liste = new HashMap<String, String>();
		liste.put("idAntenne",idAntenne);
		liste.put("gain",gain);
		liste.put("gain",gain);
		liste.put("gain",gain);
		liste.put("gain",gain);
		liste.put("gain",gain);
		return liste;
		}
	}
