package br.com.storemanager.converter;

import br.com.storemanager.dto.ProductDTO;
import br.com.storemanager.model.Product;
import com.google.gson.Gson;

public class ProductConverter {

    public static Product fromProductDTOToProduct(final ProductDTO productDTO) {
        final Product product = new Product(productDTO.getId(), productDTO.getName());
        return product;
    }

    public static ProductDTO fromProductToProductDTO(final Product person) {
        final ProductDTO productDTO = new ProductDTO(person.getId(), person.getName());
        return productDTO;
    }

    public static ProductDTO fromJson(final String jsonValue) {
        final Gson gson = new Gson();
        return gson.fromJson(jsonValue, ProductDTO.class);
    }

    public static String toJson(final ProductDTO productDTO) {
        final Gson gson = new Gson();
        final String json = gson.toJson(productDTO);
        return json;
    }
}
