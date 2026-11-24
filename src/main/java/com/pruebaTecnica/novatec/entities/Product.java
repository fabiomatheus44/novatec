package com.pruebaTecnica.novatec.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    @Column(nullable=false, length=100)
    private String productName;

    @Enumerated(EnumType.STRING) @Column(nullable=false, length=10)
    private ProductType productType;

    protected Product() {}
    public Product(String productId, String name, ProductType type) 
    {
        this.productId=productId;
        this.productName=name;
        this.productType=type;
    }
    public String getProductId()
    {
        return productId;
    }
    public String getName()
    {
        return productName;
    }
    public ProductType getType()
    {
        return productType;
    }


}
