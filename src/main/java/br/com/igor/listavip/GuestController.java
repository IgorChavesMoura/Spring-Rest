package br.com.igor.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.emailsender.EmailService;
import br.com.igor.listavip.model.Guest;
import br.com.igor.listavip.service.GuestService;

@RestController
public class GuestController {
	
	@Autowired
	private GuestService service;

	
	private EmailService email = new EmailService();
	
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("guestlist")
	public Iterable<Guest> guestList(Model model) {
			
		return service.getAll();
	}
	
	@RequestMapping(value="guest", method=RequestMethod.POST)
	public void save(@RequestBody Guest guest) {
	
		service.save(guest);
		
		email.send(guest.getNome(),guest.getEmail());
				
		
	}
}
