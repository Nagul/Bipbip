package entities;

/**
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-22
 */
public class Parameter{
	/**
	 * Type of parameter of a command (for instance, speed).
	 */
	private String name;
	/**
	 * Value of the parameter
	 */
	private int value;

	/**
	 * Class constructor.
	 */
	public Parameter(){
	}
	
	/**
	 * Class constructor.
	 * @param n parameter name
	 * @param v parameter value
	 */
	public Parameter(String n, int v){
		name = n;
		value = v;
	}

	/**
	 * @return the name of the parameter
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * @param s name to set
	 */
	public void setName(String s){
		this.name = s;
	}

	/**
	 * @return the value of the parameter
	 */
	public int getValue(){
		return this.value;
	}

	/**
	 * @param i value to set
	 */
	public void setValue(int i){
		this.value = i;
	}

}
