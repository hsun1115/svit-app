//package com.svit.java.p1;
//
///**
// * City A has its own sales tax and import tax for all goods/items . 
// * 
// * There are three types of items: 
// *  1. domestic BFM (TYPE_BFM) books, food and medical products
// *  2. imported BFM (TYPE_BFM_IMPORT) 
// *  3. domestic other goods (TYPE_OTHER_GOODS) all goods, except boos, food, and medical products
// *  4. imported other goods (TYPE_OTHER_GOODS_IMPORT) 
//
// * 
// * local sale tax for BFM is 10%,
// * local sale tax for other goods is 8%
// * import tax is 5%. 
// * 
// * Thinking in Java with OOP, design a SALES TAXES solution and shopping cart. 
// * Calculate and print total tax and total price for each input of items 
// * for examples:
// * 
// *  input 1: 
// *  type definition,  category,   quantity,  price	
// *  TYPE_BFM, "book", 1, 12.49
// *	TYPE_OTHER_GOODS, "music CD", 1, 14.99
// *	TYPE_BFM, "chocolate bar", 1, 0.85
// *  
// *  
// *  input 2: 
// *  type definition,  category,   quantity,  price	
// *  TYPE_BFM_IMPORT, "imported box of chocolates", 1, 10.00
// *	TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 47.50
// *  
// *  input 3: 
// *  TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 27.99
// *	TYPE_OTHER_GOODS, "bottle of perfume", 1, 18.99
// * 	TYPE_BFM, "packet of headache pills", 1, 9.75
// * 	TYPE_BFM_IMPORT, "box of imported chocolates", 1, 11.25
// *  
// * 
// * Create a custom exception type if needed
// *   
// * Code is for studying purpose, not for commercial use.
// * copyright of sv-it.org
// * 
// * @author sv-it.org
// *
// */
//import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
//
//import java.text.DecimalFormat;
//import java.lang.Math;
//
///*
// * define custom exception: ItemException
// */
//class ItemException extends Exception {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public ItemException(String s) {
//		super(s);
//	}
//}
//
///*
// * define a Tax class
// *
// */
//class Tax {
//	public static final double SALE_TAX = 0.10;
//	
//}
//
///*
// * define a Item interface
// *
// */
//interface Item {
//	public static final int TYPE_BFM = 1;
//	public static final int TYPE_OTHER_GOODS = 2;
//	public static final int TYPE_BFM_IMPORT = 3;
//	public static final int TYPE_OTHER_GOODS_IMPORT = 4;
//
//	public double getExtendedTax();
//
//	public double getExtendedTaxPrice() throws ItemException;
//
//	public void setImported(boolean b);
//
//	public String getDescriotion();
//}
//
///*
// * define an abstract class to reuse subclass, BFM(book, food, medical), and
// * other goods
// */
//abstract class Goods implements Item {
//	private String description;
//	private int quantity;
//	private double price;
//	private Tax tax = new Tax();
//
//	public Goods(String description, int quantity, double price) {
//		this.description = description;
//		this.quantity = quantity;
//		this.price = price;
//	}
//
//	protected abstract boolean isTaxable();
//
//	protected abstract boolean isImported();
//	
//	public double getExtendedTax() {
//		tax.calculateTax(isTaxable(), isImported(), price);
//		return this.getExtendedTax().getTotalItemTax()*quantity;
//	}
//	public double getExtenedeTaxPrice() throws ItemException{
//		if(tax==null)
//			throw new ItemException("Tax should be calculated first!");
//		returnType quantity*(this.tax.getToltalItemTax()+price);
//	}
//	public String getDescription() {
//		return description;
//	}
//	public String toString() {
//		return (quantity+" "+description+": ");
//	}
//}
//
///*
// * All goods except BFM(book, food, medical)
// */
//class OtherGoods extends Goods {
//
//}
//
///*
// * BFM(book, food, medical)
// */
//class BFM extends Goods {
//	private boolean isTaxable = true;
//	private boolean isImported = false;
//
//	public BFM(String description, int quantity, double price) {
//		super(description, quantity, price);
//		// TODO Auto-generated constructor stub
//	}
//
//
//	@Override
//	public void setImported(boolean b) {
//		// TODO Auto-generated method stub
//		isImported=b;
//	}
//
//
//	@Override
//	public boolean isTaxable() {
//		// TODO Auto-generated method stub
//		return isTaxable;
//	}
//
//	@Override
//	public boolean isImported() {
//		// TODO Auto-generated method stub
//		return isImported;
//	}
//
//}
//
///*
// * Createa ItemFactory to create BFM or other goods
// */
//abstract class ItemsFactory {
//	public abstract Item getItem(int itemType, String description, int quantity, double price) throws ItemException;
//}
//
///*
// * main function to simulate SALES TAXES OO solution
// */
//public class SalesTaxesDemo {
//	public static void main(String[] args) throws ItemException {
//
//	}
//}