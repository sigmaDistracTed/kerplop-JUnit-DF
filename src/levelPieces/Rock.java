package levelPieces;
import gameEngine.Drawable;

public class Rock implements Drawable {
	private final char symbol = 'R';
	private int location;
	
	
	
	public Rock(int location) {
		this.location = location;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	
	@Override
	public void draw() {
		System.out.print(this.symbol);
	}
	
	@Override
	public String toString() {
		return this.symbol + " - Rock (Does nothing)";
	}
}
