package com.infybuzz.report;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class CustomScriptlet extends JRDefaultScriptlet {

	private static final Logger logger = Logger.getLogger(CustomScriptlet.class.getName());
    private double result;
    private int counter;
    
	public CustomScriptlet() {
	}
	
	@Override
	public void beforeReportInit() throws JRScriptletException
	{
		System.out.println("beforeReportInit() is called");
	}
	
	@Override
	public void beforePageInit() throws JRScriptletException
	{
		System.out.println("beforePageInit() is called");
	}


	@Override
	public void afterPageInit() throws JRScriptletException
	{
		System.out.println("afterPageInit() is called");
	}


	@Override
	public void beforeColumnInit() throws JRScriptletException
	{
		System.out.println("beforeColumnInit() is called");
	}


	@Override
	public void afterColumnInit() throws JRScriptletException
	{
		System.out.println("afterColumnInit() is called");
	}


	@Override
	public void beforeGroupInit(String groupName) throws JRScriptletException
	{
		System.out.println("beforeGroupInit() is called");
	}


	@Override
	public void afterGroupInit(String groupName) throws JRScriptletException
	{
		System.out.println("afterGroupInit() is called");
	}

	
    @Override
    public void beforeDetailEval() throws JRScriptletException {
        super.beforeDetailEval();
        
    }
    
	@Override
	public void afterDetailEval() throws JRScriptletException
	{
		super.afterDetailEval();
		System.out.println("afterDetailEval() is called");
        // Get the value of a field in the current record
        logger.log(Level.INFO, "Class of 'sumId': " + getVariableValue("sumId").getClass().getName());
        double currentValue = ((Number) getVariableValue("sumId")).doubleValue(); 
        // Perform the custom calculation
        if (counter == 0) {
        	result = result + 2 * currentValue;
        } else {
        	result = result + currentValue;
        }
        
        
        // Store the result in a variable
        logger.log(Level.INFO, "result value: " + result);
        if (counter > 1) {
        	setVariableValue("MyVariable", result/3);
        }
		counter++;
	}

	}
