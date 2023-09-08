package com.hrx.hateoas;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
public class Order extends RepresentationModel<Order> {

    private Integer id;
    private String name;
    private Integer numberOfOrder;
}
