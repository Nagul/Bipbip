package wifi;

import java.net.URL;
import java.net.HttpURLConnection;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.lang.String;

import entities.Robot;
import entities.Command;

/**
 * Class which provides methods to communicate with the server.
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-20
 */
public class Communication{

	public static final String serverRoot = "http://127.0.0.1";

	/**
	 * Do a post request to the server.
	 * @param targetURL absolute URL of a resource 
	 */
	public static String executePost(String targetURL)
	{
		URL url;
		HttpURLConnection connection = null;  
		try {
			//Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection)url.openConnection();

			connection.setUseCaches (false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			//Send request
			DataOutputStream wr = new DataOutputStream ( connection.getOutputStream ());
			wr.flush ();
			wr.close ();

			//Get Response	
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer(); 
			while((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if(connection != null) {
				connection.disconnect(); 
			}
		}
	}

	/**
	 * Send request to receive information about a robot from the server.
	 * @param r the robot that is sending information
	 * @return a string containing data
	 */
	public static String getFeedback(Robot r){
		String result = executePost(serverRoot+"/getfeedback.php?target="+r.getIP());
		return result;
	}

	/**
	 * Send a command to a robot.
	 * @param r the robot receiving the order
	 * @param c the command to execute
	 * @param seq the position of the command in instructions list
	 */
	public static void sendCommand(Robot r, Command c,int seq){
		executePost(serverRoot+"/giveorder.php?target="+r.getIP()+"&action="+c.getAction()+c.paramsToString()+"&seq="+seq);
	}

	/**
	 * Removes all of the commands for a robot from the server.
	 * @param r the target robot
	 */
	public static void clearCommands(Robot r){
		executePost(serverRoot+"/deleteorder.php?target="+r.getIP());
	}

	/**
	 * Get a list of online robots. 
	 * @return a list of ip addresses of online robots.
	 */
	public static String[] getOnlineRobots(){
		String robotsIp = executePost(serverRoot+"/getrobotsip.php");
		return robotsIp.split("<br/>");
	}

}
