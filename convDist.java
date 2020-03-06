public class ConvDist {
	
	public static double convRad (double degres) {
		return (Math.PI*degres)/180;
	}
	
	public static double distance (double lat_a, double lon_a, double lat_b, double lon_b){
		 int rayonTerre = 6378137; //on dit que la Terre est une sphère de rayon 6378km
		
		double convLat_a = convRad(lat_a); //conversion des coordonnées en radian
		double convLon_a = convRad(lon_a);
		double convLat_b = convRad(lat_b);
		double convLon_b = convRad(lon_b);
		
		double distLon = (convLon_b - convLon_a) / 2;
		double distLat = (convLat_b - convLat_a) / 2;
		
		double calc = (Math.sin(distLat) * Math.sin(distLat)) 
		+ Math.cos(convLat_a) * Math.cos(convLat_b) * (Math.sin(distLon) * Math.sin(distLon));
		
		double calc2 = 2 * Math.atan2(Math.sqrt(calc), Math.sqrt(1 - calc));
		
		return (rayonTerre * calc2);
		
	}
  
	public static double angle (double radian){
		return (radian*180)/Math.PI;
	}
	
}
