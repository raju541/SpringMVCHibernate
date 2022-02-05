package com.cts.error;

public class IdIsNotFoundException extends Exception{
	
		private static String msg;
		
		public IdIsNotFoundException() { }
		public IdIsNotFoundException(String msg) { 
			
			this.msg=msg;
			System.out.println(msg);
		}
		
		public static String getMsg() {
			return msg;
		}
		public static void setMsg(String msg) {
			IdIsNotFoundException.msg = msg;
		}
		
		
		

		 
		
}
