package cl.arteValparaiso.webapp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.arteValparaiso.webapp.models.email.Mail;
import cl.arteValparaiso.webapp.models.entity.Obra;
import cl.arteValparaiso.webapp.models.entity.User;
import cl.arteValparaiso.webapp.models.service.IObraService;
import cl.arteValparaiso.webapp.models.service.IUserService;
import cl.arteValparaiso.webapp.models.service.MailService;

@Controller
@SessionAttributes("mail")
@RequestMapping(value ="/contact", method = RequestMethod.GET)
public class ContactController {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	private IObraService obraServ;
	
	@Autowired
	private IUserService userServ; 
	
	@GetMapping("/info")
	public String contact(Model model) {

		Long id = (long) 1;
		Mail mail = new Mail();		
		User user = userServ.findOne(id);

		model.addAttribute("user", user);
		model.addAttribute("mail", mail);
		model.addAttribute("titulo", "Contacto");

		
		return "form/contact_info";
	}
	
	@PostMapping("/send")
	public String send(@Validated Mail mail, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {	
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Contacto");
			return "redirect:/contact/info";
		}
		
		mail.setMailFrom("artevalparaisofconcha@gmail.com");
		mail.setMailCc("fernandoconcha@artevalparaiso.cl");
		mailService.sendEmail(mail);
		
		String mensajeFlash = "Muchas gracias pronto me contactare contigo";
		flash.addFlashAttribute("success", mensajeFlash);
		
		return "redirect:/galeria";
	}	
	
	@GetMapping("/obra/{id}")
	public String obra(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Long idusr = (long) 1;
		
		User user = userServ.findOne(idusr);
		Obra obra = obraServ.findOne(id);
		Mail mail = new Mail();		
		mail.setMailSubject(obra.getId()+" - "+obra.getTitulo());
		
		model.put("user", user);
		model.put("obra", obra);
		model.put("mail", mail);
		model.put("titulo", "Contacto Obra");
		
		return "form/contact_obra";
	}
	
	@PostMapping("/send-obra")
	public String sendObra(@Validated Mail mail, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {	
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Contacto");
			return "redirect:/contact/info";
		}
		
		mail.setMailFrom("artevalparaisofconcha@gmail.com");
		mail.setMailCc("fernandoconcha@artevalparaiso.cl");

		mailService.sendEmail(mail);
		
		String mensajeFlash = "Muchas gracias pronto me contactare contigo";
		flash.addFlashAttribute("success", mensajeFlash);
		
		return "redirect:/galeria";
	}	
}