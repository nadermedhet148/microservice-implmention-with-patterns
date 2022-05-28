package com.inventory.service.Aapplication;
import com.inventory.service.Aapplication.services.ProductService;
import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import com.inventory.service.Domain.Events.OrderPaymentIsFailedEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.inventory.service.Domain.models.DuctedQuantity;
import com.inventory.service.Domain.models.Product;
import com.inventory.service.infrastructure.Cache.ProductCacheManager;
import com.inventory.service.infrastructure.EventProducers.Producer;
import com.inventory.service.infrastructure.repositories.IDuctedQuantityRepository;
import org.junit.jupiter.api.BeforeEach;
import com.inventory.service.infrastructure.repositories.IProductRepository;
import org.junit.runner.RunWith;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @MockBean
    private  Producer producer = Mockito.mock(Producer.class);

    @MockBean
    IProductRepository productRepository = Mockito.mock(IProductRepository.class);

    @MockBean
    IDuctedQuantityRepository ductedQuantityRepository = Mockito.mock(IDuctedQuantityRepository.class);

    @MockBean
    ProductCacheManager productCache = Mockito.mock(ProductCacheManager.class);


    @BeforeEach
    public void setUp(){

    }

    @Test
    public void test_revertDuctedQuantity_should_increase_product_quantity_and_update_cache() {
        ProductService productService = new ProductService(producer,productRepository,ductedQuantityRepository,productCache);
        when(ductedQuantityRepository.findOneByOrderId(1)).thenReturn(Optional.of(new DuctedQuantity(1 , 1 ,1)));
        when(productRepository.getOne(1)).thenReturn(new Product(1 , 1, "na" , 1F));
        Product product = productService.revertDuctedQuantity(new OrderPaymentIsFailedEvent(1));
        assertThat(product.getAvailableQuantity() , is(2));
    }

    @Test
    public void test_checkOrderProductQuantityAvailability_should_decrease_product_quantity_and_publish_OrderQuantityIsAvailableEvent() {
        ProductService productService = new ProductService(producer,productRepository,ductedQuantityRepository,productCache);
        when(productRepository.getOne(1)).thenReturn(new Product(1 , 1, "na" , 1F));
        Product product = productService.checkOrderProductQuantityAvailability(new OrderCheckingQuantityEvent(1 , 1 , 1));
        assertThat(product.getAvailableQuantity() , is(0));
        verify(producer , times(1)).sendMessage(any());

    }

}