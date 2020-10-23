package com.twuc.shopping.Controller;

import com.twuc.shopping.Entity.ProductEntity;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@ResponseBody
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllList() {
        List<ProductEntity> list = productsService.findAll();
        return ResponseEntity.ok().body(list.stream().map(Product::from).collect(Collectors.toList()));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .unit(product.getUnit())
                .prictureUrl(product.getPrictureUrl())
                .build();

        ProductEntity addition = productsService.addProduct(productEntity);
        if (addition == null)
            return ResponseEntity.status(400).build();
        if (addition.getName().equals("重名"))
            return ResponseEntity.status(450).build();

        Product result = Product.builder()
                .id(addition.getId())
                .name(addition.getName())
                .price(addition.getPrice())
                .unit(addition.getUnit())
                .prictureUrl(addition.getPrictureUrl())
                .build();
        return ResponseEntity.ok().body(result);

    }
}
