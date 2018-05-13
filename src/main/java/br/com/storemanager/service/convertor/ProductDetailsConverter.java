package br.com.storemanager.service.convertor;

import br.com.storemanager.dto.product.ProductDetailsDTO;
import br.com.storemanager.model.product.ProductDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProductDetailsConverter implements ConvertService<ProductDetails, ProductDetailsDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(ProductDetails.class, ProductDetailsDTO.class);
        modelMapper.createTypeMap(ProductDetailsDTO.class, ProductDetails.class);
    }

    @Override
    public ProductDetails fromDto(ProductDetailsDTO dto) {
        return modelMapper.map(dto, ProductDetails.class);
    }

    @Override
    public ProductDetailsDTO toDto(ProductDetails entity) {
        return modelMapper.map(entity, ProductDetailsDTO.class);
    }
}
