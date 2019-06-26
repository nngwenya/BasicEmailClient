package services;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;


public class MailSender {

    public void sendMail(BasicMail basicMail, PropertyFetcher fetcher){

        Email from = new Email(fetcher.getenv("USER_EMAIL"));
        String subject = basicMail.getSubject();
        Email to = new Email(basicMail.getRecipients().get(0)); //sends the email to the first address in the To-List. will be implement advanced version
        Content content = new Content("text/plain", basicMail.getBody());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(fetcher.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}