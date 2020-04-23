package com.project.models;

import java.util.List;
import com.project.models.Product;

public class Stock {
 
private String[] products;
private int tid;
 
public String[] getProducts() {
return this.products;
}
 
public void setProducts(String[] products) {
this.products = products;
}
public int getTid() {
	return this.tid;
}
public void setTid(int tid) {
	this.tid = tid;
}

 
}