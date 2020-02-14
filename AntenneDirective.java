public class AntenneDirective extends Antennes {
	
	super();
	
	float orientation;
	float ouverture;
	
	public float setOrientation (float orientation){
		this.orientation = orientation;
	}
	
	public float setOuverture (float ouverture){
		this.ouverture = ouverture;
	}
	
	public boolean comAntenne(){
		//calcul en fonction de sensibilité, distance et perte de DB
	}
}
