package ch.fhnw.bpaas.prototype.ontology;

public enum FilterAttributes {
	
	hasAvailabilityInPercent 							("http://ikm-group.ch/archimeo/bpaas#hasAvailabilityInPercent",				"?availabilityValue",	"?availabilityValue >= {0}"),
	hasResponseTime	("http://ikm-group.ch/archimeo/bpaas#hasResponseTime",	"?responseTime", 				"?responseTime >= {0}"), //@Ben: hasResponseTime has type "data"
	hasSimultaneousUsers	("http://ikm-group.ch/archimeo/bpaas#hasSimultaneousUsers",	"?cpisu", 				"?cpisu >= {0}"),
	hasDataStorage	("http://ikm-group.ch/archimeo/bpaas#hasDataStorage",	"?dataStorage", 				"?dataStorage >= {0}"),
	hasBackupType	("http://ikm-group.ch/archimeo/bpaas#hasBackupType",	"?backuptype", 				"?backuptype = {0}"); //to riconsider
	
	private String property;
	private String variable;
	private String comparison;

	FilterAttributes(String property, String variable, String comparison) {
		this.property = property;
		this.variable = variable;
		this.comparison = comparison;
	}
	
	public String toString(){
		return property;
	}
	
	public static boolean contains(String test) {
	    for (FilterAttributes c : FilterAttributes.values()) {
	        if (c.toString().equals(test)) {
	            return true;
	        }
	    }
	    return false;
	}

	public static FilterAttributes get(String test) {
		for (FilterAttributes c : FilterAttributes.values()) {
	        if (c.toString().equals(test)) {
	            return c;
	        }
	    }
	    return null;
	}

	public String getVariable() {
		return variable;
	}

	public String getComparison() {
		return comparison;
	}
}
