package com.example.ms.yoxlama;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;



    public void send(String to, String name,String address) {
        log.info("MailService.sendMail.start to={}, name={}, address={}", to, name, address);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Restaurant Notifaction");
        String text = String.format(
                "Salam,\n\n" +
                        "Sizi yeni açılan mağazamız barədə məlumatlandırmaqdan məmnunuq.\n\n" +
                        "\"%s\"adlı mağazamız artıq fəaliyyətə başlayıb.\n" +
                        "Ünvan: %s\n\n" +
                        "Sizi mağazamıza dəvət edirik!\n\n" +
                        "Hörmətlə,\n" +
                         "'"+ name+ "'"+ "Komandasi",
                name, address
        );
        message.setText(text);
        mailSender.send(message);
        log.info("MailService.sendMail.end to={}, name={}, address={}", to, name, address);

    }


}
