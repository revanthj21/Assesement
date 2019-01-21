package com.Retail.POJO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Paper {
	private int Part;
	private String UOM;
	private double Price;
	private double discount;
	private String Description;

	public Paper(int part, String description, String uOM, double price, double discount) {
		super();
		Part = part;
		Description = description;
		UOM = uOM;
		Price = price;
		this.discount = discount;
	}

	/* Getter and setter methods for Paper class */
	public int getPart() {
		return Part;
	}

	public void setPart(int part) {
		Part = part;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Part;
		long temp;
		temp = Double.doubleToLongBits(Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((UOM == null) ? 0 : UOM.hashCode());
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paper other = (Paper) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Part != other.Part)
			return false;
		if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
			return false;
		if (UOM == null) {
			if (other.UOM != null)
				return false;
		} else if (!UOM.equals(other.UOM))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return this.getDescription() + " " + this.getDiscount() + this.getPart() + " " + this.getPrice() + " "
				+ this.getUOM() + " ";
	}

}
