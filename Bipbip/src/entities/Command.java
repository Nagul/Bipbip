package entities;

import java.util.ArrayList;

/**
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-22
 */
public class Command{

	/*
	 * list of id of commands which are defined in the NXC program
	 */
	public static final int NONE        = 0;
	public static final int FORWARD     = 1;
	public static final int TURN        = 2;
	public static final int FOLLOW_WALL = 3;
	public static final int CROSSING    = 4;
	public static final int FEEDBACK    = 5;
	public static final int STOP        = 6;
        public static final int TEST        = 7;
        public static final int FIND_CORNER = 8;

	/**
	 * id of the function to call
	 */
	private int action;

	/**
	 * Function parameters. They have to be sorted in the same order as in the NXC function
	 */
	private ArrayList<Parameter> parameters;

	/**
	 * Class constructor.
	 */
	public Command(){
		action = NONE;
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
	 * @param position position in the function definition
	 */
	public void addParameter(Parameter p, int position){
		if(!parameters.contains(p)){
			parameters.add(position,p);
		}
	}

	/**
	 * Add command to the robot list of commands.
	 * @param r target robot
	 */
	public void addRobot(Robot r){
		if (r != null){
			if (!r.getCommands().contains(this)){
				r.getCommands().add(this);
			}
		}
	}
	
	/**
	 * @param a action id to set
	 */
	public void setAction(int a){
		this.action = a;
	}
	 
	/**
	 * @return current command id
	 */
	public int getAction(){
		return this.action;
	}

	/**
	 * @return parameters in URL format
	 */
	public String paramsToString(){
		String result = "";
		int i;
		for (i = 0;i < parameters.size();i++){
			int asc = 97+i;
			result += "&"+Character.toString((char)asc)+"="+parameters.get(i).getValue();
		}
		return result;
	}

}
