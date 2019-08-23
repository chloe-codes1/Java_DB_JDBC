package day17_ex;

import java.io.IOException;

public class NegativeNumberException extends IOException {

	NegativeNumberException(){
		super("*** 음수 노우! ***\n=> NegativeNumberException");
		
	}
}
