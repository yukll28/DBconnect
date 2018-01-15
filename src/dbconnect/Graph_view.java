package dbconnect;

import java.awt.*;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Graph_view extends Frame implements ActionListener,WindowListener
{
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	private ChartPanel cpanel;
	
	JFreeChart chart;
	public Graph_view() {
		super();
		
		addWindowListener(this);
		setTitle("Graph");
		setLayout(new FlowLayout(FlowLayout.CENTER));
	   
		int id, year,ton;
		String name;
		ResultSet rs;

		MySQL mysql = new MySQL();

		rs = mysql.selectAll();

	   
		try {
			while(rs.next()){
			    id = rs.getInt("id");
			    name = rs.getString("name");
			    year = rs.getInt("year");
			    ton = rs.getInt("ton");
			    data.addValue(ton,name,""+year);
				

			}  //try catch‚ÅˆÍ‚Þ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		JFreeChart chart1 = ChartFactory.createLineChart(
	    		  "Import Volume",
	              "Year",
	              "Ton",
	              data,
	              PlotOrientation.VERTICAL,
	              true,
	              false,
	              false
	        );
	    cpanel = new ChartPanel(chart1);
	    add(cpanel, BorderLayout.CENTER);
		    
	
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
