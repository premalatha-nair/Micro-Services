package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class Helloworld {
	private String message;
	private int  id;

	   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMessage(String message){
	      this.message  = message;
	   }
	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	      System.out.println("Your Id : " + id);
	   }

}
