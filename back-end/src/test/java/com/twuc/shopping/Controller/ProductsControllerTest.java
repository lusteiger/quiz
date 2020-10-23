package com.twuc.shopping.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.Entity.ProductEntity;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductsRepository productsRepository;

    @BeforeEach
    void setUp() {
        productsRepository.deleteAll();
        productsRepository.save(addProduct());
    }

    @Test
    void should_return_products_list_when_query_products() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("[0].name", is("雪碧")));
    }


    @Test
    void should_insert_one_product_to_products_list() throws Exception {
        Product product = Product.builder()
                .name("可乐")
                .price(3)
                .unit("瓶")
                .prictureUrl("  ")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/product")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("[0].name", is("雪碧")))
                .andExpect(jsonPath("[1].name", is("可乐")));

    }


    @Test
    void should_valid_addition_when_the_product_name_is_exist() throws Exception {
        Product product = Product.builder()
                .name("雪碧")
                .price(3)
                .unit("瓶")
                .prictureUrl("  ")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/product")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(450));


    }


    private ProductEntity addProduct() {
        return ProductEntity.builder()
                .name("雪碧")
                .price(4)
                .unit("瓶")
                .prictureUrl("  ")
                .build();
    }

}