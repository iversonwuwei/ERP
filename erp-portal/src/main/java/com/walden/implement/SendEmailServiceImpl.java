package com.walden.implement;



import com.walden.dao.TurfMailDao;
import com.walden.service.ISendEmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * Created by
 */

@Service
@Qualifier(value = "mailService")
public class SendEmailServiceImpl implements ISendEmailService{


	@Autowired
	private TurfMailDao turfMailDao;
	
	
    public void send(String customer_email)  {
    	 HtmlEmail email = new HtmlEmail();
    	 
	     try {
	    	
	    	 email.setHostName(turfMailDao.selectAllMail().getMail_host());
		     email.addTo(customer_email);
			 email.setFrom(turfMailDao.selectAllMail().getMail_send());
			 email.setAuthentication(turfMailDao.selectAllMail().getUse_name(),
					                 turfMailDao.selectAllMail().getUse_pass());
			 email.setSubject(turfMailDao.selectAllMail().getSubject());
			 email.setMsg(turfMailDao.selectAllMail().getMessage());
	    	
			 email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
	}
	
    	
    }

	
}
