package com.inerxiagroup.controller.contacto;

import com.inerxiagroup.dto.contacto.ContactoDTO;
import com.inerxiagroup.dto.contacto.ContactoEnum;
import com.inerxiagroup.service.enviomail.EnviarMail;
import com.inerxiagroup.service.facade.ContactoFacade;
import com.inerxiagroup.util.handler.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@CrossOrigin(origins = {"https://inerxiagroup.herokuapp.com"})
@RestController
@RequestMapping("/api")
public class ContactoController {
    private ContactoFacade contactoFacade;

    @Autowired
    private EnviarMail enviarMail;

    @Value("${spring.mail.username}")
    public String correoDestino;

    public ContactoController(ContactoFacade contactoFacade){
        this.contactoFacade=contactoFacade;
    }

    @PostMapping(value ="/v1/contacto")
    public ResponseEntity<StandardResponse<ContactoDTO>> crearCliente(@Valid @RequestBody ContactoDTO contactoDTO) {

        contactoDTO.setFechaEnvio(new Date(System.currentTimeMillis()));
        contactoDTO.setEstado(ContactoEnum.ESPERANDO.toString());

        enviarMail.enviarMail(this.correoDestino, contactoDTO);

        ContactoDTO contactoGuardar = contactoFacade.crearContacto(contactoDTO);
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, "contacto.enviar.exito", contactoGuardar));
    }

}
