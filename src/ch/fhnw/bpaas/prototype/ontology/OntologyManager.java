package ch.fhnw.bpaas.prototype.ontology;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import ch.fhnw.bpaas.prototype.GlobalVariable;

public class OntologyManager {

	private OntModel rdfModel;
	
//	//Workaround: will be replaced by SPIN Rules
//	@Deprecated
//	private InfModel inferedModel;

	public OntologyManager() {
		rdfModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		setNamespaces(rdfModel);
		readExistingModels();
	}

	private void readExistingModels() {
		for(ONTOLOGY ontology : ONTOLOGY.values()){
			rdfModel.read(ontology.getRemoteURL(),	ontology.getFormat());
		}
//		rdfModel.read("/Users/ben/Documents/workspaces2/master/CloudSocketAlignmentPrototype/ontologies/bpaasrules.ttl", "TTL");
		printToFile(rdfModel, GlobalVariable.INITIALMODEL);
	}

	public void setNamespaces(OntModel model) {
		for (NAMESPACE ns : NAMESPACE.values()) {
			model.setNsPrefix(ns.getPrefix(), ns.getURI());
		}
	}

	public ResultSet query(ParameterizedSparqlString queryStr) {
		addNamespacesToQuery(queryStr);

		System.out.println(queryStr.toString());

		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, rdfModel);
//		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		
		return qexec.execSelect();
	}

	private void addNamespacesToQuery(ParameterizedSparqlString queryStr) {
		for (NAMESPACE ns : NAMESPACE.values()) {
			queryStr.setNsPrefix(ns.getPrefix(), ns.getURI());
		}
	}

	public void addTransformedData(OntModel value) {
		rdfModel.add(value);
		printToFile(rdfModel, GlobalVariable.TRANSFORMEDMODEL);
	}

	public void printToFile(Model model, String FILENAME) {
		try {
			RDFDataMgr.write(new FileOutputStream(new File(FILENAME)), model, Lang.TTL) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public OntModel getModel() {
		return rdfModel;
	}

//	//Workaround: will be replaced by SPIN Rules
//	@Deprecated
//	public void setInfModel(InfModel inferedModel) {
//		this.inferedModel = inferedModel;
//	}
}
