public class ConvDist {
	
	public double convRad (double degres) {
		return (Math.PI*degres)/180;
	}
	
	public double convAngle (double rad) {
		double math = (rad*180)/Math.PI;
			if (math<0) {
				math = 360 + math;
			}
		return math;
	}
	
	public double distance (double lat_a, double lon_a, double lat_b, double lon_b){
		 int rayonTerre = 6378137; //on dit que la Terre est une sphère de rayon 6378km
		DecimalFormat df = new DecimalFormat("########.000"); //afficher 3 chiffres apres la virgule
		
		double convLat_a = convRad(lat_a); //conversion des coordonnées en radian
		double convLon_a = convRad(lon_a);
		double convLat_b = convRad(lat_b);
		double convLon_b = convRad(lon_b);
		
		double distLon = (convLon_b - convLon_a) / 2;
		double distLat = (convLat_b - convLat_a) / 2;
		
		double calc = (Math.sin(distLat) * Math.sin(distLat)) 
		+ Math.cos(convLat_a) * Math.cos(convLat_b) * (Math.sin(distLon) * Math.sin(distLon));
		
		double calc2 = 2 * Math.atan2(Math.sqrt(calc), Math.sqrt(1 - calc));
		
		double distance = rayonTerre * calc2;
		
		String distanceStr = df.format(distance);
		String[] mort1 = distanceStr.split(",");// on enleve la "," car ce n'est pas reconnu en tant que float
		String mort2 = mort1[0] +"."+ mort1[1]; //on met un "." pour que ce soit reconnue comme une virgule de float
		//System.out.println("valeur mort2 =  "+mort2);
		float distanceFl = Float.parseFloat(mort2);
		
		return (distanceFl);
		
	}
	
	public double angle (double lat_a, double lon_a, double lat_b, double lon_b){
		double angle;
		angle =  Math.atan2(lat_b-lat_a, lon_b-lon_a);
		return convAngle(angle);
	}
	
}
