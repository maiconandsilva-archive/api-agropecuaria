package main;

import java.util.HashMap;
import java.util.Map;


public class Config {
	private static Map<String, String> config = new HashMap<>();

    /** System wide Configuration */
	public static String get(String key) {
		return config.get(key);
	}
}
