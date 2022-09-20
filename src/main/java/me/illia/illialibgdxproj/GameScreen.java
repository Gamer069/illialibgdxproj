package me.illia.illialibgdxproj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import org.lwjgl.opengl.GL20;

public class GameScreen extends ScreenAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private World world;
	private Box2DDebugRenderer debugRenderer;
	public GameScreen(OrthographicCamera camera) {
		this.camera = camera;
		this.camera.position.set(new Vector3(Boot.INSTANCE.getScreenWidth() / 2, Boot.INSTANCE.getScreenHeight() / 2, 0));
		this.batch = new SpriteBatch();
		this.world = new World(new Vector2(0, 0), true);
		this.debugRenderer = new Box2DDebugRenderer();
	}
	@Override
	public void render(float delta) {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	public void update() {
		world.step(1 / 60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		if (Gdx.input.isKeyPressed(Input.Keys.F1)) {
			Gdx.app.exit();
		}
	}
}
