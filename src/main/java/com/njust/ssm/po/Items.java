package com.njust.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.njust.ssm.controller.validation.ItemUpdateValidation;


public class Items {
    private Integer id;

    @NotNull(message="{item.name.notnull}")
    @Size(max=30,min=1,message="{item.name.size}")
    private String name;

    @NotNull(message="{item.price.notnull}",groups={ItemUpdateValidation.class})
    private Float price;

    private String pic;

    @NotNull(message="{item.name.createtime.notnull}")
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}