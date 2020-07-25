package cucumber;

import java.util.HashMap;
import java.util.Map;
import enums.Context;

/**
 * <p>
 * Initializes and manages various {@link Enum} specific to the running scenario<br>
 * Valid for a single scenario run lifecycle
 * </p>
 * @author Akashdeep Singh
 */
public class ScenarioContext {

	private  Map<String, Object> scenarioContext;

	/**
	 * <p>
	 * <b>Class Constructor : </b><br>
	 * -  Initializes the {@link Map} Interface reference variable as a {@link HashMap} implementation<br>
	 * -  <b>Key</b> for {@link HashMap} is set as type {@link String}<br>
	 * -  <b>Value</b> for {@link HashMap} is set as {@link Object} which can be used suitably by <b>Typecasting</b><br>
	 * </p>
	 */
	public ScenarioContext(){
		scenarioContext = new HashMap<>();
	}

	/**
	 * <p>
	 * Sets the Key value pair in the {@link HashMap}
	 * </p>
	 * @param key is of the type {@link String}
	 * @param value is of the type {@link Object}
	 */
	public void setContext(Context key, Object value) {
		scenarioContext.put(key.toString(), value);
	}

	/**
	 * <p>
	 * Retrieves the value for the provided key
	 * </p> 
	 * @param key whose value is to be retrieved
	 * @return the value of the key as an {@link Object} 
	 */
	public Object getContext(Context key){
		return scenarioContext.get(key.toString());
	}

	/**
	 * <p>
	 * Returns true if this map contains a mapping for the specifiedkey. More formally, returns true if and only ifthis map contains a mapping for a key k such that Objects.equals(key, k). (There can beat most one such mapping.)
	 * </p>
	 * @param key - key whose presence in this map is to be tested 
	 * @return true if this map contains a mapping for the specifiedkey
	 */
	public Boolean isContains(Context key){
		return scenarioContext.containsKey(key.toString());
	}

}