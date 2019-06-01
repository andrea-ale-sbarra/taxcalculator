
package it.liferayinterview.taxcalculator;

public class Good
{
	final double	netPrice;
	final double	taxRate;
	final String	name;

	Good( double netPrice, double taxRate, String name )
	{
		this.netPrice = netPrice;
		this.taxRate = taxRate;
		this.name = name;
	}

	Good( Good good )
	{
		this.netPrice = good.netPrice;
		this.taxRate = good.taxRate;
		this.name = good.name;
	}

	@Override
	public int hashCode( )
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( name == null ) ? 0 : name.hashCode( ) );
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
		Good other = ( Good ) obj;
		if ( name == null )
		{
			if ( other.name != null )
				return false;
		}
		else if ( ! name.equals( other.name ) )
			return false;
		return true;
	}

	public static class GoodFactory
	{
		/**
		 * Fixed tax rate: 0.0
		 * */
		public static Good createNotTaxableGood( double netPrice, String name )
		{
			return new Good( netPrice, 0.0, name );
		}
		
		/**
		 * Fixed tax rate: 10.0
		 * */
		public static Good createTaxableGood( double netPrice, String name )
		{
			return new Good( netPrice, 10.0, name );
		}

		/**
		 * Configurable tax rate
		 * */
		public static Good createTaxableGood( double netPrice, double taxRate, String name )
		{
			return new Good( netPrice, taxRate, name );
		}

		/**
		 * Fixed import duty: 5.0. This good is not taxable.
		 * */
		public static Good createImportedNotTaxableGood( double netPrice, String name )
		{
			return new Good( netPrice, 5.0, name );
		}

		/**
		 * Fixed imported duty: 5.0 + Fixed tax rate: 10.0
		 * */
		public static Good createImportedTaxableGood( double netPrice, String name )
		{
			return new Good( netPrice, 15.0, name );
		}
		
		/**
		 * Fixed imported duty: 5.0 to be summed to configurable tax rate
		 * */
		public static Good createImportedTaxableGood( double netPrice, double taxRate, String name )
		{
			return new Good( netPrice, taxRate + 5.0, name );
		}
	}
}
