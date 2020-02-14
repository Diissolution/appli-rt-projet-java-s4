public class AntenneOmnidirectionnelle extends Antenne {
	super(); //on récupère les caractéristiques de la classe Antenne
	
	public float ouverture = 180; //au cas ou une antenne directive doit calculer si elle peut communiquer avec une antenne omnidirectionnelle
	
	public boolean comAntenne(double distAB, float sensibiliteB, float puissanceA, float gainA, float gainB, float polarisationA, float frequence){

	float lambda = (3*10^8) / frequence; //lambda = c/f
	double pr = puissanceA + 20 * Math.log(lambda/4*Math.PI*distAB) + gainA + gainB + polarisationA; //formule du bilan de liaison
	
	if(pr >= sensibiliteB) { //comparaison puissance de reception / sensibilité
		return true;
	}else {
		return false;
	}
	
	}
}
