
public class Product extends AbstractVariadicOperator {
	public Product ( Formula ... operands ) { super ( operands ); }
	@Override protected String symbol () { return "*"; }
	@Override protected double initialValue () { return 1; }
	@Override protected double cumulativeValue ( double accu , double value ) {
	return accu * value ;
}
/**
 * 
 * 	
	@Override 
	public String asString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (int index = 0; index < operands.length ; index ++){
			if (index > 0) {
				//stringBuilder.append(this.symbol());
				stringBuilder.append(this.symbol());
			}
			//stringBuilder.append(operands[index].accept());
			stringBuilder.append(operands[index].asString());
		}
		return stringBuilder.toString();


	}
 *  */

	public <R> R accept(FormulaVisitor<R> v)	{	
		//return super.asString();	
		return v.visit(this);
	}
}
