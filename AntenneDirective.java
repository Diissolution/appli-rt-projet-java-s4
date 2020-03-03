public class AntenneDirective extends Antenne {
	
	float orientation;
	float ouverture;
	
	public AntenneDirective (){
		super();
	}
	
	public void setOrientation (float orientation){
		this.orientation = orientation;
	}
	
	public void setOuverture (float ouvertureA){
		this.ouverture = ouvertureA;
	}
	
	public double calculGain(float ouverture) { //methode calcul de gain
		float x = (180 - ouverture);
		float calc = 6 + x * (34/175); 
		return calc; //retourne la valeur du gain en fonction de la valeur de l'ouverture
	}
	
	public int calculPolarisation(String polarisationA, String polarisationB){
		int polarisationAB;
		
		if (polarisationA == polarisationB){
			polarisationAB = 0;
			
		}else if( (polarisationA == "horizontale" || polarisationA == "verticale") && (polarisationB == "gauche" || polarisationB == "droite") ){
			polarisationAB = 3;
			
		}else if( (polarisationA == "gauche" || polarisationA == "droite") && (polarisationB == "horizontale" || polarisationB == "verticale") ){
			polarisationAB = 3;
			
		}else{
			polarisationAB = -30;
		}
		
		return polarisationAB;
	}
	
	public boolean comAntenne(double distAB, float sensibiliteB, float puissanceA, float ouvertureA, float ouvertureB, String polarisationA, String polarisationB, float frequence){
	
		//calcul en fonction de sensibilité, distance et perte de DB
		
		float lambda = (3*10^8) / frequence; //lambda = c/f
		double pr = puissanceA + 20 * Math.log(lambda/(4*Math.PI*distAB)) + calculGain(ouvertureA) + calculGain(ouvertureB) + calculPolarisation(polarisationA,polarisationB); //formule du bilan de liaison
		
		//voir doc pour comprend polarisation : http://iutsa.unice.fr/~mgautero/ext/dut/M4210/DocAntennes.pdf
		
		if(pr >= sensibiliteB) { //comparaison puissance de reception / sensibilité
			return true;
		}else {
			return false;
		}
	}
}
