package com.orders.report.Ports.WebServices;
import com.orders.report.Domain.Models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "product", url = "http://localhost:9070")
public interface IProductService {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    Product getProduct(@PathVariable("id") Integer id);

}
