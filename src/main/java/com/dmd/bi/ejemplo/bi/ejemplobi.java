package com.dmd.bi.ejemplo.bi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;



import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * 
 */

/**
 * @author david
 *
 */
public class ejemplobi {

	public void run() throws UnirestException, InterruptedException, IOException, SQLException {
		int last_update_id = 0; // last processed command

		BotGetPropertyValues properties = BotGetPropertyValues.getInstance();
		TelegramMsg telMsg = new TelegramMsg(properties);

		HttpResponse<JsonNode> response = null;
		while (true) {
			Thread.sleep(100);
			try {
				response = telMsg.getUpdates(last_update_id);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Atencion");
			}

			if (response != null && response.getStatus() == 200) {

				JSONArray responses = response.getBody().getObject().getJSONArray("result");
				if (responses.isNull(0))
					continue;
				else
					last_update_id = responses.getJSONObject(responses.length() - 1).getInt("update_id") + 1;

				;

				for (int i = 0; i < responses.length(); i++) {

					JsonNode nodo = new JsonNode(
							response.getBody().getObject().getJSONArray("result").get(i).toString());

					
					// Mensaje
					try{
						JsonNode mensaje = new JsonNode(nodo.getObject().get("message").toString());
						MensajeJsonIn msgJson = new MensajeJsonIn(mensaje);
						Procesamiento proc = new Procesamiento(msgJson, properties);
						proc.start();
					}
					catch(Exception e){
						System.out.println("Error en el trato de mensaje");
					}

					

				}

			}
		}
	}

	public static void main(String[] args) throws RemoteException, IOException, UnirestException,
			InterruptedException, SQLException {

		/*
		 * TimerTask tasknew = new TimerScheduleFixedRate(); Timer timer = new
		 * Timer();
		 * 
		 * // scheduling the task at fixed rate
		 * timer.scheduleAtFixedRate(tasknew,new Date(),1000); } // this method
		 * performs the task public void run() { System.out.println(
		 * "working at fixed rate");
		 */
		//Timer timer = new Timer();

		// ES ASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ES ASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ES ASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ES ASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ES ASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ES ASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// timer.scheduleAtFixedRate(task, firstTime, period);

		System.out.println("***************************************");
		System.out.println("**********START BOT VY****************");
		System.out.println("***************************************");

		ejemplobi bot = new ejemplobi();
		bot.run();

	}
}
