public class abstract Antenne{

	public String idAntenne;
	public float gain;
	public float frequence;
	public float puissance;
	public float sensibilite;	
	public String polarisation;
	public String pylonesConnect[];
	
	public Antennes (String idAntenne,float gain, float frequence,float puissance,float sensibilite,String polarisation){
		this.idAntenne=id_Antenne;
		this.gain=gain;
		this.frequence=frequence;
		this.puissance=puissance;
		this.sensibilite=sensibilite;
		this.polarisation=polarisation;
		}
		
			//accesseur en lecture

	public static String getIdAntenne(){
				return idAntenne;
				}
	public static float getFrequence(){
				return frequence;
				}
				
	public static float getGain(){
				return gain;
				}
				
	public static float getPuissance(){
				return puissance;
				}
				
	public static float getSensibilite(){
				return sensibilite;
				}
				
	public static String getPolarisation(){
				return polarisation;
				}
				
	public static String getPylonesConnect(){
				return pylonesConnect[];
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
	
	public void setPylonesConnect(String pylonesConnect[]){
				this.pylonesConnect[]=pylonesConnect[];
				}			
	
	}
