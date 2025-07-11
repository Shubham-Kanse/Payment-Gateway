package com.ravenclaw;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ravenclaw.model.Checksum;
import com.ravenclaw.model.CustomerInfo;
import com.ravenclaw.model.VendorStatus;

@RestController
public class Vendor {

	@Autowired
	CustomerInfo ref1;
	VendorStatus vs =new VendorStatus();
    
	   //receives the details from customer and send to merchant
    	@CrossOrigin("http://localhost:4200")
       	@PostMapping("/vendor")
       	public void getVal(@RequestBody CustomerInfo ci) 
       	{
	    String name = ci.getName();
		int amt = ci.getAmount();
		Date date = ci.getDate();	
		RestTemplate rst = new RestTemplate();
		
        //getting checksum from merchant server(8071) 
		String url = "http://localhost:8071/collect/" + name + "/" + amt + "/" + date;
		HttpEntity<CustomerInfo> req = new HttpEntity<CustomerInfo>(ref1);
		String UID = rst.postForEntity(url, req, String.class).getBody();
		
		Checksum c=new Checksum();
		c.setUid(UID);
		c.setAmount(amt);
		
		//sending information to paymentapp
		 String url1= "http://localhost:8072/paymentapp";
		 HttpEntity<Checksum> entity = new HttpEntity<Checksum>(c);
		 rst.postForEntity(url1,entity, Object.class); 
		    
		System.out.print("done with vendor");
 
		
		
	}
    	
	    //code to be executed on 'if txn success'
		@PostMapping("/vendor/paymentstatus")
		public void vendorTransactionStatus(@RequestBody String status) {
			//call status check api
			System.out.println("inside ven paystatus"+status+"--");
			RestTemplate restTemplate = new RestTemplate();
			String baseurl = "http://localhost:8071";
			HttpEntity<String>entity = new HttpEntity<String>(status);
			restTemplate.postForObject(baseurl + "/vserver/statuscheck",entity,String.class);
			
		}
		
		
	    //code to be executed on receiving the final status of txn
		@PostMapping("/vendor/finalstatus")
		@ResponseBody
		public void setFinalStatus(@RequestBody Map<String,String> map) {
			//setting final status to merchent website
			vs.setStatus(map.get("status"));
			vs.setTransactionid(map.get("transactionid"));
			System.out.println("final status in merchent " + map.get("status"));
			System.out.println("transaction id " + map.get("transactionid"));
			
		}
		
			
		@CrossOrigin("http://localhost:4200")
		@GetMapping("/vendor/getFinalStatus")
		public VendorStatus getFinalStatus() {
			//get status by using angular<-------------------
			//as vendor status object st
			System.out.println(vs.getStatus());
			System.out.println(vs.getTransactionid());
			System.out.println("Send to the angular component");
			return vs;
		}
		

}
