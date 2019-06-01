
package it.liferayinterview.taxcalculator;

public class BasketItemTaxed
{
	BasketItem	basketItem;

	double		salesTax;
	double		taxedValue;

	public BasketItemTaxed( BasketItem basketItem, double salesTax, double taxedValue )
	{
		super( );
		this.basketItem = new BasketItem( basketItem );
		this.salesTax = salesTax;
		this.taxedValue = taxedValue;
	}

	static BasketItemTaxed of( BasketItem basketItem, double salesTax, double taxedValue )
	{
		BasketItemTaxed instance = new BasketItemTaxed( basketItem, salesTax, taxedValue );
		return instance;
	}
}
