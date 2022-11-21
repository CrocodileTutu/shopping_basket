package com.example.shopping_basket.model;

import com.example.shopping_basket.model.StoreModel;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tab_buying")
public class BuyingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item")
    private String item;

    @Column(name = "price")
    private String price;

    @Column(name = "price_and_tax")
    private String priceAndTax;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private StoreModel product;
}
