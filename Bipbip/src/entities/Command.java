package entities;

import java.util.ArrayList;

/**
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-22
 */
public class Command{
	/**
	 * Name of the function to call
	 */
	private String name;
	/**
	 * Robot which will execute the command
	 */
	private Robot target;
	/**
	 * Function parameters. They have to be sorted in the same order as in the NXC function
	 */
	private ArrayList<Parameter> parameters;

	/**
	 * Class constructor.
	 */
	public Command(){
		parameters = new ArrayList<Parameter>();
	}

	/**
	 * @return current parameters of the function
	 */
	public ArrayList<Parameter> getParameters(){
		return parameters;
	}

	/** 
	 * @param p parameter to remove
	 */
	public void remove(Parameter p){
		parameters.remove(p);
	}

	/**
	 * Add a parameter to the function.
	 * @param p parameter to add
	 */
	public void addParameter(Parameter p){
		if(!parameters.contains(p)){
			parameters.add(p);
		}
	}

	/**
	 * @return the target robot of the command
	 */
	public Robot getTarget(){
		return target;
	}

	/**
	 * @param r the target robot 
	 */
	public void setTarget(Robot r){
		this.target = r;
	}

	/**
	 * Add command to the robot list of commands.
	 * @param r target robot
	 */
	public void addRobot(Robot r){
		if (r != null){
			if (!r.getCommands().contains(this)){
				if (target != null)  target.remove(this);
				this.setTarget(r);
				target.getCommands().add(this);
			}
		}
	}

}
