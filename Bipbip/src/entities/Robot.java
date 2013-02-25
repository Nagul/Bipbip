package entities;

import wifi.Communication;
import java.util.ArrayList;

/**
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-22
 */
public class Robot{
	/**
	 * Robot ip address used in local network.
	 */
	private String ip;
	/**
	 * Command list that a robot should execute
	 */
	private ArrayList <Command> commands;

	/**
	 * Class constructor.
	 * @param ip robot ip address
	 */
	public Robot(String ip){
		commands = new ArrayList<Command>();
		this.ip = ip;
	}

	/**
	 * @return ip address of the robot
	 */
	public String getIP(){
		return this.ip;
	}

	/**
	 * @param s IP to set
	 */
	public void setIP(String s){
		this.ip = s;
	}

	/**
	 * @return current list of commands
	 */
	public ArrayList<Command> getCommands(){
		return commands;
	}

	/**
	 * Remove a command from the list of commands.
	 * @param c the command to remove
	 */
	public void remove(Command c){
		commands.remove(c);
	}

	/**
	 * Add a command to execute.
	 * @param c the command to execute
	 * @param position the position of the command in the stack
	 */
	public void addCommand(Command c,int position){
		if (!commands.contains(c)){
			commands.add(position,c);
		}
	}

	/**
	 * Add a command to execute.
	 * @param c the command to execute
	 */
	public void addCommand(Command c){
		if (!commands.contains(c)){
			commands.add(c);
		}
	}

	/**
	 * Get information send by server
	 */
	public String getFeedback(){
		return Communication.getFeedback(this);
	}

	/**
	 * Execute a command
	 * @param c the command to execute
	 * @param seq the position of the command in instructions list
	 */
	public void executeCommand(Command c, int seq){
		Communication.sendCommand(this, c, seq);
	}

	/**
	 * Execute all instructions from the commands list
	 */
	public void executeStack(){
		int i;
		for (i = 0;i < commands.size();i++){
			// i+1 to avoid error case from server
			executeCommand(commands.get(i),i+1);
		}
	}
}
