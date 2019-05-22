
public class Sum extends AbstractVariadicOperator {
	public Sum ( Formula ... operands ) { super ( operands ); }
	@Override protected String symbol () { return "+"; }
	@Override protected double initialValue () { return 0; }
	@Override protected double cumulativeValue ( double accu , double value ) {
	return accu + value ;
	}
	public <R> R accept(FormulaVisitor<R> v){
		return v.visit(this);
	}
}
