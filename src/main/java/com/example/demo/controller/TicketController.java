package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;

@RestController
@Controller
@RequestMapping("/ticket")

public class TicketController {

	@Autowired
	private TicketDao dao;
	
	
	@PostMapping("/bookTicket")
	public String bookTicket(@RequestParam(value="amount", defaultValue="0") int amount, @RequestParam(value="category", defaultValue="N/A") String category, @RequestParam(value="valasztas", defaultValue="") String valasztas) {
	
	dao.save(new Ticket(amount, category, valasztas));
	return "Sikeres Foglalás<br><a href='/index'>Visszatérés</a>";
		 
	}
	@GetMapping("/getTickets")
	
	public String getTickets(){
		String[] tmp = {"<table>"};
		dao.findAll().forEach(x -> tmp[0] += x.ToTableRow());
		tmp[0]+="</table>";
		return tmp[0];
	}
	
	@GetMapping("/getTicketss")
	public List<Ticket> getTicketss(){
		return (List<Ticket>)dao.findAll();
	}
}
