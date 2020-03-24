package com.inerxiagroup.service;

import com.inerxiagroup.model.contacto.Contacto;
import com.inerxiagroup.repository.contacto.ContactoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ContactoService {
    private ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository){
        this.contactoRepository = contactoRepository;
    }

    public Contacto crearContacto(Contacto contacto) {


        /*if (Objects.nonNull(contacto.getId())) {
            Optional<Contacto> clienteOptional = contactoRepository.findById(contacto.getId());
            if (clienteOptional.isPresent()) {
                throw new DataDuplicatedException("exception.data_duplicated.cliente.id");
            }
        }*/
       /* Optional<Contacto> clienteOptionalDoc = contactoRepository.findByTipoDocumentoAndNumeroDocumento(contacto.getTipoDocumento(), cliente.getNumeroDocumento());
        if (clienteOptionalDoc.isPresent()) {
            throw new DataDuplicatedException("exception.data_duplicated.cliente.numero");
        }*/
        return contactoRepository.save(contacto);
    }


}
