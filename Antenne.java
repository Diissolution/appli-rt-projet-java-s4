import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Antenne{

	public String idAntenne;
	public float gain;
	public float frequence;
	public float puissance;
	public float sensibilite;	
	public String polarisation;
	public static int nbAntenne=0;
	public String typeAntenne;
	public String pylonesConnect;
	
	//creation scanner
	
	Scanner add = new Scanner(System.in);
	
	//Constructeurs
	
	public Antenne (){
		this.idAntenne="NULL";
		this.gain=0;
		this.frequence=0;
		this.puissance=0;
		this.sensibilite=0;
		this.polarisation="NULL";
		this.typeAntenne="Inconnu";
		this.pylonesConnect="connecté a aucun pylonne";
		nbAntenne++;
		}

	public Antenne (String idAntenne){
		this.idAntenne=idAntenne;
		this.gain=0;
		this.frequence=0;
		this.puissance=0;
		this.sensibilite=0;
		this.polarisation="NULL";
		this.pylonesConnect="connecté a aucun pylonne";
		nbAntenne++;
		}
	
	public Antenne (String idAntenne, float gain, float frequence, float puissance, float sensibilite,String polarisation,String typeAntenne,String pylonesConnect){
		this.idAntenne=idAntenne;
		this.gain=gain;
		this.frequence=frequence;
		this.puissance=puissance;
		this.sensibilite=sensibilite;
		this.polarisation=polarisation;
		this.typeAntenne=typeAntenne;
		this.pylonesConnect=pylonesConnect;
		nbAntenne++;
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
	public int getNbAntenne() {
		return nbAntenne;
	}
				
	public String getPylonesConnect(){
		return pylonesConnect;
		}
	public String getTypeAntenne() {
		return typeAntenne;
	}
	

				
				
				//modificateur en ecriture
				
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
				
	public void setPylonesConnect(String pylonesConnect){
		this.pylonesConnect=pylonesConnect;
		}
	public void setTypeAntenne(String typeAntenne){
		this.typeAntenne=typeAntenne;
		}
	
		
	public void modifier(){
		
		System.out.println("1. gain");
		System.out.println("2. frequence");
		System.out.println("3. puissance");
		System.out.println("4. sensibilite");
		System.out.println("5. polarisation");
		System.out.println("6. Ajouter/remplacer un pylone");
		System.out.println("7. Choisir le type d'antenne");
		
		int choix = add.nextInt();
		if(choix ==1){
			System.out.println("Entrer la Valeur de gain (Chiffre) ");
			setGain(add.nextFloat());
			}
		if(choix ==2){
			System.out.println("Entrer la Valeur de frequence (Chiffre) ");
			setFrequence(add.nextFloat());
			}
		if(choix ==3){
			System.out.println("Entrer la Valeur de puissance (Chiffre) ");
			setPuissance(add.nextFloat());
			}
		if(choix ==4){
			System.out.println("Entrer la Valeur de sensibilite (Chiffre) ");
			setSensibilite(add.nextFloat());
			}
		if(choix ==5){
			System.out.println("Choisir le type de polarisation :");
			System.out.println("1. Horizontale ");
			System.out.println("2. Verticale ");
			System.out.println("3. Gauche ");
			System.out.println("4. Droite ");
			int choixPol = add.nextInt();
			if(choixPol==1){
				setPolarisation("horizontale");
				}
			if(choixPol==2){
				setPolarisation("verticale");
				}
			if(choixPol==3){
				setPolarisation("gauche");
				}
			if(choixPol==4){
				setPolarisation("droite");
				}
			}
		if(choix ==6){

				System.out.println("Ajouter/remplacer un pylone (entrer id du pylone");
				setPylonesConnect(add.nextLine());
			
		}
		if(choix ==7){
			System.out.println("Choisir le type d'antenne :");
			System.out.println("1. Omnidirectionelle ");
			System.out.println("2. Directive ");
			int choixPol = add.nextInt();
			if(choixPol==1){
				setTypeAntenne("omnidirectionelle");
				}
			if(choixPol==2){
				setPolarisation("directive");
				}
			}
	}
		
		
	public HashMap caracteristiqueAntenne(){
		HashMap<String, String> liste = new HashMap<String, String>();
		liste.put("idAntenne",idAntenne);
		liste.put("gain",Float.toString(gain));
		liste.put("frequence",Float.toString(frequence));
		liste.put("puissance",Float.toString(puissance));
		liste.put("sensibilite",Float.toString(sensibilite));
		liste.put("polarisation",polarisation);
		liste.put("typeAntenne",typeAntenne);
		return liste;
		}
	}
