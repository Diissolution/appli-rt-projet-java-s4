public class AntenneDirective extends Antenne {
	super();
	
	float orientation;
	float ouverture;
	
	public float setOrientation (float orientation){
		this.orientation = orientation;
	}
	
	public float setOuverture (float ouvertureA){
		this.ouverture = ouvertureA;
	}
	
	public double calculGain(float ouverture) {
		float x = (180 - ouverture);
		float calc = 6 + x * (34/175); 
		return calc; //retourne la valeur du gain en fonction de la valeur de l'ouverture
	}
	
	public boolean comAntenne(double distAB, float sensibiliteB, float puissanceA, float ouvertureA, float ouvertureB, float polarisationA, float frequence){
	
		//calcul en fonction de sensibilité, distance et perte de DB
		float lambda = (3*10^8) / frequence; //lambda = c/f
		double pr = puissanceA + 20 * Math.log(lambda/(4*Math.PI*distAB)) + calculGain(ouvertureA) + calculGain(ouvertureB) + polarisationA; //formule du bilan de liaison
		
		if(pr >= sensibiliteB) { //comparaison puissance de reception / sensibilité
			return true;
		}else {
			return false;
		}
	}
}
