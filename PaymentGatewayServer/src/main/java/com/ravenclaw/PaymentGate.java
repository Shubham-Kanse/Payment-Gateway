package com.ravenclaw;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ravenclaw.model.Checksum;
import com.ravenclaw.model.PayVal;
import com.ravenclaw.model.PaymentGateway;

    @RestController
    public class PaymentGate {
    	//this helps to send amount to and unique id to frontend and redirect to payment page
    	PayVal pv;
    	PaymentGateway pg=new PaymentGateway();
    	
    	//receive unique id and amount from merchant and store into object
    	@CrossOrigin("http://localhost:4200")
	    @PostMapping("/paymentapp")
	    public void verify(@RequestBody Checksum c) {
    		int d=c.getAmount();
    	    pv=new PayVal( d, c.getUid());
    	}
    	
    	//it will send object back to front end and then helps to redirect to payment page
    	 @CrossOrigin("http://localhost:4200")
    	 @GetMapping("/details")
    	 public PayVal RecievedBankStatus() {
    	    	System.out.println(pv.getUid());
    	    	System.out.println(pv.getAmt());
    	    	return pv;
    	    }
   
	    	
    	//function to be called on callback url
 		@GetMapping("/pgserver/payment/{status}")
 		public void checkTransactionStatusFromBank(@PathVariable  String status) {
 			String baseurl = "http://localhost:8070";
 			RestTemplate restTemplate = new RestTemplate();
 			System.out.println(status);
 			pg.setPgstatus(status);
 			
 				//pass txn status to merchant website
 				
 				System.out.println("insdie pg payment status"+status+"--");
 				HttpEntity<String> entity = new HttpEntity<String>(status);
 			    restTemplate.postForObject(baseurl + "/vendor/paymentstatus",entity,String.class);	
 			   // return null;
 			
 		}

 		
 		
 	    //cross checking the status against the status received from the merchant
 		@PostMapping("/pgserver/statuscheck")
 		public void statusCheckFromMerchant(@RequestBody String status) {
 			RestTemplate restTemplate = new RestTemplate();
 			String baseurl = "http://localhost:8071";
 			pg.setTransactionid((int) Math.floor(100000 + Math.random() * 900000));
 			Map<String,String> map = new HashMap<String,String>();
 			map.put("status", status);
 			map.put("transactionid", String.valueOf(pg.getTransactionid()));
 			if (status.equals(pg.getPgstatus())) {
 			System.out.println("inside pg status check  ");
 			HttpEntity<Map<String,String>> entity = new HttpEntity<Map<String,String>>(map);
 			restTemplate.postForObject(baseurl + "/vserver/verifytransaction",entity,String.class);
 			
 			}
 			else {
 				System.out.println("Some problem occurred while processing the transaction");
 			} 
 		}

 	    
 	    

	    
	
	    

}
