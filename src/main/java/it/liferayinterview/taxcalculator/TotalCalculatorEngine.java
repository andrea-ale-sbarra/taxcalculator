
package it.liferayinterview.taxcalculator;



import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Function;





public enum TotalCalculatorEngine
{
	INSTANCE;

	private static final BigDecimal		ROUND_TO			= new BigDecimal( "0.05" );

	public Function < Good, Double >	calculateGoodTax	= g -> {
																BigDecimal _netPrice = new BigDecimal( Double.toString( g.netPrice ) );
																BigDecimal _taxRate = new BigDecimal( Double.toString( g.taxRate ) );
																BigDecimal ret = _taxRate.multiply( _netPrice ).divide( new BigDecimal( 100 ) );
																BigDecimal rounded = round( ret );
																return rounded.doubleValue( );
															};

	private BigDecimal round( BigDecimal value )
	{
		value = value.divide( ROUND_TO );
		value = new BigDecimal( Math.ceil( value.doubleValue( ) ) );
		value = value.multiply( ROUND_TO );
		return value;
	}

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
