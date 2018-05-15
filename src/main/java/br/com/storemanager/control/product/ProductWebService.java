package br.com.storemanager.control.product;

import br.com.storemanager.control.AbstractWebService;
import br.com.storemanager.dto.product.ProductDTO;
import java.util.Map;

public interface ProductWebService extends AbstractWebService<ProductDTO> {

    void stockDown(Map<Integer, Integer> productIdByQuantity);
}
