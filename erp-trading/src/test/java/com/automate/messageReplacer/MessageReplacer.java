package com.automate.messageReplacer;

import com.automate.utils.ErrorMessageReplacer;

public class MessageReplacer implements ErrorMessageReplacer {
	
	public String partiesScreenErrorMessageReplacer(String actualMsg) {
		String replacedStringMessage = "";
		if (actualMsg.contains("Bank Acc IFSC Code")) {
			replacedStringMessage = actualMsg.replace(actualMsg,
					"The format of the IFSC code value provided in the test data file is incorrect");
		} else if (actualMsg.contains("Name required")) {
			replacedStringMessage = actualMsg.replace(actualMsg,
					"Participant name is not provided in the test data file");
		} else if (actualMsg.contains("valid value for Gstin")) {
			replacedStringMessage = actualMsg.replace(actualMsg,
					"The format of the Gstin value provided in the test data file is incorrect");
		}

		return replacedStringMessage;

	}
	
//	public static void main(String[] args) {
//		MessageReplacer ob=new MessageReplacer();
//		String strings = ob.partiesScreenErrorMessageReplacer("Invalid Format for Bank Acc IFSC Code. Letters and Numbers Only!");
//		System.out.println(strings);
//	}
	

}
