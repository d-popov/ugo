
public interface FormulaVisitor<R> {
	public R visit (Variable v); 
	public R visit (Constant c); 
	public R visit (Sum sum);
	public R visit (Product p);
}
