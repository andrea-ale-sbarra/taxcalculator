
package it.liferayinterview;



import it.liferayinterview.taxcalculator.Basket;
import it.liferayinterview.taxcalculator.BasketBuilder;
import it.liferayinterview.taxcalculator.Good;
import it.liferayinterview.taxcalculator.TotalCalculatorEngine;





public class Main
{
	public static void main( String [ ] args )
	{
		Basket basket1 = BasketBuilder.init( "1" )
			.addGood( Good.GoodFactory.createNotTaxableGood( 12.49, "book" ) )
			.addGood( Good.GoodFactory.createTaxableGood( 14.99, "music CD" ) )
			.addGood( Good.GoodFactory.createNotTaxableGood( 0.85, "chocolate bar" ) )
			.build( );

		Basket basket2 = BasketBuilder.init( "2" )
			.addGood( Good.GoodFactory.createImportedNotTaxableGood( 10.00, "imported box of chocolates" ) )
			.addGood( Good.GoodFactory.createImportedTaxableGood( 47.50, "imported bottle of perfume" ) )
			.build( );

		Basket basket3 = BasketBuilder.init( "3" )
			.addGood( Good.GoodFactory.createImportedTaxableGood( 27.99, "imported bottle of perfume" ) )
			.addGood( Good.GoodFactory.createTaxableGood( 18.99, "bottle of perfume" ) )
			.addGood( Good.GoodFactory.createNotTaxableGood( 9.75, "packet of headache pills" ) )
			.addGood( Good.GoodFactory.createImportedNotTaxableGood( 11.25, "imported box of Chocolate" ) )
			.build( );

		System.out.println( "INPUT" );
		System.out.println( "" );
		System.out.println( basket1.toString( ) );
		System.out.println( basket2.toString( ) );
		System.out.println( basket3.toString( ) );
		System.out.println( "OUTPUT" );
		System.out.println( "" );
		System.out.println( TotalCalculatorEngine.INSTANCE.printTotal( basket1 ) );
		System.out.println( TotalCalculatorEngine.INSTANCE.printTotal( basket2 ) );
		System.out.println( TotalCalculatorEngine.INSTANCE.printTotal( basket3 ) );
	}
}
