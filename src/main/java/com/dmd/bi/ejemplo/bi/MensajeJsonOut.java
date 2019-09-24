package com.dmd.bi.ejemplo.bi;

import com.mashape.unirest.http.JsonNode;

public class MensajeJsonOut {

	
	private String text,message_id, date, from_id, from_firstname, from_lastname, from_username, chat_id, chat_firstname, chat_lastname, chat_username, ok;
	
	public MensajeJsonOut(JsonNode msg){
		
		
		
		if(!msg.getObject().isNull("ok")) this.setOk(msg.getObject().get("ok").toString());
		
		JsonNode result = new JsonNode(msg.getObject().get("result").toString());
		
		if(!result.getObject().isNull("message_id")) this.setMessage_id(result.getObject().get("message_id").toString());
		
		if(!result.getObject().isNull("date")) this.setDate(result.getObject().get("date").toString());
		
		if(!result.getObject().isNull("text")) this.setText(result.getObject().get("text").toString());
		
		
		
		JsonNode from = new JsonNode(result.getObject().get("from").toString());
		
		if(!from.getObject().isNull("id")) this.setFrom_id(from.getObject().get("id").toString());
		
		if(!from.getObject().isNull("first_name")) this.setFrom_firstname(from.getObject().get("first_name").toString());
		
		if(!from.getObject().isNull("last_name")) this.setFrom_lastname(from.getObject().get("last_name").toString());
		
		if(!from.getObject().isNull("username")) this.setFrom_username(from.getObject().get("username").toString());
		

		JsonNode chat = new JsonNode(result.getObject().get("chat").toString());
		
		if(!chat.getObject().isNull("id")) this.setChat_id(chat.getObject().get("id").toString());
		
		if(!chat.getObject().isNull("first_name")) this.setChat_firstname(chat.getObject().get("first_name").toString());
		
		if(!chat.getObject().isNull("last_name")) this.setChat_lastname(chat.getObject().get("last_name").toString());
		
		if(!chat.getObject().isNull("username")) this.setChat_username(chat.getObject().get("username").toString());
    	
		
	}

	public String getFrom_username() {
		return from_username;
	}

	public void setFrom_username(String from_username) {
		this.from_username = from_username;
	}

	public String getChat_firstname() {
		return chat_firstname;
	}

	public void setChat_firstname(String chat_firstname) {
		this.chat_firstname = chat_firstname;
	}

	public String getChat_lastname() {
		return chat_lastname;
	}

	public void setChat_lastname(String chat_lastname) {
		this.chat_lastname = chat_lastname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChat_username() {
		return chat_username;
	}

	public void setChat_username(String chat_username) {
		this.chat_username = chat_username;
	}

	public String getFrom_lastname() {
		return from_lastname;
	}

	public void setFrom_lastname(String from_lastname) {
		this.from_lastname = from_lastname;
	}

	public String getFrom_id() {
		return from_id;
	}

	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFrom_firstname() {
		return from_firstname;
	}

	public void setFrom_firstname(String from_firstname) {
		this.from_firstname = from_firstname;
	}

	public String getChat_id() {
		return chat_id;
	}
	

	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}
	
	
}


