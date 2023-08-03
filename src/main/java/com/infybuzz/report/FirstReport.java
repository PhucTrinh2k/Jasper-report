package com.infybuzz.report;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FirstReport {
	private static final Logger logger = Logger.getLogger(FirstReport.class.getName());
	
	public static void main(String[] args) {
		
		try {
			String filePath = "D:\\jasper_lesson\\Setting-Up-Java-Project-with-Jasper\\src\\main\\resources\\FirstReport.jrxml";
			String destPath = "D:\\jasper_lesson\\exported-Jasper-Reports\\FirstReport.pdf";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("studentName", "Dinh Phuc");
			
			Student student1 = new Student(2.0, "Harry", "Maguire", 2L, 
					"Manchester");
			
			Student student2 = new Student(2.0, "Phuc", "Trinh", 8L, 
					"Hanoi");
			
			Student student3 = new Student(3.0, "Wayne", "Rooney", 8L, 
					"Hanoi");
			
			parameters.put("student", student3);
			parameters.put("REPORT_SCRIPTLET", new CustomScriptlet());
			
			List<Student> list = new ArrayList<Student>();
			list.add(student1);
			list.add(student2);
			list.add(student3);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
			JasperReport report = JasperCompileManager.compileReport(filePath);
			
			JRBaseTextField textField = (JRBaseTextField) report.getTitle().getElementByKey("name");
			textField.setForecolor(Color.YELLOW);
			
			JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(print, destPath);
			System.out.println("Report created done");
			
		} catch(Exception e) {
			logger.log(Level.SEVERE, "an error occured", e);
		}
	}

}
