package br.com.storemanager.service.convertor;

import br.com.storemanager.dto.product.BarcodeDTO;
import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.model.product.Barcode;
import br.com.storemanager.model.product.Product;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductConvert implements ConvertService<Product, ProductDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConvertService<Barcode, BarcodeDTO> barcodeConverter;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(ProductDTO.class, Product.class);
        modelMapper.createTypeMap(Product.class, ProductDTO.class);
    }

    @Override
    public Product fromDto(ProductDTO dto) {
        final Product product = modelMapper.map(dto, Product.class);
        final Barcode barcode = barcodeConverter.fromDto(dto.getBarcodeDTO());
        product.setBarcode(barcode);
        return product;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        final ProductDTO productDTO = modelMapper.map(entity, ProductDTO.class);
        final BarcodeDTO barcodeDTO = barcodeConverter.toDto(entity.getBarcode());

        productDTO.setBarcodeDTO(barcodeDTO);
        return productDTO;
    }
}
