
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
	
	public boolean comAntenne(double distAB, float sensibiliteB, float puissanceA, float ouvertureA, float ouvertureB, String polarisationA, String polarisationB, float frequence, float gainB, float orientationA, float orientationB,
			double lat_a, double lon_a, double lat_b, double lon_b){
		
		double gainB1;
		
		if (ouvertureB == 360) { //différencie si la 2eme antenne est directive ou omnidirectionnelle
			 gainB1 = gainB;
			
		}else {
			gainB1 = calculGain(ouvertureB);
		}
			
		
		//calcul en fonction de sensibilité, distance et perte de DB
		
		float lambda = (3*10^8) / frequence; //lambda = c/f
		double pr = puissanceA + 20 * Math.log(lambda/(4*Math.PI*distAB)) + calculGain(ouvertureA) + gainB1 + calculPolarisation(polarisationA,polarisationB); //formule du bilan de liaison
		
		//voir doc pour comprend polarisation : http://iutsa.unice.fr/~mgautero/ext/dut/M4210/DocAntennes.pdf
		

		ConvDist anglPyl = new ConvDist();//angle entre les 2 pylones
		
		double anglPylA = anglPyl.angle(lat_b,lon_b,lat_a,lon_a);
		double ouvA = ouvertureA / 2;
		double anglSupA = orientationA + ouvA;
		double anglInfA = orientationA - ouvA;
		if ( anglPylA <= anglSupA && anglPylA >= anglInfA ){
			double anglPylB = anglPyl.angle(lat_b,lon_b,lat_a,lon_a); //angle entre les 2 pylones
			double ouvB = ouvertureB / 2;
			double anglSupB = orientationB + ouvB;
			double anglInfB = orientationB - ouvB;
			if ( anglPylB <= anglSupB && anglPylB >= anglInfB ){
				if(pr >= sensibiliteB) { //comparaison puissance de reception / sensibilité
					return true;
				}else {
					return false;
				}
	
			}else{
				return false;
			}
	
		}else{
			return false;
		}
	
	}
}
