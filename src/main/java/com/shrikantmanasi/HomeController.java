package com.shrikantmanasi;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final String SUBJECT = "Contact Request";
	private static final String BCC_ADDRESS = "sstonape@gmail.com";
	private static final String CC_ADDRESS = "sanjay.ajnalkar@gmail.com";
	private static final String TO_ADDRESS = "sanjay@synergymarketresearch.com";
	private static final String FROM_ADDRESS = "support@synergymarketresearch.com";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SynergyEmailAPI synergyEmailAPI;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/home/market-research-companies-pune", "/who-we-are", "/vision", "/team", "/data-processing", "/open-end-coding", "/presentation", "/stat-analysis", "/translation", "/data-entry", "/survey-programming", "/contact-us", "/news" })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveDetails(@RequestBody Synergy synergy) throws MessagingException {
		this.readyToShootEmail(synergy);
		System.out.println("MAIL SENT SUCCESSFULLY");
        return "synergy";
    }

	private void readyToShootEmail(Synergy synergy) throws MessagingException {
		String fromAddr = FROM_ADDRESS;
		String toAddr = TO_ADDRESS;
		String ccAddr = CC_ADDRESS;
		String bccAddr = BCC_ADDRESS;
		String subject = SUBJECT;
		String contactNumber;
		String fullName = "\t Full Name : " + synergy.getName() + "\n";
		String email = "\t Email Id : " + synergy.getEmail() + "\n";
		if ( synergy.getContactNumber() == null ) {
			contactNumber = "\t Contact Number : " + " --- " + "\n";
		} else {
			contactNumber = "\t Contact Number : " + synergy.getContactNumber() + "\n";
		}
		String message = "\t Message : " + synergy.getDescription();
		String body = fullName + email + contactNumber + message;
		System.out.println(body);;
		synergyEmailAPI.readyToSendEmail(toAddr, fromAddr, ccAddr, bccAddr, subject, body);
	}
	
}
