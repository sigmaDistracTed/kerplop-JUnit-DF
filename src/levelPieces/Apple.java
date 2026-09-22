package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Apple extends GamePiece{
	
	public Apple(int location) {
		super('A', "Eat the apples to gain points!", location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			gameBoard[getLocation()] = null; 
			return InteractionResult.GET_POINT;
		}
		else {
			return InteractionResult.NONE;
		}
	}

}
