package main.java.com.veena.hello.dvo;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
@Table(name = "sales_by_film_category", schema = "sakila", catalog = "")
public class SalesByFilmCategory {
    private String category;
    private BigDecimal totalSales;

    @Basic
    @Column(name = "category", nullable = false, length = 25)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "total_sales", nullable = true, precision = 2)
    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesByFilmCategory that = (SalesByFilmCategory) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (totalSales != null ? !totalSales.equals(that.totalSales) : that.totalSales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (totalSales != null ? totalSales.hashCode() : 0);
        return result;
    }
}
