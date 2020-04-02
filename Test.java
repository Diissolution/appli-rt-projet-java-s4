package appliRT;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
	
	 public void methodeTest() {

	 }
	
	 public static void main(String[] args) {
		 
		 String ab = "salut";
		 String cd = "test";
		 
		 ConvDist test = new ConvDist();
		 AntenneDirective direct = new AntenneDirective();
		 
		 System.out.println(test.angle(43.619679,7.058884,43.640010, 7.076146));
		 float distance = test.distance(43.619679,7.058884,43.640010, 7.076146);
		 System.out.println("distance arrondie ? en m = "+distance);
		 
		 //création antenne 1
		 	double frequenceA = 50 * Math.pow(10,6);
		 	System.out.println("frequence1 = "+frequenceA);
			float puissanceA = 63;  //entre 0 et 40 dbm
			float ouvertureA = 60;
			float orientationA = 45;
			String typeA = "directive";
			String polarisationA = "horizontale";
			double lat_A = 43.663875;
			double lon_A = 6.965169;
			
			//création antenne 2
			float sensibiliteB = -120; //entre -30 et -60 dBm                 //estimations : angle entre eux d'à peu prêt 45°
			float ouvertureB = 30;
			float gainB = 20;
			float orientationB = 220;
			String typeB = "directive";
			String polarisationB = "horizontale";
			double lat_B = 43.667814;
			double lon_B =  6.969911;
			
			ConvDist convDist = new ConvDist();
			
			double distAB1 = test.distance(lat_A, lon_A, lat_B, lon_B);
			float distAB = convDist.convertChiffreVirgule(distAB1);
			
			System.out.println("distAB = "+distAB);
			
			System.out.println(direct.comAntenne(5000.0, sensibiliteB, puissanceA, ouvertureA, ouvertureB, polarisationA, polarisationB, frequenceA, gainB, orientationA, orientationB, lat_A, lon_A, lat_B, lon_B));
			
		 
		 File f = new File("DonnéesAntennes.txt");
		 
		 if (!f.exists()) {
			 try {
				 f.createNewFile();
			 }
			 catch (IOException e)
			 {
				 e.printStackTrace();
			 }
		 }
		 try (
			 FileWriter fw = new FileWriter(f,true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw))
			{
			 bw.write(ab+","+cd+","+"\n");
			 bw.close();
		 }
		 catch (IOException e)
		 {
			 e.printStackTrace();
		 }


		 
		 
	 }
}
