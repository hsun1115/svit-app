package com.svit.java.p1;
/**
 * City A has its own sales tax and import tax for all goods/items . 
 * 
 * There are three types of items: 
 *  1. domestic BFM (TYPE_BFM) books, food and medical products
 *  2. imported BFM (TYPE_BFM_IMPORT) 
 *  3. domestic other goods (TYPE_OTHER_GOODS) all goods, except boos, food, and medical products
 *  4. imported other goods (TYPE_OTHER_GOODS_IMPORT) 

 * 
 * local sale tax is 10%, and import tax is 5%. 
 * 
 * Thinking in Java with OOP, design a SALES TAXES solution and shopping cart. 
 * Calculate and print total tax and total price for each input of items 
 * for examples:
 * 
 *  input 1: 
 *  type definition,  category,   quantity,  price	
 *  TYPE_BFM, "book", 1, 12.49
 *	TYPE_OTHER_GOODS, "music CD", 1, 14.99
 *	TYPE_BFM, "chocolate bar", 1, 0.85
 *  
 *  
 *  input 2: 
 *  type definition,  category,   quantity,  price	
 *  TYPE_BFM_IMPORT, "imported box of chocolates", 1, 10.00
 *	TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 47.50
 *  
 *  input 3: 
 *  TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 27.99
 *	TYPE_OTHER_GOODS, "bottle of perfume", 1, 18.99
 * 	TYPE_BFM, "packet of headache pills", 1, 9.75
 * 	TYPE_BFM_IMPORT, "box of imported chocolates", 1, 11.25
 *  
 * 
 * Create a custom exception type if needed
 *   
 * Code is for studying purpose, not for commercial use.
 * copyright of sv-it.org
 * 
 * @author sv-it.org
 *
 */
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.text.DecimalFormat;
import java.lang.Math;

/*
 * define custom exception: ItemException
 */
class ItemException extends Exception{

}

/*
 * define a Tax class
 *
 */
class Tax{
	
}

/*
 * define a Item interface  
 *
 */
interface Item{

}

/*
 * define an abstract class to reuse subclass, BFM(book, food, medical), and other goods
 */
abstract class Goods implements Item{

}

/*
 * All goods except BFM(book, food, medical)
 */
class OtherGoods extends Goods{

}

/*
 * BFM(book, food, medical)
 */
class BFM extends Goods{

}

/*
 * Createa ItemFactory to create BFM or other goods
 */
abstract class ItemsFactory{
	public abstract Item getItem(int itemType, String description, int quantity, double price) throws ItemException;	
}

/*
 * main function to simulate SALES TAXES OO solution
 */
public class SalesTaxesDemo{
	public static void main(String[] args) throws ItemException{
	
	}	
}