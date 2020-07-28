package com.collection.comicsandnovel.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class blogUrl {

    @Id
    private Long id;
    @Unique
    private String name;

    @Generated(hash = 2015312800)
    public blogUrl(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 963357834)
    public blogUrl() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "blogUrl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
