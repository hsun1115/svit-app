package com.svit.java.p1;
/**
 * City A has following four types of items: 
 *  1. domestic BFM (TYPE_BFM) books, food and medical products
 *  2. imported BFM (TYPE_BFM_IMPORT) 
 *  3. domestic other goods (TYPE_OTHER_GOODS) all goods, except boos, food, and medical products
 *  4. imported other goods (TYPE_OTHER_GOODS_IMPORT) 
 * 
 * And each item category has following tax regulation: 
 * 	1. BFM items has local sale tax 10% based on list price
 * 	2. other goods has NO local sale tax
 * 	3. any imported item has import tax 5%
 * 
 * Thinking in Java with OOP, design a SALES TAXES solution and shopping cart.  
 * Calculate and print total tax and total price for each input of items.  
 * for examples:
 * 
 *  input 1: 
 *  [type definition]  [category]  [quantity] [price]	
 *  TYPE_BFM, "book", 1, 12.49
 *	TYPE_OTHER_GOODS, "music CD", 1, 14.99
 *	Item.TYPE_BFM, "chocolate bar", 1, 0.85
 *  
 *  input 1 expected total tax:$1.50; expected total: $29.83
 *  
 *  
 *  input 2: 
 *  [type definition]  [category]  [quantity] [price]	
 *  TYPE_BFM_IMPORT, "imported box of chocolates", 1, 10.00
 *	TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 47.50
 *  
 *  input 2 expected total tax:$7.65; expected total: $65.15
 *  
 *  
 *  input 3: 
 *  [type definition]  [category]  [quantity] [price]	
 *  TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 27.99
 *	TYPE_OTHER_GOODS, "bottle of perfume", 1, 18.99
 * 	Item.TYPE_BFM, "packet of headache pills", 1, 9.75
 * 	Item.TYPE_BFM_IMPORT, "box of imported chocolates", 1, 11.25
 *  
 *  input 3 expected total tax:$6.70; expected total: $74.68
 * 
 *  Code is for studying purpose, not for commercial use.
 * 	copyright of 
 * 
 * @author sv-it.org
 *
 */
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import java.text.DecimalFormat;
import java.lang.Math;

/*
 * custom exception class
 */
class ItemException extends Exception{

	private static final long serialVersionUID = 1L;
	private String detail;
	
	ItemException(String a){
		detail = a;	
	}	
	
	public String toString(){
		return "ItemException[" + detail + "]";	
	}
}

/*
 * define a separate Tax class
 */
class Tax{
	public static final double SALE_TAX = 0.10;
	public static final double IMPORT_TAX = 0.05;
	
	private double saleTax = 0.0;
	private double importTax = 0.0;
	
	public void calculateTax(boolean isTaxable, boolean isImported, double price){
		if (isTaxable){
			saleTax = price*SALE_TAX;
		}	
		
		if (isImported){
			importTax = price*IMPORT_TAX;	
		}
	}
	
	public double getTotalItemTax(){
		//Use ceil(double/0.05 )*0.05 to round the sales tax up to the nearest 0.05
		return Math.ceil((this.saleTax + this.importTax)/0.05 )*0.05;
	}	
}

/*
 * define an Item interface
 */
interface Item{
	public static final int TYPE_BFM = 1; //books, food and medical products
	public static final int TYPE_OTHER_GOODS = 2;//all goods, except boos, food, and medical products
	public static final int TYPE_BFM_IMPORT = 3;//(imported)books, food and medical products
	public static final int TYPE_OTHER_GOODS_IMPORT = 4; //(imported)all goods, except boos, food, and medical products
	
	public double getExtendedTax();
	public double getExtendedTaxPrice() throws ItemException;
	public void setImported(boolean b);
	public String getDescription();
}

/*
 * define abstract class
 */
abstract class Goods implements Item{
	private String description;
	private int quantity;
	private double price;
	private Tax tax = new Tax();
	
	public Goods(String description, int quantity, double price){
		this.description = description;
		this.quantity = quantity;
		this.price = price;	
	}
	
