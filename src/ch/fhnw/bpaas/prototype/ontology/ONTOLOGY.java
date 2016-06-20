package ch.fhnw.bpaas.prototype.ontology;

public enum ONTOLOGY {
	BPAAS	("bpaas",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/bpaas.ttl",			"/Users/ben/Documents/workspaces2/master/CloudSocketAlignmentPrototype/ontologies/bpaas.ttl"),
	BPAASRULES	("bpaas",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/bpaasrules.ttl",			"/Users/ben/Documents/workspaces2/master/CloudSocketAlignmentPrototype/ontologies/bpaasrules.ttl"),
	APQC	("apcq",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/apqc.ttl",				"/Users/ben/Documents/workspaces2/master/CloudSocketAlignmentPrototype/ontologies/apqc.ttl"),
	FBPDO	("fbpdo",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/fbpdo.ttl",			"/Users/ben/Documents/workspaces2/master/CloudSocketAlignmentPrototype/ontologies/fbpdo.ttl"),
	TOP		("top",		"TTL",	"https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/TOP/TOP.ttl",									"/Users/ben/Documents/workspaces/TopBraid/CloudSocket2/ARCHIMEO/TOP/TOP.ttl"),
	EO		("eo",		"TTL", 	"https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/EO/EO.ttl", 									"/Users/ben/Documents/workspaces/TopBraid/CloudSocket2/ARCHIMEO/EO/EO.ttl");

	private String prefix;
	private String format;
	private String remoteURL;
	private String localURL;

	ONTOLOGY(String prefix, String format, String remoteURL, String localURL) {
		this.prefix = prefix;
		this.format = format;
		this.remoteURL = remoteURL;
		this.localURL = localURL;
	}

	public String getRemoteURL() {
		return remoteURL;
	}

	public String getFormat() {
		return format;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getLocalURL() {
		return localURL;
	}	

}
