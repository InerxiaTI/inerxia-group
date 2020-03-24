package com.inerxiagroup.mapper.contacto;

import com.inerxiagroup.dto.contacto.ContactoDTO;
import com.inerxiagroup.mapper.EntityMapper;
import com.inerxiagroup.model.contacto.Contacto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactoMapper extends EntityMapper<ContactoDTO, Contacto> {
}
