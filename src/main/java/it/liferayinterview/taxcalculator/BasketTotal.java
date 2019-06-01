
package it.liferayinterview.taxcalculator;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;





public class BasketTotal
{
	String						name;
	List < BasketItemTaxed >	taxedItems;

	double						total;
	double						netTotal;
	double						salesTaxes;

	public BasketTotal( String name )
	{
		this.name = name;
	}

	public void addBasketItemTaxed( BasketItemTaxed taxedItem )
	{
		if ( this.taxedItems == null )
		{
			this.taxedItems = new ArrayList < BasketItemTaxed >( );
		}

		this.taxedItems.add( taxedItem );
		this.salesTaxes += taxedItem.salesTax;
		this.total += taxedItem.taxedValue;
	}

	@Override
	public String toString( )
	{
		StringBuilder sb = new StringBuilder( "OUTPUT " );
		sb.append( name ).append( ":" ).append( "\n\r" );

		for ( BasketItemTaxed item : taxedItems )
		{
			sb.append( item.basketItem.quantity )
				.append( " " )
				.append( item.basketItem.good.name )
				.append( ": " )
				.append( BigDecimal.valueOf( item.taxedValue ).setScale( 2, RoundingMode.HALF_UP ) )
				.append( "\n\r" );
		}

		sb.append( "Sales taxes: " ).append( BigDecimal.valueOf( salesTaxes ).setScale( 2, RoundingMode.HALF_UP ) ).append( "\n\r" )
			.append( "Total: " ).append( BigDecimal.valueOf( total ).setScale( 2, RoundingMode.HALF_UP ) ).append( "\n\r" ).append( "\n\r" );
		return sb.toString( );
	}
}
