package com.dmd.bi.ejemplo.bi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TelegramMsg {

	BotGetPropertyValues properties;

	public TelegramMsg(BotGetPropertyValues properties) {
		this.properties = properties;
	}

	public HttpResponse<JsonNode> sendMessage(Integer chatId, String text) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		return Unirest.post(endpoint + token + "/sendMessage").header("accept", "application/json")
				.field("chat_id", chatId).field("text", text).asJson();

	}

	public HttpResponse<JsonNode> sendMessageMarkdown(Integer chatId, String text)
			throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		return Unirest.post(endpoint + token + "/sendMessage").header("accept", "application/json")
				.field("chat_id", chatId).field("parse_mode", "Markdown").field("text", text).asJson();

	}

	public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		return Unirest.post(endpoint + token + "/getUpdates").field("offset", offset).asJson();
	}

	public void botWriting(String string) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		Unirest.post(endpoint + token + "/sendChatAction").header("accept", "application/json").field("chat_id", string)
				.field("action", "typing").asJson();

	}

	public void botSendingPhoto(String string) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		Unirest.post(endpoint + token + "/sendChatAction").header("accept", "application/json").field("chat_id", string)
				.field("action", "upload_photo").asJson();
	}

	public void botActivaTecladoGeo(Integer chatId, String text) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		String key_makeup = "{\"keyboard\": [[\"America 🌎\",\" Europa 🌍\",\"Asia 🌏\"],[\"Home 🔙\"]], \"one_time_keyboard\": false }";

		// 5743670

		Unirest.post(endpoint + token + "/sendMessage").header("accept", "application/json").field("chat_id", chatId)
				.field("text", text).field("reply_markup", key_makeup).asJson();

	}
	
	public void botActivaTecladoSexo(Integer chatId, String text) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		String key_makeup = "{\"keyboard\": [[\"Hombre 👦🏻\",\" Mujer 👩🏼\"],[\"Home 🔙\"]], \"one_time_keyboard\": false }";

		// 5743670

		Unirest.post(endpoint + token + "/sendMessage").header("accept", "application/json").field("chat_id", chatId)
				.field("text", text).field("reply_markup", key_makeup).asJson();

	}
	
	public void botActivaTeclado(Integer chatId, String text) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		String key_makeup = "{\"keyboard\": [[\"Información Geográfica🛰\",\" Información por Sexo👫\"],[\"Home 🔙\"]], \"one_time_keyboard\": false }";

		// 5743670

		Unirest.post(endpoint + token + "/sendMessage").header("accept", "application/json").field("chat_id", chatId)
				.field("text", text).field("reply_markup", key_makeup).asJson();

	}


	public void botDesactivaTeclado(Integer chatId, String text) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		String key_makeup = "{\"hide_keyboard\": true}";

		// 5743670

		Unirest.post(endpoint + token + "/sendMessage").header("accept", "application/json").field("chat_id", chatId)
				.field("text", text).field("reply_markup", key_makeup).asJson();

	}

	// SUBIR FOTO

	public JSONObject sendDocument(Integer chat_id, File f1) throws UnirestException, IOException {

		String endpoint = properties.getPropValues("endpoint");
		String token = properties.getPropValues("token");

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			HttpPost httppost = new HttpPost(endpoint + token + "/sendPhoto");
			FileBody fb = new FileBody(f1);
			builder.addTextBody("chat_id", chat_id.toString());
			builder.addPart("photo", fb);
			HttpEntity multipart = builder.build();
			httppost.setEntity(multipart);
			CloseableHttpResponse response = httpclient.execute(httppost);
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()), 65728);
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			JSONObject ret = new JSONObject(sb.toString());

			httpclient.close();
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



}