	protected abstract boolean isTaxable();
	protected abstract boolean isImported();
	
	public double getExtendedTax(){
		tax.calculateTax(isTaxable(), isImported(), price);
		return this.tax.getTotalItemTax()*quantity;	
	}
	
	public double getExtendedTaxPrice() throws ItemException{
		if(tax==null)	
			throw new ItemException("Tax should be calculated first!");
			
		return quantity*(this.tax.getTotalItemTax()+price);
	}
	
	public String getDescription(){
		return description;	
	}
	
	public String toString(){
		return (quantity + " " + description + ": ");	
	}
}

/*
 * BFM(book, food, medical)
 */
class BFM extends Goods{
	private boolean isTaxable = false; //BFM HAS NO local tax
	private boolean isImported = false; 
	
	public BFM(String description, int quantity, double price){
		super(description, quantity, price);	
	}	
	
	public boolean isTaxable(){
		return isTaxable;	
	}
	
	public boolean isImported(){
		return isImported;
	}
	
	public void setImported(boolean b){
		isImported = b;	
	}
}

/*
 * All other goods except BFM(book, food, medical)
 */
class OtherGoods extends Goods{
	private boolean isTaxable = true; //OtherGoods HAS local tax
	private boolean isImported = false; 
	
	public OtherGoods(String description, int quantity, double price){
		super(description, quantity, price);	
	}	
	
	public boolean isTaxable(){
		return isTaxable;	
	}
	
	public boolean isImported(){
		return isImported;	
	}
	
	public void setImported(boolean b){
		isImported = b;	
	}
}

/*
 * define ItemFactory to create BFM or other goods
 */
abstract class ItemsFactory{
	public abstract Item getItem(int itemType, String description, int quantity, double price) throws ItemException;	
}

/*
 * GoodsFactory extends ItemFactory, using factory design pattern
 */

class GoodsFactory extends ItemsFactory{
	protected GoodsFactory(){
	}
	
	public Item getItem(int itemType, String description, int quantity, double price) throws ItemException{
		Item item = null;
		
		if(itemType == Item.TYPE_BFM){
			item = new BFM(description, quantity, price);	
		} else if(itemType == Item.TYPE_OTHER_GOODS){
			item = new OtherGoods(description, quantity, price);	
		} else if(itemType == Item.TYPE_OTHER_GOODS_IMPORT){
			item = new OtherGoods(description, quantity, price);
			item.setImported(true);	
		} else if(itemType == Item.TYPE_BFM_IMPORT){
			item = new BFM(description, quantity, price);
			item.setImported(true);
		} else
			throw new ItemException("itemType : " + itemType + " is invalid.");
			
		return item;
	}
}

/*
 * Build shopping cart
 */
interface ItemBuilder{
	public void buildCart(int itemType, String description, int quantity, double price) throws ItemException;
	public double calculateTotalTax() throws ItemException;
	public double calculateTotal() throws ItemException;
	public void printExtendedTaxedPrice() throws ItemException;
	public Iterator<Item> getIterator();
	public void clearCart();
}

class CartBuilder implements ItemBuilder{

	private List<Item> listItems = null;
	
	private void addItem(Item item){
		if (listItems == null)
			listItems = new ArrayList<Item>();
		
		listItems.add(item);
	}
	
	/*
	 * building shopping cart(non-Javadoc)
	 * @see com.svit.java.p1.ItemBuilder#buildCart(int, java.lang.String, int, double)
	 */
	public void buildCart(int itemType, String description, int quantity, double price) throws ItemException{
		GoodsFactory goodsFactory = new GoodsFactory();
		Item item = goodsFactory.getItem(itemType, description, quantity, price);
		this.addItem(item);
	}
	
