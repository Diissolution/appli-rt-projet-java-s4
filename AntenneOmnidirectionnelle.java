public class AntenneOmnidirectionnelle extends Antenne {

	public AntenneOmnidirectionnelle(){
		super();
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
	
	public boolean comAntenne(double distAB, float sensibiliteB, float puissanceA, float gainA, float gainB, String polarisationA, String polarisationB, float frequence, float ouvertureB){
		
		if (ouvertureB == "NULL") //différencie si la 2eme antenne est directive ou omnidirectionnelle
			float gainB1 = gainB;
		}else{
			float gainB1 = calculGain(ouvertureB);
		}
		
		
		float lambda = (3*10^8) / frequence; //lambda = c/f
		double pr = puissanceA + 20 * Math.log(lambda/4*Math.PI*distAB) + gainA + gainB1 + calculPolarisation(polarisationA,polarisationB); //formule du bilan de liaison
		
	//voir doc pour comprend polarisation : http://iutsa.unice.fr/~mgautero/ext/dut/M4210/DocAntennes.pdf
	
		double anglPylA= ConvDist.angle(double lat_a, double lon_a, double lat_b, double lon_b); //angle entre les 2 pylones
		double ouvA = ouvertureA / 2;
		double anglSupA = orientationA + ouvA;
		double anglInfA = orientationA - ouvA;
		if ( anglPylA <= anglSupA && anglPylA >= anglInfA ){
			double anglPylB = ConvDist.angle(double lat_b, double lon_b, double lat_a, double lon_a); //angle entre les 2 pylones
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
