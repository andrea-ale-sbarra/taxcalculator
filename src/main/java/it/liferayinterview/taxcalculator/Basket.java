
package it.liferayinterview.taxcalculator;



import java.util.LinkedHashMap;
import java.util.Map;





public class Basket
{
	final String name;
	final Map < String, BasketItem > items;

	public Basket(String name )
	{
		this.name = name;
		items = new LinkedHashMap < String, BasketItem >( );
	}
	
	@Override
	public String toString( )
	{
		StringBuilder sb = new StringBuilder( "Input ").append( name ).append( ":\n\r" );
		for ( BasketItem item : items.values( ) )
		{
			sb.append( item.toString( ) ).append( "\n\r" );
			
		}
		return sb.toString( );
	}
}
