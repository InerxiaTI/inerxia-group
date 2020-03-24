package com.inerxiagroup.controller.contacto;

import com.inerxiagroup.dto.contacto.ContactoDTO;
import com.inerxiagroup.dto.contacto.ContactoEnum;
import com.inerxiagroup.service.facade.ContactoFacade;
import com.inerxiagroup.util.handler.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ContactoController {
    private ContactoFacade contactoFacade;

    public ContactoController(ContactoFacade contactoFacade){
        this.contactoFacade=contactoFacade;
    }

    @PostMapping(value ="/v1/contacto")
    public ResponseEntity<StandardResponse<ContactoDTO>> crearCliente(@Valid @RequestBody ContactoDTO contactoDTO) {
        System.out.println("*********************************************************");
        contactoDTO.setFechaEnvio(new Date(System.currentTimeMillis()));
        contactoDTO.setEstado(ContactoEnum.ESPERANDO.toString());
        System.out.println(contactoDTO.toString());
        ContactoDTO contactoGuardar = contactoFacade.crearContacto(contactoDTO);
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, "contacto.enviar.exito", contactoGuardar));
    }

}
