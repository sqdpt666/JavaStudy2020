package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

public class Goods implements Comparable{

    String name;
    int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式:价格从低到搞
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods=(Goods) o;
            if(this.price>goods.price){
                return 1;
            }else if (this.price<goods.price){
                return -1;
            }else{
                return this.name.compareTo(goods.name);
            }
        }else {
            throw new RuntimeException("异常");
        }
    }
}
