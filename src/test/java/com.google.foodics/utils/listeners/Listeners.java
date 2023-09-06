package com.google.foodics.utils.listeners;

import com.google.foodics.utils.extend_report.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite iSuite){
        ExtentReport.setUpExtentReport();
    }

    @Override
    public void onFinish(ISuite iSuite){
        try {
            ExtentReport.flushExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        try {
            ExtentReport.createTest(insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(result.getMethod().getMethodName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(result.getMethod().getMethodName() )+ " is passed :) ");
    }

    @Override
    public void onTestFailure(ITestResult result){
        ExtentLogger.fail(insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(result.getMethod().getMethodName()) + " is failed :( ");
        ExtentLogger.fail(result.getThrowable().toString().toLowerCase());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip(insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(result.getMethod().getMethodName() )+ " is skipped :0 ");
    }

    private String insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(String str){
        return str.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2").toLowerCase();
    }
}
