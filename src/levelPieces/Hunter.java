package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Hunter extends GamePiece implements Moveable {

	
	public Hunter(int location)  {
		super('H', "Can deal damage to player when on the same tile.", location);
		
		
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}

	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Hunter cannot move past rocks, and hunter moves towards player
		if (playerLocation > this.getLocation()) {
			if (this.getLocation() < gameBoard.length && !(gameBoard[this.getLocation() +1] instanceof Rock)) {
				this.setLocation(this.getLocation()+1);
			}
			
		}
		else if (playerLocation < super.getLocation()) {
			if (getLocation() > 0 && !(gameBoard[this.getLocation() -1] instanceof Rock)) {
				setLocation(this.getLocation()-1);
			}
		}
		
	}

}
