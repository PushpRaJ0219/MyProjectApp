package in.nit.util;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
	public void generateBar(String path,List<Object[]> data)
	{
		//1.create dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] arr:data)
		{
			//val-index-1(y-axis, key-index-0(x-axis)
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(), "");	
		}
		//2. Create JFreeChart using chartFactory
		JFreeChart chart= ChartFactory.createBarChart("ShipmentType Modes","Modes","COUNT",dataset );
		
		//3. save as image usnig chartUtils
		try
		{
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentBar.jpg"), chart, 400, 400);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void generatePie(String path,List<Object[]> data)
	{
		//1.create dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] arr:data)
		{
			//key-ShipMode, val-count
			dataset.setValue(arr[0].toString(),Double.valueOf(arr[1].toString()));	
		}
		//2. Create JFreeChart using chartFactory
		JFreeChart chart= ChartFactory.createPieChart3D("ShipmentType Modes", dataset, true, true, false);
		
		//3. save as image usnig chartUtils
		try
		{
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentPie.jpg"), chart, 400, 400);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
