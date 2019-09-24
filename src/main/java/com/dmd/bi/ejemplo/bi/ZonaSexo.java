package com.dmd.bi.ejemplo.bi;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.BarChart;
import com.googlecode.charts4j.BarChartPlot;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.RadarChart;
import com.googlecode.charts4j.RadarPlot;
import com.googlecode.charts4j.Shape;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ZonaSexo {

	private MensajeJsonIn msgIn;

	public ZonaSexo(MensajeJsonIn in) {
		this.msgIn = in;
	}

	public void Hombre() throws UnirestException, IOException, ClassNotFoundException {

		BotGetPropertyValues prop = BotGetPropertyValues.getInstance();
		TelegramMsg telMsg = new TelegramMsg(prop);
		telMsg.botSendingPhoto(msgIn.getChat_id());
		
		
		List<Number> itemA = new ArrayList<Number>();
		
		for (int i =0; i<5; i++){
			itemA.add(new Double(0 + (Math.random() * ((100 - 0) + 1))));
			
		}
		
		RadarPlot plot = Plots.newRadarPlot(Data.newData(itemA));
		com.googlecode.charts4j.Color plotColor = com.googlecode.charts4j.Color.newColor("CC3366");
        plot.addShapeMarkers(Shape.SQUARE, plotColor, 12);
        plot.addShapeMarkers(Shape.SQUARE, com.googlecode.charts4j.Color.WHITE, 8);
        plot.setColor(plotColor);
        plot.setLineStyle(LineStyle.newLineStyle(4, 1, 0));
        RadarChart chart = GCharts.newRadarChart(plot);
        chart.setTitle("Competencia", com.googlecode.charts4j.Color.BLACK, 20);
        chart.setSize(400, 400);
        com.googlecode.charts4j.RadialAxisLabels radialAxisLabels = AxisLabelsFactory.newRadialAxisLabels("Item A", "Item B", "Item C", "Item D", "Item E");
        radialAxisLabels.setRadialAxisStyle(com.googlecode.charts4j.Color.BLACK, 12);
        chart.addRadialAxisLabels(radialAxisLabels);
        AxisLabels contrentricAxisLabels = AxisLabelsFactory.newNumericAxisLabels(Arrays.asList(0, 20, 40, 60, 80, 100));
        contrentricAxisLabels.setAxisStyle(AxisStyle.newAxisStyle(com.googlecode.charts4j.Color.BLACK, 12, AxisTextAlignment.RIGHT));
        chart.addConcentricAxisLabels(contrentricAxisLabels);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        
        BufferedImage bi = (BufferedImage) new ImageIcon(ImageIO.read(new URL(url))).getImage();
        
        
        
        String random = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

		File f = new File(prop.getPropValues("attachments") + "/ventaSemanalTotal" + random + ".jpg");
		
		//ChartUtilities.saveChartAsJPEG(f, chart, 800, 600);
		ImageIO.write(bi, "png", f);

		telMsg.sendDocument(Integer.parseInt(msgIn.getChat_id()), f);

		f.delete();
        

		
	}
	
	
	
	public void Mujer() throws UnirestException, IOException, ClassNotFoundException {

		BotGetPropertyValues prop = BotGetPropertyValues.getInstance();
		TelegramMsg telMsg = new TelegramMsg(prop);
		telMsg.botSendingPhoto(msgIn.getChat_id());

		List<Number> itemA = new ArrayList<Number>();
		List<Number> itemB = new ArrayList<Number>();
		List<Number> itemC = new ArrayList<Number>();
		for (int i =0; i<5; i++){
			itemA.add(new Double(0 + (Math.random() * ((10 - 0) + 1))));
			itemB.add(new Double(0 + (Math.random() * ((10 - 0) + 1))));
			itemC.add(new Double(0 + (Math.random() * ((10 - 0) + 1))));
		}
		
		
		BarChartPlot team1 = Plots.newBarChartPlot(Data.newData(itemA), com.googlecode.charts4j.Color.BLUEVIOLET, "Item A"); 
        BarChartPlot team2 = Plots.newBarChartPlot(Data.newData(itemB), com.googlecode.charts4j.Color.ORANGERED, "Item B"); 
        BarChartPlot team3 = Plots.newBarChartPlot(Data.newData(itemC), com.googlecode.charts4j.Color.LIMEGREEN, "Item C"); 
        

 
        // Instantiating chart. 
        BarChart chart = GCharts.newBarChart(team1, team2, team3); 
 
        // Defining axis info and styles 
        AxisStyle axisStyle = AxisStyle.newAxisStyle(com.googlecode.charts4j.Color.BLACK, 13, AxisTextAlignment.CENTER); 
        AxisLabels score = AxisLabelsFactory.newAxisLabels("Ventas", 50.0); 
        score.setAxisStyle(axisStyle); 
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Año", 50.0); 
        year.setAxisStyle(axisStyle); 
 
        // Adding axis info to chart. 
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("2012", "2013", "2014", "2015", "2016")); 
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 100)); 
        chart.addYAxisLabels(score); 
        chart.addXAxisLabels(year); 
 
        chart.setSize(600, 250); 
        chart.setBarWidth(50); 
        chart.setSpaceWithinGroupsOfBars(20); 
        chart.setDataStacked(true); 
        chart.setTitle("Ventas por Item/Año", com.googlecode.charts4j.Color.BLACK, 16); 
        chart.setGrid(100, 10, 3, 2); 
        chart.setBackgroundFill(Fills.newSolidFill(com.googlecode.charts4j.Color.ALICEBLUE)); 
        LinearGradientFill fill = Fills.newLinearGradientFill(0, com.googlecode.charts4j.Color.LAVENDER, 100); 
        fill.addColorAndOffset(com.googlecode.charts4j.Color.WHITE, 0); 
        chart.setAreaFill(fill); 
        String url = chart.toURLString(); 
        // EXAMPLE CODE END. Use this url string in your web or 
        // Internet application. 
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url); 
        //String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,F0F8FF|c,lg,0,E6E6FA,1.0,FFFFFF,0.0&chs=600x450&chd=e:QAbhHrTN,FIWZHCDN,GaMzTNTN&chtt=Team+Scores&chts=000000,16&chg=100.0,10.0,3,2&chxt=y,y,x,x&chxr=0,0.0,100.0|1,0.0,100.0|3,0.0,100.0&chxl=1:|Score|2:|2002|2003|2004|2005|3:|Year&chxp=1,50.0|3,50.0&chxs=1,000000,13,0|3,000000,13,0&chdl=Team+A|Team+B|Team+C&chco=8A2BE2,FF4500,32CD32&chbh=100,20,8&cht=bvs"; 
        //assertEquals("Junit error", normalize(expectedString), normalize(url));
        BufferedImage bi = (BufferedImage) new ImageIcon(ImageIO.read(new URL(url))).getImage();
        
        
        
        String random = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

		File f = new File(prop.getPropValues("attachments") + "/ventaSemanalTotal" + random + ".jpg");
		
		//ChartUtilities.saveChartAsJPEG(f, chart, 800, 600);
		ImageIO.write(bi, "png", f);

		telMsg.sendDocument(Integer.parseInt(msgIn.getChat_id()), f);

		f.delete();
        
        


	}
	
	

}
