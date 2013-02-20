package wifi;

import java.util.Scanner;

/**
 * Test the Communication class with some URLs 
 */
class CommunicationTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x;
		do{
  			x=sc.nextInt();
			//Communication.excutePost("http://127.0.0.1/projetbip/giveorder.php?action="+x);
			//System.out.println(Communication.executePost("http://192.168.0.35/projetbip/giveorder.php?target=192.168.0.36&action="+x));
			//System.out.println(Communication.executePost("http://192.168.0.35/projetbip/getorder.php?target=192.168.0.3"+x));
			System.out.println(Communication.executePost("http://127.0.0.1/projetbip/getfeedback.php?target=192.168.0.36"));
		}while(true);
	}


}
