
package it.liferayinterview.taxcalculator;

import java.math.BigDecimal;

public class BasketItem
{
	Good	good;
	int		quantity;

	public BasketItem( Good good, int quantity )
	{
		super( );
		this.good = new Good( good );
		this.quantity = quantity;
	}

	public BasketItem( BasketItem item )
	{
		this.good = new Good( item.good );
		this.quantity = item.quantity;
	}

	@Override
	public int hashCode( )
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( good == null ) ? 0 : good.hashCode( ) );
		return result;
	}

	@Override
	public boolean equals( Object obj )
	{
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass( ) != obj.getClass( ) )
			return false;
		BasketItem other = ( BasketItem ) obj;
		if ( good == null )
		{
			if ( other.good != null )
				return false;
		}
		else if ( ! good.equals( other.good ) )
			return false;
		return true;
	}

	@Override
	public String toString( )
	{

		return quantity + " " + good.name + " at " + BigDecimal.valueOf( good.netPrice ).setScale( 2 );
	}

	static class BasketItemFactory
	{
		static BasketItem createBasketItem( Good good )
		{
			return new BasketItem( new Good( good ), 1 );
		}
	}
}
