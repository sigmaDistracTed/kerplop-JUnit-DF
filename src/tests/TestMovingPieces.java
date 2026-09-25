package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Apple;
import levelPieces.Hole;
import levelPieces.Spikes;
import levelPieces.Trophy;


public class TestMovingPieces {
	
	@Test
	public void testApple() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Apple apple = new Apple(7);
		gameBoard[7] = apple;
		
		assertEquals(InteractionResult.GET_POINT, apple.interact(gameBoard, 7));
		
		for(int i = 0; i < 7; i++) {
			assertEquals(InteractionResult.NONE, apple.interact(gameBoard, i));
		}
		
		for(int i = 8; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, apple.interact(gameBoard, i));
		}
	}
	
	@Test
	public void testSpikes() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Spikes spikes = new Spikes(7);
		gameBoard[7] = spikes;
		
		assertEquals(InteractionResult.HIT, spikes.interact(gameBoard, 7));
		
		for(int i = 0; i < 7; i++) {
			assertEquals(InteractionResult.NONE, spikes.interact(gameBoard, i));
		}
		
		for(int i = 8; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, spikes.interact(gameBoard, i));
		}
	}

	@Test
	public void testTrophy() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Trophy trophy = new Trophy(7);
		gameBoard[7] = trophy;
		
		assertEquals(InteractionResult.ADVANCE, trophy.interact(gameBoard, 7));
		
		for(int i = 0; i < 7; i++) {
			assertEquals(InteractionResult.NONE, trophy.interact(gameBoard, i));
		}
		
		for(int i = 8; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, trophy.interact(gameBoard, i));
		}
	}
	
	@Test
	public void testHole() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Hole hole = new Hole(7);
		gameBoard[7] = hole;
		
		assertEquals(InteractionResult.KILL, hole.interact(gameBoard, 7));
		
		for(int i = 0; i < 7; i++) {
			assertEquals(InteractionResult.NONE, hole.interact(gameBoard, i));
		}
		
		for(int i = 8; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, hole.interact(gameBoard, i));
		}
	}
}
