package it.exolab.tesina.auction.test;

import it.exolab.tesina.auction.validation.ValidationUser;

public class Test {

	public static void main(String[] args) {
	String eMail = "ciao@liilooo.it";

	System.out.println(ValidationUser.emailValidator(eMail));
   System.out.println(ValidationUser.isValidPassword("simoNem01?"));
	}

}
