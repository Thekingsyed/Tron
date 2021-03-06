package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("car.png");
		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
	}

	@Override
	public void render () {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
				sprite.translateX(-3f);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprite.translateX(3f);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
            sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
                    Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);

        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
            sprite.setPosition(Gdx.input.getX(),Gdx.graphics.getHeight() - Gdx.input.getY());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
