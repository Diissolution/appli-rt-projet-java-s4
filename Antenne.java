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
	ArrayList<String> pylonesConnect = new ArrayList<String>();
	
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
				
	public ArrayList<String> getPylonesConnect(){
		return pylonesConnect;
		}

				
				
				//modificateur en ecriture
				
				
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
				
	public void addPylonesConnect(String idPylone){
		pylonesConnect.add(idPylone);
		}
	
	public void delPylonesConnect(int num){
		pylonesConnect.remove(num);
		}
	
		
	public void modifier(){
		int in=1;
		while(in==1) {
		System.out.println("1. gain");
		System.out.println("2. frequence");
		System.out.println("3. puissance");
		System.out.println("4. sensibilite");
		System.out.println("5. polarisation");
		System.out.println("6. pylonesConnect");
		System.out.println("7. quiter");
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
			int choixPyl = add.nextInt();
			System.out.println("1. Supprimer");
			System.out.println("2. Ajouter");
			int choixSupp = add.nextInt();
			if(choixPyl==1){
				for (int i=0;i<pylonesConnect.size();i++){
				
					System.out.println(i+". "+pylonesConnect.get(i));
					}
				for (int i=0;i<pylonesConnect.size();i++){
					if(choixSupp == i){
						delPylonesConnect(i);
						}
					}
				}
			if(choixPyl==2){
				System.out.println("Ajouter un pylone (entrer id du pylone");
				addPylonesConnect(add.nextLine());
			}
		}
		if(choix ==7){
			in=0;
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
		return liste;
		}
	}
