package simulaSAAB.modeloSimulacion.comunicacion;

import java.util.Date;

import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;

public class MensajeACL {
	
	private static int SecuenciaId;
	
	private final int Conversacionid;
	
	private String Encoding;
	
	private String InReplyTo;
	
	private String Language;
	
	private String Ontology;
	
	private String Performative;
	
	private String Protocol;
	
	private Date ReplyBy;
	
	private int ReplyTo;
	
	private String ReplyWith;
	
	private AgenteSaab Sender;
	
	private AgenteSaab Receiver;
	
	private Preposicion Content;
	
	
	/**
	 * @return the content
	 */
	public Preposicion getContent() {
		return Content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(Preposicion content) {
		Content = content;
	}

	/**
	 * Constructor
	 */
	public MensajeACL(){
		Conversacionid =SecuenciaId+1;
		SecuenciaId++;
	}

	public int getConversacionid() {
		return Conversacionid;
	}
	

	public String getEncoding() {
		return Encoding;
	}

	public void setEncoding(String encoding) {
		Encoding = encoding;
	}

	public String getInReplyTo() {
		return InReplyTo;
	}

	public void setInReplyTo(String inReplyTo) {
		InReplyTo = inReplyTo;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getOntology() {
		return Ontology;
	}

	public void setOntology(String ontology) {
		Ontology = ontology;
	}

	public String getPerformative() {
		return Performative;
	}

	public void setPerformative(String performative) {
		Performative = performative;
	}

	public String getProtocol() {
		return Protocol;
	}

	public void setProtocol(String protocol) {
		Protocol = protocol;
	}

	public Date getReplyBy() {
		return ReplyBy;
	}

	public void setReplyBy(Date replyBy) {
		ReplyBy = replyBy;
	}

	public int getReplyTo() {
		return ReplyTo;
	}

	public void setReplyTo(int replyTo) {
		ReplyTo = replyTo;
	}

	public String getReplyWith() {
		return ReplyWith;
	}

	public void setReplyWith(String replyWith) {
		ReplyWith = replyWith;
	}

	public AgenteSaab getSender() {
		return Sender;
	}

	public void setSender(AgenteSaab sender) {
		Sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public AgenteSaab getReceiver() {
		return Receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(AgenteSaab receiver) {
		Receiver = receiver;
	}
	
	

}
