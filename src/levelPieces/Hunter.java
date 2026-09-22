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
		if (Math.abs(playerLocation - getLocation()) <= 1) {
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
			if (this.getLocation() < gameBoard.length && (gameBoard[this.getLocation() +1] == null)) {
				gameBoard[getLocation()] = null;
				this.setLocation(this.getLocation()+1);
				gameBoard[getLocation()] = this;
			}
			
		}
		else if (playerLocation < super.getLocation()) {
			if (getLocation() > 0 && (gameBoard[this.getLocation() -1] == null)) {
				gameBoard[getLocation()] = null;
				this.setLocation(this.getLocation()-1);
				gameBoard[getLocation()] = this;
			}
		}
		
	}

}
