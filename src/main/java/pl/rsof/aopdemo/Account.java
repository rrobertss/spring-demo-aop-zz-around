/*
 *  Company: RS
 *  Project: spring-demo-aop
 *  Created: 18 paź 2021  22:20:33
 *  Author:  RS 		
 */
package pl.rsof.aopdemo;

/**
 * <p></p><p>18 paź 2021</p>
 * @author RS
 *
 */
public class Account {

	private String name;
	private String level;
	
	
	public Account() {
		
	}
	
	
	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	
}
