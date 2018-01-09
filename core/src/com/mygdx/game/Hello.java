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
		//img = new Texture("homer.png");
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
		img = new Texture("background.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 1, 1);
		for (int x = 0; x < 11; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				shapeRenderer.rect(((Gdx.graphics.getWidth() / 2.0f) + ((5 * 30) / 2.0f)) - (x * 30.0f) , ((Gdx.graphics.getHeight() / 2.0f) + ((2 * 30) / 2.0f)) - (y * 30.0f), 25.0f, 25.0f);
			}
		}
		shapeRenderer.setColor(1, 0, 0, 1);
		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 8; y++) {
				//shapeRenderer.rect(Gdx.graphics.getWidth() - (float) (x * 30 + 5), Gdx.graphics.getHeight() - (float) (y * 30 + 5), 20.0f, 20.0f);
				shapeRenderer.rect(((Gdx.graphics.getWidth() / 2.0f) + ((10 * 30) / 2.0f)) + (x * 28.0f) , ((Gdx.graphics.getHeight() / 2.0f) + ((7 * 30) / 2.0f)) + (y * 28.0f), 20.0f, 20.0f);
			}
		}
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
