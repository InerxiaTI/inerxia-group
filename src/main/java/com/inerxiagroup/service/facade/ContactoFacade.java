package com.inerxiagroup.service.facade;

import com.inerxiagroup.dto.contacto.ContactoDTO;
import com.inerxiagroup.mapper.contacto.ContactoMapper;
import com.inerxiagroup.service.ContactoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactoFacade {
    private ContactoMapper contactoMapper;
    private ContactoService contactoService;

    public ContactoFacade(ContactoMapper contactoMapper, ContactoService contactoService) {
        this.contactoMapper = contactoMapper;
        this.contactoService = contactoService;
    }

    public ContactoDTO crearContacto(ContactoDTO contactoDTO) {
        return contactoMapper.toDto(contactoService.crearContacto(contactoMapper.toEntity(contactoDTO)));
    }


}