	/*
	 * calculate total tax of cart items(non-Javadoc)
	 * @see com.svit.java.p1.ItemBuilder#calculateTotalTax()
	 */
	public double calculateTotalTax() throws ItemException{
		double totalTax = 0.0;
		
		if (listItems == null)
			throw new ItemException("Shopping cart is empty");
		
		Iterator<Item> goodsItr = listItems.iterator();
		
		while(goodsItr.hasNext()){
			Item item = (Item)goodsItr.next();
			totalTax += item.getExtendedTax();	
		}
		
		return totalTax;
	}
	
	
	/*
	 * calculate total price of cart items(non-Javadoc)
	 * @see com.svit.java.p1.ItemBuilder#calculateTotal()
	 */
	public double calculateTotal() throws ItemException{
		double total = 0.0;
		
		if (listItems == null)
			throw new ItemException("Shopping cart is empty");	
		
		Iterator<Item> goodsItr = listItems.iterator();
		
		while(goodsItr.hasNext()){
			Item item = (Item)goodsItr.next();
			total += item.getExtendedTaxPrice();	
		}	
		
		return total;
	}
	
	
	/*
	 * print price information for each item in shopping cart(non-Javadoc)
	 * @see com.svit.java.p1.ItemBuilder#printExtendedTaxedPrice()
	 */
	public void printExtendedTaxedPrice() throws ItemException{
		if (listItems == null)
			throw new ItemException("Shopping cart is empty");
			
		Iterator<Item> goodsItr = listItems.iterator();
		
		while(goodsItr.hasNext()){
			Item item = (Item)goodsItr.next();

			//output formatted value
			NumberFormat f = new DecimalFormat("0.00");
			System.out.println(item + " " + f.format(item.getExtendedTaxPrice()));
		}
	}
	
	public Iterator<Item> getIterator(){
		return listItems.iterator();
	}
	
	public void clearCart(){
		if (listItems != null)
			listItems.clear();	
	}
	public String toString() {
		NumberFormat f = new DecimalFormat("0.00");
		double totaltax=0.0;
		double total=0.0;
		try {
			totaltax = this.calculateTotalTax();
			total = this.calculateTotal();
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Sales Taxes:"+ f.format(totaltax) + "\n" + "Total:" + f.format(total);
	}
}

/*
 * main function to simulate SALES TAXES OO solution
 */
public class SalesTaxesDemo1{
	public static void main(String[] args) throws ItemException{
		//output formatted value
		NumberFormat f = new DecimalFormat("0.00");
					
		//Build shopping cart
		ItemBuilder builder = new CartBuilder();
		
		//input 1: 12.49
		builder.buildCart(Item.TYPE_BFM, "book", 1, 12.49);
		builder.buildCart(Item.TYPE_OTHER_GOODS, "music CD", 1, 14.99);
		builder.buildCart(Item.TYPE_BFM, "chocolate bar", 1, 0.85);
		
		//print result of input 1
		System.out.println("\nShopping Cart 1: ");
		double totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales Taxes: " + f.format(totalTax));
		System.out.println("Total:" + f.format(builder.calculateTotal()));
			
		
		builder.clearCart();
		
		//input 2
		builder.buildCart(Item.TYPE_BFM_IMPORT, "imported box of chocolates", 1, 10.00);
		builder.buildCart(Item.TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 47.50);
		
		System.out.println("\nShopping Cart 2: ");
		totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
//		System.out.println("Sales Taxes: " + f.format(totalTax));
//		System.out.println("Total:" + f.format(builder.calculateTotal()));
		System.out.println(builder);
		
		builder.clearCart();
		
		//input 3
		builder.buildCart(Item.TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 27.99);
		builder.buildCart(Item.TYPE_OTHER_GOODS, "bottle of perfume", 1, 18.99);
		builder.buildCart(Item.TYPE_BFM, "packet of headache pills", 1, 9.75);
		builder.buildCart(Item.TYPE_BFM_IMPORT, "box of imported chocolates", 1, 11.25);
		
		System.out.println("\nShopping Cart 3: ");
		totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();		
		System.out.println("Sales Taxes: " + f.format(totalTax));
		System.out.println("Total:" + f.format(builder.calculateTotal()));
		
	}	
}