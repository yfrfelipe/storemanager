package br.com.storemanager.service.convertor;

import br.com.storemanager.dto.product.BarcodeDTO;
import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.model.product.Barcode;
import br.com.storemanager.model.product.Lot;
import br.com.storemanager.model.product.Product;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotConvert implements ConvertService<Lot, LotDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConvertService<Product, ProductDTO> productConvert;

    @Autowired
    private ConvertService<Barcode, BarcodeDTO> barcodeConverter;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(LotDTO.class, Lot.class);
        modelMapper.createTypeMap(Lot.class, LotDTO.class);
    }

    @Override
    public Lot fromDto(LotDTO dto) {
        final Lot lot = modelMapper.map(dto, Lot.class);
        final Barcode barcode = barcodeConverter.fromDto(dto.getBarcodeDTO());
        final Set<Product> products = Sets.newHashSet();

        for (ProductDTO productDTO : dto.getProductDTOS()) {
            products.add(productConvert.fromDto(productDTO));
        }

        lot.setBarcode(barcode);
        lot.setProducts(products);
        return lot;
    }

    @Override
    public LotDTO toDto(Lot entity) {
        final LotDTO lotDTO = modelMapper.map(entity, LotDTO.class);
        final BarcodeDTO barcodeDTO = barcodeConverter.toDto(entity.getBarcode());
        final Set<ProductDTO> productDTOs = Sets.newHashSet();

        for (Product product : entity.getProducts()) {
            productDTOs.add(productConvert.toDto(product));
        }

        lotDTO.setBarcodeDTO(barcodeDTO);
        lotDTO.setProductDTOS(productDTOs);
        return lotDTO;
    }
}
