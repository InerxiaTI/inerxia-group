package com.inerxiagroup.service.enviomail;

import com.inerxiagroup.dto.contacto.ContactoDTO;
import com.inerxiagroup.model.contacto.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviarMail {

    @Autowired
    private  JavaMailSender javaMailSender;

    public EnviarMail(){ }

    public  void enviarMail(String destinatario, ContactoDTO contactoDTO){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(destinatario);
        mailMessage.setFrom(destinatario);
        mailMessage.setSubject(contactoDTO.getAsunto());
        mailMessage.setText(this.formatearMensaje(contactoDTO));

        javaMailSender.send(mailMessage);


    }
    public String formatearMensaje(ContactoDTO contactoDTO){
        String mensaje = "Prospecto: ".concat(contactoDTO.getNombre()+" ").concat(contactoDTO.getApellido())+
                "\n"+"Correo: ".concat(contactoDTO.getEmail())+
                "\n"+"Mensaje: ".concat(contactoDTO.getMensaje());

        return mensaje;
    }


}
