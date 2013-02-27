package entities;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.String;

import wifi.Communication;

public class TestRobot{
	public static void main(String args[]){
		// creation du robot
		Robot r = new Robot("192.168.0.36");

		// creation de la commande
		Command c = new Command();
		c.setAction(Command.FORWARD);

		// creation des parametres et ajout a la commande c
		//c.addParameter(new Parameter("dista",200),0);
		//c.addParameter(new Parameter("speed",75),1);

		// creation d'une deuxieme commande
		Command c2 = new Command();
		c2.setAction(Command.FEEDBACK);

		// ajout d'un parametre a cette commande
		//c2.addParameter(new Parameter("angle",90),0);
		//c2.addParameter(new Parameter("speed",30),1);
		
		// creation d'une deuxieme commande
		Command c3 = new Command();
		c3.setAction(Command.FORWARD);

		//// ajout d'un parametre a cette commande
		//c3.addParameter(new Parameter("time",4000),0);
		//c3.addParameter(new Parameter("speed",40),1);
		  
		Command c5 = new Command();
		c5.setAction(Command.FEEDBACK);

		Command c4 = new Command();
		c4.setAction(Command.STOP);

		// ajout des commandes dans la liste des commandes a effectuer par le robot
		r.addCommand(c,0);
		r.addCommand(c2,1);
		r.addCommand(c3,2);
		r.addCommand(c5,3);
		r.addCommand(c4,4);
		 
		// execution des commandes par le robot
		r.executeStack();

		// Méthode pour traiter les Feedback 
		String log = r.getFeedback();
		String[] tmp = log.split("<br/>");
		for (int i = 0; i < tmp.length; i++){
			Feedback f = new Feedback(tmp[i]);
			System.out.println(f.getAction()+f.getDate()+f.getDetails());
		}

		
		// Méthode pour stocker les logs dans le fichier log.txt
		String fileName = "log.txt";
		String filePath = System.getProperty("user.dir")+"/"+fileName;
		log = log.replaceAll("<br/>","\n");
		try{
			FileWriter fw = new FileWriter(filePath,true);
			BufferedWriter output = new BufferedWriter(fw);
			output.write(log);
			output.flush();
			output.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		// Test de la suppression des commandes
		r.clearCommands();

		// Test de l'affichage des robots connectés
		String[] robotList = Communication.getOnlineRobots();
		for (int j = 0;j < robotList.length; j++){
			System.out.println(robotList[j]);
		}

	}



}
