package com.example.shopping_basket.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tab_order")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Getter(AccessLevel.NONE)           // omitting of getter (we need other getter)
    @Transient
    @Column(name = "number_of_items")
    private int numberOfItems;

    @Column(name = "taxes")
    private Double taxes;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Getter(AccessLevel.NONE)           // omitting of getter (we need other getter)
    @Setter(AccessLevel.NONE)           // omitting of setter (not needed)
    @Column(name = "total")
    @Transient
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    private StoreModel product;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<BuyingModel> items;

    @Column(name = "token_session")
    private String tokenSession;

    /* we need a getter like this for total */
    public Double getTotal() {
        Double sum = 0.0;
        for(BuyingModel item : this.items) {
            sum += item.getProduct().getPrice();
        }
        return sum;
    }

    /* we need length of collection */
    public int getNumberOfItems() {
        return this.items.size();
    }
}
