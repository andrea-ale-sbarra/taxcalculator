
package it.liferayinterview.taxcalculator;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.liferayinterview.taxcalculator.BasketItem.BasketItemFactory;





public class TotalCalculatorEngineTest
{
	private static final double DELTA = 1e-15;

	@Test
	public void testCalculateTaxedPrice( )
	{
		BasketItem item = BasketItemFactory.createBasketItem( Good.GoodFactory.createTaxableGood( 18.99, "Bottle of perfume" ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 20.89, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createNotTaxableGood( 12.49, "Book" ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 12.49, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createTaxableGood( 14.99, "Music CD" ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 16.49, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createNotTaxableGood( 0.85, "Chocolate BAR" ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 0.85, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createImportedNotTaxableGood( 10.00, "Imported box of Chocolate " ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 10.50, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createImportedTaxableGood( 47.50, "Imported bottle of perfume " ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 54.65, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createImportedTaxableGood( 27.99, "Imported bottle of perfume " ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 32.19, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createTaxableGood( 18.99, "bottle of perfume " ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 20.89, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createNotTaxableGood( 9.75, "packet of headache pills" ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 9.75, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );

		item = BasketItemFactory.createBasketItem( Good.GoodFactory.createImportedNotTaxableGood( 11.25, "Imported box of Chocolate " ) );
		assertEquals( "Il prezzo tassato dovrebbe essere", 11.85, TotalCalculatorEngine.INSTANCE.calculateBasketItemTaxed( item ).taxedValue, DELTA );
	}
}
