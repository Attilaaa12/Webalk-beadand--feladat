package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private String category;
	private String valasztas;

	public Ticket(int amount, String category, String valasztas)
	{
		this.amount=amount;
		this.category = category;
		this.valasztas = valasztas;
	}
	public Ticket() {}
	
	public String ToString()
	{
		return amount + " " + category + " " + valasztas;
	}
	
	public String ToTableRow()
	{
		return "<tr><td>" + amount + "</td>" + 
				"<td>" + category + "</td>" +
				"<td>" + valasztas + "</td></tr>";
	}
}
