package br.com.storemanager.service.convertor;

import br.com.storemanager.dto.product.ProviderDTO;
import br.com.storemanager.model.product.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProviderConverter implements ConvertService<Provider, ProviderDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    private void init() {
        modelMapper.createTypeMap(Provider.class, ProviderDTO.class);
        modelMapper.createTypeMap(ProviderDTO.class, Provider.class);
    }

    @Override
    public Provider fromDto(final ProviderDTO dto) {
        return modelMapper.map(dto, Provider.class);
    }

    @Override
    public ProviderDTO toDto(Provider entity) {
        return modelMapper.map(entity, ProviderDTO.class);
    }
}
