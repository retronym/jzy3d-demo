package org.jzy3d.demos;

import java.awt.Component;
import java.awt.Rectangle;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.jzy3d.bridge.swt.Bridge;
import org.jzy3d.chart.Chart;
import org.jzy3d.global.Settings;
import org.jzy3d.ui.ChartLauncher;


public class Launcher {		
	public static void openDemo(IDemo demo) throws Exception{
		openDemo(demo, DEFAULT_WINDOW);
	}
	
	public static void openDemo(IDemo demo, Rectangle rectangle) throws Exception{
		Settings.getInstance().setHardwareAccelerated(true);
		demo.init();
		Chart chart = demo.getChart();
		
		ChartLauncher.instructions();
		ChartLauncher.openChart(chart, rectangle, demo.getName());
		//ChartLauncher.screenshot(demo.getChart(), "./data/screenshots/"+demo.getName()+".png");
	}
	
	public static void openStaticDemo(IDemo demo) throws Exception{
		openStaticDemo(demo, DEFAULT_WINDOW);
	}
	
	public static void openStaticDemo(IDemo demo, Rectangle rectangle) throws Exception{
		Settings.getInstance().setHardwareAccelerated(true);
		Chart chart = demo.getChart();
		
		ChartLauncher.openStaticChart(chart, rectangle, demo.getName());
		ChartLauncher.screenshot(demo.getChart(), "./data/screenshots/"+demo.getName()+".png");
	}
	
	public static void openStaticSWTDemo(IDemo demo) throws Exception{
		Settings.getInstance().setHardwareAccelerated(true);
		Chart chart = demo.getChart();
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Bridge.adapt(shell, (Component) chart.getCanvas());
		
		shell.setText(demo.getName());
		shell.setSize(800, 600);
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	protected static String DEFAULT_CANVAS_TYPE = "awt";
	protected static Rectangle DEFAULT_WINDOW = new Rectangle(0,0,600,600);
}

