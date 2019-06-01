
package it.liferayinterview.taxcalculator;



import java.math.BigDecimal;
import java.util.function.Function;





public enum TotalCalculatorEngine
{
	INSTANCE;

	public Function < Good, Double > calculateGoodTax = g -> {
		BigDecimal _netPrice = new BigDecimal( Double.toString( g.netPrice ) );
		BigDecimal _taxRate = new BigDecimal( Double.toString( g.taxRate ) );
		BigDecimal ret = _taxRate.multiply( _netPrice ).divide( new BigDecimal( 100 ) );
		BigDecimal rounded = ret.setScale( 2, BigDecimal.ROUND_UP );

		Double retD = Math.ceil( rounded.doubleValue( ) * 20.0 ) / 20.0;

		return retD;
	};

	public BasketTotal init( String name )
	{
		return new BasketTotal( name );
	}

	public String printTotal( Basket basket )
	{
		BasketTotal basketTotal = init( basket.name );
		basket.items.values( ).stream( ).forEach( i -> {
			basketTotal.addBasketItemTaxed( calculateBasketItemTaxed( i ) );
		} );

		return basketTotal.toString( );
	}

	public BasketItemTaxed calculateBasketItemTaxed( BasketItem item )
	{
		double salesTax = calculateGoodTax.apply( item.good );
		double taxedValue = BigDecimal.valueOf( calculateGoodTax.apply( item.good ) ).add( BigDecimal.valueOf( item.good.netPrice ) ).multiply( BigDecimal.valueOf( item.quantity ) ).doubleValue( );

		BasketItemTaxed basketItemTaxed = BasketItemTaxed.of( item, salesTax, taxedValue );

		return basketItemTaxed;
	}
}
