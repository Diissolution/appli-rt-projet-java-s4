
public class AntenneDirective extends Antenne {
	
	ConvDist convDist = new ConvDist();
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
		//System.out.println("valeur de x = "+x);
		//System.out.println("valeur de (x * 34)/175 = "+ (x*34)/175);
		float calc1 = convDist.convertChiffreVirgule((x * 34)/175);
		//System.out.println("valeur de multi = "+calc1);
		//System.out.println("valeur de calc = "+calc);
		return 6 + calc1; //retourne la valeur du gain en fonction de la valeur de l'ouverture
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
	
	public boolean comAntenne(double distAB, float sensibiliteB, float puissanceA, float ouvertureA, float ouvertureB, String polarisationA, String polarisationB, double frequence, float gainB, float orientationA, float orientationB,
			double lat_a, double lon_a, double lat_b, double lon_b){
		
		double gainB1;
		
		if (ouvertureB == 360) { //différencie si la 2eme antenne est directive ou omnidirectionnelle
			 gainB1 = gainB;
			
		}else {
			gainB1 = calculGain(ouvertureB);
		}
			
		
		//calcul en fonction de sensibilité, distance et perte de DB
		
		double lambda = (3*Math.pow(10,8)) / frequence; //lambda = c/f
		//System.out.println("valeur lambda = "+lambda);
		double pr = puissanceA + 20 * Math.log(lambda/(4*Math.PI*distAB)) + calculGain(ouvertureA) + gainB1 + calculPolarisation(polarisationA,polarisationB); //formule du bilan de liaison
		//double pr2 = (calculGain(ouvertureA) * gainB1 * (lambda/(4*Math.PI*distAB)) * (lambda/(4*Math.PI*distAB))) * puissanceA;
		//System.out.println("valeur puissance emissions = "+pr);
		//System.out.println("valeur puissance A = "+puissanceA);
		//System.out.println("valeur (lambda/(4*Math.PI*distAB)) = "+(lambda/(4*Math.PI*distAB)));
		//System.out.println("valeur dist = "+distAB);
		//System.out.println("valeur puissance reception site = "+pr2);
		//System.out.println("valeur de gainB1 = "+gainB1);
		//System.out.println("valeur gainA (calc) = "+calculGain(ouvertureA));
		//System.out.println("valeur calculPolarisation = "+ calculPolarisation(polarisationA,polarisationB));
		//voir doc pour comprend polarisation : http://iutsa.unice.fr/~mgautero/ext/dut/M4210/DocAntennes.pdf
		

		ConvDist anglPyl = new ConvDist();//angle entre les 2 pylones
		
		double anglPylA = anglPyl.angle(lat_a,lon_a,lat_b,lon_b);
		//System.out.println("valeur de l'angle entre A et B = "+anglPylA);
		double ouvA = ouvertureA / 2;
		//System.out.println("valeur de l'ouverture/2 A = "+ouvA);
		double anglSupA = orientationA + ouvA;
		//System.out.println("valeur de l'angle superieur A = "+anglSupA);
		double anglInfA = orientationA - ouvA;
		//System.out.println("valeur de l'angle inferieur A = "+anglInfA);
		if ( anglPylA <= anglSupA && anglPylA >= anglInfA ){
			double anglPylB = anglPyl.angle(lat_b,lon_b,lat_a,lon_a); //angle entre les 2 pylones
			//System.out.println("valeur de l'angle entre B et A = "+anglPylB);
			double ouvB = ouvertureB / 2;
			//System.out.println("valeur de l'ouverture/2 B = "+ouvB);
			double anglSupB = orientationB + ouvB;
			//System.out.println("valeur de l'angle superieur B = "+anglSupB);
			double anglInfB = orientationB - ouvB;
			//System.out.println("valeur de l'angle inferieur B = "+anglInfB);
			if ( anglPylB <= anglSupB && anglPylB >= anglInfB ){
				if(pr >= sensibiliteB) { //comparaison puissance de reception / sensibilité
					System.out.println("Puissance d'émission = "+pr);
					System.out.println("la sensibilité = "+sensibiliteB);
					return true;
				}else {
					System.out.println("Puissance d'émission plus faible que la sensibilité");
					System.out.println("Puissance d'émission = "+pr);
					System.out.println("la sensibilité = "+sensibiliteB);
					return false;
				}
	
			}else{
				System.out.println("Le pylone B ne peut pas communiquer avec le pylone A");
				return false;
			}
	
		}else{
			System.out.println("Le pylone A ne peut pas communiquer avec le pylone B");
			return false;
		}
	
	}
}
