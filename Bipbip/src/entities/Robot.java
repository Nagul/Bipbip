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
	 */
	public Robot(){
		commands = new ArrayList<Command>();
		ip = "";
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
	 */
	public void addCommand(Command c){
		if (!commands.contains(c)){
			if (c.getTarget() != null) c.getTarget().remove(c);
			c.setTarget(this);
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
	 * @param seq the sequence place (TODO translate : quelle place dans la pile d'instructions)
	 */
	public void executeCommand(Command c, int seq){
		Communication.sendCommand(this, c, seq);
	}

	/**
	 * Execute all instructions from the commands list
	 */
	public void executeStack(){
		// TODO for each command in commands do : executeCommand(command,seq) end
	}
}
