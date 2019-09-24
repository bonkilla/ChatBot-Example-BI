package com.dmd.bi.ejemplo.bi;

public class Procesamiento extends Thread {

	private MensajeJsonIn msgIn;
	private BotGetPropertyValues prop;

	public Procesamiento(MensajeJsonIn msgIn, BotGetPropertyValues prop) {

		this.msgIn = msgIn;
		this.prop = prop;
	}

	public void run() {

		try {
			
			if (msgIn.getText() != null
					&& ((msgIn.getText().length() == 10 && msgIn.getText().equalsIgnoreCase("teclado on"))
							|| (msgIn.getText().length() == 4 && msgIn.getText().equalsIgnoreCase("Menu")))) {
				// Procesamos
				TelegramMsg telMsg = new TelegramMsg(prop);
				telMsg.botActivaTeclado(Integer.parseInt(msgIn.getChat_id()), "Roger");
			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 24 && msgIn.getText().matches("Información Geográfica.?"))) {


				// Procesamos
				
				TelegramMsg telMsg = new TelegramMsg(prop);
				telMsg.botActivaTecladoGeo(Integer.parseInt(msgIn.getChat_id()), "Roger");

			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 10 && msgIn.getText().matches("America.*"))) {


				// Procesamos
								
				ZonaGeo zg = new ZonaGeo(msgIn);
				zg.America();

			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 9 && msgIn.getText().matches("Europa.*"))) {


				// Procesamos
								
				ZonaGeo zg = new ZonaGeo(msgIn);
				zg.Europa();

			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 7 && msgIn.getText().matches("Asia.*"))) {


				// Procesamos
								
				ZonaGeo zg = new ZonaGeo(msgIn);
				zg.Asia();

			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 11 && msgIn.getText().matches("Hombre.*"))) {


				// Procesamos
								
				ZonaSexo zs = new ZonaSexo(msgIn);
				zs.Hombre();

			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 10 && msgIn.getText().matches("Mujer.*"))) {


				// Procesamos
								
				ZonaSexo zs = new ZonaSexo(msgIn);
				zs.Mujer();

			}
			else if (msgIn.getText() != null 
					&& (msgIn.getText().length() == 22 && msgIn.getText().matches(".*Información\\spor\\sSexo.*"))) {


				// Procesamos
				
				TelegramMsg telMsg = new TelegramMsg(prop);
				telMsg.botActivaTecladoSexo(Integer.parseInt(msgIn.getChat_id()), "Roger");

			}
			else if (msgIn.getText() != null
					&& (msgIn.getText().length() == 7 && msgIn.getText().matches("Home .?"))) {

				// Procesamos
				
				TelegramMsg telMsg = new TelegramMsg(prop);
				telMsg.botActivaTeclado(Integer.parseInt(msgIn.getChat_id()), "Roger");

			}

		}
		catch (Exception e)

		{
			System.out.println("Excepcion");
			System.out.println(e.getMessage());
		}

	}

}
