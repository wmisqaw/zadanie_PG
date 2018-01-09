package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Hello extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	ShapeRenderer shapeRenderer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		img = new Texture("homer.png");
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
		//shapeRenderer.rect(200, 200, 20, 20);
		for (int x = 0; x < 11; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				shapeRenderer.rect(Gdx.graphics.getWidth() - (float) (x * 30) , Gdx.graphics.getHeight () - (float) (y * 30), (float) 20, (float) 20);
				//shapeRenderer.rect((float) (x + 20) , (float) (y + 20) ,(float) 20, (float) 20);
				//shapeRenderer.setColor(com.badlogic.gdx.graphics.Color.BLACK);
			}
		}
		/*shapeRenderer.setColor(1, 0, 0, 1);
		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 8; y++) {
				shapeRenderer.rect(Gdx.graphics.getWidth() - (float) (x * 30 + 5), Gdx.graphics.getHeight() - (float) (y * 30 + 5), (float) 20, (float) 20);
			}
		}*/
		shapeRenderer.end();


		/*batch.begin();
		batch.draw(img, Gdx.graphics.getWidth()/2 - img.getWidth()/2, Gdx.graphics.getHeight()/2 - img.getHeight()/2);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
