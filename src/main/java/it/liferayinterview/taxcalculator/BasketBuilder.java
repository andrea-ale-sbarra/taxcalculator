
package it.liferayinterview.taxcalculator;



import it.liferayinterview.taxcalculator.BasketItem.BasketItemFactory;





public class BasketBuilder
{
	Basket basket;

	public static BasketBuilder init( String name)
	{
		BasketBuilder instance = new BasketBuilder( );
		instance.basket = new Basket( name );
		return instance;
	}

	public BasketBuilder addGood( Good good )
	{
		if ( ! this.basket.items.containsKey( good.name ) )
		{
			this.basket.items.put( good.name, BasketItemFactory.createBasketItem( good ) );
		}
		else
		{
			this.basket.items.get( good.name ).quantity ++ ;
		}
		return this;
	}

	public Basket build( )
	{
		return basket;
	}
}
