package com.automate.testDataGenerator;

import com.automate.utils.TradingBaseUtilityClass;

public class CreateVendorTestDataGeneration extends TradingBaseUtilityClass {
	
	String randomName="";
	String randomString="";
	String randomGstin="";
	String ifscCode="";
	int bankAccountNo;
	
	public String vendorNameGenerate() {
		randomName="vendorAutomate"+dateGenerator("time");
		return randomName;
	}
	
	public String vendorGstinGenerate() {
		
		randomString=randomStringGenerator();
		randomGstin="33"+randomString+"1Z3";
		return randomGstin;
	}
	
	public String vendorIfscCodeGenerate() {
		ifscCode=randomStringGenerator();
		return ifscCode;
	}
	
	public int vendorBankAccountNoGenerate() {
		bankAccountNo=randomNumberGenerator();
		return bankAccountNo;
	}
	
	
	
	
	public static void main(String[] args) {
		CreateVendorTestDataGeneration test=new CreateVendorTestDataGeneration();
		System.out.println("vendorName- "+test.vendorNameGenerate());
		System.out.println("gstin- "+test.vendorGstinGenerate());
		System.out.println("ifsc- "+test.vendorIfscCodeGenerate());
		System.out.println("accNo- "+test.vendorBankAccountNoGenerate());
		
		
		
	}

}		
		
		
		
		
		
		
		
		
		

