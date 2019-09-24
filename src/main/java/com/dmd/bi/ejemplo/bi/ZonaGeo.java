package com.dmd.bi.ejemplo.bi;




import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import com.mashape.unirest.http.exceptions.UnirestException;

public class ZonaGeo {

	private MensajeJsonIn msgIn;

	public ZonaGeo(MensajeJsonIn in) {
		this.msgIn = in;
	}

	public void America() throws UnirestException, IOException, ClassNotFoundException {

		BotGetPropertyValues prop = BotGetPropertyValues.getInstance();
		TelegramMsg telMsg = new TelegramMsg(prop);
		telMsg.botSendingPhoto(msgIn.getChat_id());

		TimeSeries s1 = new TimeSeries("Ventas America");
		TimeSeries s2 = new TimeSeries("Ventas Medias Resto");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 00, 01, 0, 0, 0);
		int minAmer = 95;
		int maxAmer = 100;
		int minRes = 90;
		int maxRes = 95;
		
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int j=5;
		int tendAmer=1;
		int tendRes=1;
	while (cal.before(Calendar.getInstance())) {
		if(j>0){
			minAmer+=tendAmer;
			maxAmer+=tendAmer;
			minRes+=tendRes;
			maxRes+=tendRes;
			j--;
		}
		else if(j==0){
			double resAmer=new Double(0 + (Math.random() * ((10 - 0) + 1)));
			double resRes=new Double(0 + (Math.random() * ((10 - 0) + 1)));
			if(resAmer>5) tendAmer=1;
			else tendAmer=-1;
			if(resRes>6) tendRes=1;
			else tendRes=-1;
			j=5;
		}
			s1.add(new Day(cal.getTime()), new Double(minAmer + (Math.random() * ((maxAmer - minAmer) + 1))));
			s2.add(new Day(cal.getTime()), new Double(minRes + (Math.random() * ((maxRes - minRes) + 1))));
			cal.add(Calendar.HOUR, 24);
			
		}

		TimeSeriesCollection datasetTime = new TimeSeriesCollection();
		datasetTime.addSeries(s1);
		datasetTime.addSeries(s2);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("Ventas Geográficas (America)", // chart
				// title
				"Dia", // x axis label
				"Millones €", // y axis label
				datasetTime, // data
				true, // include legend
				true, // tooltips
				false // urls
		);


		
		
		String random = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

		File f = new File(prop.getPropValues("attachments") + "/ventaSemanalTotal" + random + ".jpg");
		ChartUtils.saveChartAsJPEG(f, chart, 800, 600);

		telMsg.sendDocument(Integer.parseInt(msgIn.getChat_id()), f);

		f.delete();

	}
	
	
	
	public void Europa() throws UnirestException, IOException, ClassNotFoundException {

		BotGetPropertyValues prop = BotGetPropertyValues.getInstance();
		TelegramMsg telMsg = new TelegramMsg(prop);
		telMsg.botSendingPhoto(msgIn.getChat_id());

		TimeSeries s1 = new TimeSeries("Ventas Europa");
		TimeSeries s2 = new TimeSeries("Ventas Medias Resto");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 00, 01, 0, 0, 0);
		int minAmer = 95;
		int maxAmer = 100;
		int minRes = 90;
		int maxRes = 95;
		
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int j=5;
		int tendAmer=1;
		int tendRes=1;
	while (cal.before(Calendar.getInstance())) {
		if(j>0){
			minAmer+=tendAmer;
			maxAmer+=tendAmer;
			minRes+=tendRes;
			maxRes+=tendRes;
			j--;
		}
		else if(j==0){
			double resAmer=new Double(0 + (Math.random() * ((10 - 0) + 1)));
			double resRes=new Double(0 + (Math.random() * ((10 - 0) + 1)));
			if(resAmer>5) tendAmer=1;
			else tendAmer=-1;
			if(resRes>6) tendRes=1;
			else tendRes=-1;
			j=5;
		}
			s1.add(new Day(cal.getTime()), new Double(minAmer + (Math.random() * ((maxAmer - minAmer) + 1))));
			s2.add(new Day(cal.getTime()), new Double(minRes + (Math.random() * ((maxRes - minRes) + 1))));
			cal.add(Calendar.HOUR, 24);
			
		}

		TimeSeriesCollection datasetTime = new TimeSeriesCollection();
		datasetTime.addSeries(s1);
		datasetTime.addSeries(s2);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("Ventas Geográficas (Europa)", // chart
				// title
				"Dia", // x axis label
				"Millones €", // y axis label
				datasetTime, // data
				true, // include legend
				true, // tooltips
				false // urls
		);


		
		
		String random = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

		File f = new File(prop.getPropValues("attachments") + "/ventaSemanalTotal" + random + ".jpg");
		ChartUtils.saveChartAsJPEG(f, chart, 800, 600);

		telMsg.sendDocument(Integer.parseInt(msgIn.getChat_id()), f);

		f.delete();

	}
	
	public void Asia() throws UnirestException, IOException, ClassNotFoundException {

		BotGetPropertyValues prop = BotGetPropertyValues.getInstance();
		TelegramMsg telMsg = new TelegramMsg(prop);
		telMsg.botSendingPhoto(msgIn.getChat_id());

		TimeSeries s1 = new TimeSeries("Ventas Asia");
		TimeSeries s2 = new TimeSeries("Ventas Medias Resto");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 00, 01, 0, 0, 0);
		int minAmer = 95;
		int maxAmer = 100;
		int minRes = 90;
		int maxRes = 95;
		
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int j=5;
		int tendAmer=1;
		int tendRes=1;
	while (cal.before(Calendar.getInstance())) {
		if(j>0){
			minAmer+=tendAmer;
			maxAmer+=tendAmer;
			minRes+=tendRes;
			maxRes+=tendRes;
			j--;
		}
		else if(j==0){
			double resAmer=new Double(0 + (Math.random() * ((10 - 0) + 1)));
			double resRes=new Double(0 + (Math.random() * ((10 - 0) + 1)));

			if(resAmer>5) tendAmer=1;
			else tendAmer=-1;
			if(resRes>6) tendRes=1;
			else tendRes=-1;
			j=5;
		}
			s1.add(new Day(cal.getTime()), new Double(minAmer + (Math.random() * ((maxAmer - minAmer) + 1))));
			s2.add(new Day(cal.getTime()), new Double(minRes + (Math.random() * ((maxRes - minRes) + 1))));
			cal.add(Calendar.HOUR, 24);
			
		}

		TimeSeriesCollection datasetTime = new TimeSeriesCollection();
		datasetTime.addSeries(s1);
		datasetTime.addSeries(s2);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("Ventas Geográficas (Asia)", // chart
				// title
				"Dia", // x axis label
				"Millones €", // y axis label
				datasetTime, // data
				true, // include legend
				true, // tooltips
				false // urls
		);


		
		
		String random = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

		File f = new File(prop.getPropValues("attachments") + "/ventaSemanalTotal" + random + ".jpg");
		ChartUtils.saveChartAsJPEG(f, chart, 800, 600);

		telMsg.sendDocument(Integer.parseInt(msgIn.getChat_id()), f);

		f.delete();

	}

}
