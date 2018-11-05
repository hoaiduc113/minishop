package com.hoaiduc.core.persistence.data.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="imageproduct")
public class ImageProduct
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImageProduct;
    private String image;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idImageProduct")
    private List<DetailProduct> listDetailProduct;

    public int getIdImageProduct() {
        return idImageProduct;
    }

    public void setIdImageProduct(int idImageProduct) {
        this.idImageProduct = idImageProduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<DetailProduct> getListDetailProduct() {
        return listDetailProduct;
    }

    public void setListDetailProduct(List<DetailProduct> listDetailProduct) {
        this.listDetailProduct = listDetailProduct;
    }
}
