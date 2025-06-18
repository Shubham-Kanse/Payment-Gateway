package com.ravenclaw;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ravenclaw.model.bankEntity;
import com.ravenclaw.repository.bankRepository;
import com.ravenclaw.service.bankService;


@RestController
@RequestMapping("/bankServer")
public class bankServer {
	
	@Autowired
	bankService service;
	
	bankEntity ref;
	int amount;
	BigInteger cardnumber;

	//this function validates and verify the bank details
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/verifyBankDetails")
	public boolean verifyBankDetails(@RequestBody bankEntity input)
	{
		bankEntity ref=input;
		System.out.println(input.getExpiryDate()+"amount"+input.getBalance()+"name "+input.getName());
		boolean msg=service.cardVerification(input);
		amount = input.getBalance();
		cardnumber = input.getCardNumber();
	
		//Data validation 
		boolean validate=service.validateData(input);
		if(validate) {
			if(msg==true)
			{
				ref=service.code();
				System.out.println(ref.getEmail());
				ref=new bankEntity();
				System.out.println(ref.getName());
				return true;
			}
			else {return false;}
	
		}
	   else
		{
			return false;
		}
	}		
	
	@CrossOrigin("http://localhost:4200")
	//When otp is enter by the user
	@GetMapping("/codeVerification/{code}")
	public boolean codeVerification(@PathVariable("code") int code)
	{
		String status;
		System.out.println(code);
		
		boolean a=service.validateOtp(code);
		
		boolean b=  service.balancecheckmin(amount);
		
		
		if(a==true && b==true)
		{
			service.debited(amount,cardnumber);
 
			status="Success";
			 
		}
		else {
             status="Failure";
		}
		String url="http://localhost:8072/pgserver/payment/"+status;
		System.out.println(url);
		RestTemplate template=new RestTemplate();
		template.getForObject(url, String.class);
		return a;
		
	}
}
