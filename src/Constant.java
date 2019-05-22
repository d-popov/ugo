
public class Constant implements Formula {
	private double value;
	public Constant(double d) {
		this.value = d;
	}
	public String asString() {
		return String.valueOf(value);
	}
	@Override public double asValue () { return value ; }
	
	public <R> R accept(FormulaVisitor<R> v){
		return v.visit(this);
	}
}
