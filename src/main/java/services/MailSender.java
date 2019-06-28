package services;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import java.io.IOException;


public class MailSender {

    public void sendMail(BasicMail basicMail, PropertyFetcher fetcher){

        Email from = new Email(fetcher.getenv("USER_EMAIL"));
        Mail mail = new Mail();

        mail.setFrom(from);
        mail.setSubject(basicMail.getSubject());
        mail.addContent(new Content("text/plain", basicMail.getBody()));
        mail.addPersonalization(getPersonalization(basicMail));

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

    private Personalization getPersonalization(BasicMail basicMail)
    {
        //setsup to, cc & bcc
        //todo:there's an exception that sendgrid throws if we dont have addresses as cc, bcc or even both. need to check
        Personalization personalization = new Personalization();

        for (String recipient : basicMail.getRecipients())
        {
            personalization.addTo(new Email(recipient));
        }
        if (basicMail.getCc().size() > 0) {
            for (String cc : basicMail.getCc()) {
                personalization.addCc(new Email(cc));
            }
        }
        if (basicMail.getBcc().size() > 0) {
            for (String bcc : basicMail.getBcc()) {
                personalization.addBcc(new Email(bcc));
            }
        }
        return personalization;
    }






}