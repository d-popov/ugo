
public abstract class AbstractVariadicOperator implements Formula {
	private Formula[] operands;
	
	public AbstractVariadicOperator(Formula... operands) {
		this.operands = operands ;
	}
	@Override public String asString () {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		for (int index = 0; index < operands.length ; index ++){
		if (index > 0) stringBuilder.append(symbol());
		stringBuilder.append(operands[index].asString());
		}
		stringBuilder.append(")");
		return stringBuilder.toString();
		}
	@Override public double asValue () {
		double accumulator = initialValue ();
		for ( int index = 0; index < operands.length ; index ++) {
		double formulaValue = operands[index].asValue();
		accumulator = cumulativeValue( accumulator , formulaValue );
		}
		return accumulator ;
		}
	protected abstract String symbol ();
	protected abstract double initialValue ();
	protected abstract double cumulativeValue ( double accu , double value );
}
