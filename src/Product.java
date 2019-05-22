
public class Product extends AbstractVariadicOperator {
	public Product ( Formula ... operands ) { super ( operands ); }
	@Override protected String symbol () { return "*"; }
	@Override protected double initialValue () { return 1; }
	@Override protected double cumulativeValue ( double accu , double value ) {
	return accu * value ;
	}
	public <R> R accept(FormulaVisitor<R> v){
		return v.visit(this);
	}
}
