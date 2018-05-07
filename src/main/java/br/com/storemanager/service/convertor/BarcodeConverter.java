package br.com.storemanager.service.convertor;

import br.com.storemanager.dto.product.BarcodeDTO;
import br.com.storemanager.model.product.Barcode;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarcodeConverter implements ConvertService<Barcode, BarcodeDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(BarcodeDTO.class, Barcode.class);
        modelMapper.createTypeMap(Barcode.class, BarcodeDTO.class);
    }

    @Override
    public Barcode fromDto(BarcodeDTO dto) {
        return modelMapper.map(dto, Barcode.class);
    }

    @Override
    public BarcodeDTO toDto(Barcode entity) {
        return modelMapper.map(entity, BarcodeDTO.class);
    }
}
