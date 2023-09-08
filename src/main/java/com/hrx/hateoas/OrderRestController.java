package com.hrx.hateoas;

import org.aspectj.weaver.ast.Or;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
    List<Order> orders = new ArrayList<>();
    OrderRestController(){
        Order order1 = new Order();
        order1.setId(1);
        order1.setName("Cup cake");
        order1.setNumberOfOrder(5);

        Order order2 = new Order();
        order2.setId(2);
        order2.setName("Sand-witch");
        order2.setNumberOfOrder(2);
        orders.add(order1);
        orders.add(order2);
    }

@GetMapping()
public List<Order> orders(){
    return orders;
}

@GetMapping("/{id}")
    public Order order(@PathVariable("id") Integer id){
        Order order = orders.stream().filter(u -> u.getId() == id).findFirst().get();
    Link link = linkTo(OrderRestController.class).withSelfRel();
    order.add(link);
    return order;
}
}
