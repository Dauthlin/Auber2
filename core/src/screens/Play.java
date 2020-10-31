package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import entities.Player;

public class Play implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private Player player;

    @Override
    public void show() {
        map = new TmxMapLoader().load("testmap.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();

        player = new Player(new Sprite(new Texture("Sprite64.png")),(TiledMapTileLayer)map.getLayers().get(0));
        player.setPosition(player.getX() + 30, player.getY() + 30);

        camera.position.set(player.getX(),player.getY(),0);

        Gdx.input.setInputProcessor(player);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(player.getX() + player.getWidth()/2,player.getY() + player.getHeight()/2,0);
        camera.update();

        renderer.render();

        update(delta);

        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        renderer.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width/2f;
        camera.viewportHeight = height/2f;
    }

    public void handleInput(float time) {
//        if(Gdx.input.isKeyPressed(Input.Keys.W))
//        {
//            camera.position.y += 100 * time;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.S))
//        {
//            camera.position.y -= 100 * time;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.A))
//        {
//            camera.position.x -= 100 * time;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.D))
//        {
//            camera.position.x += 100 * time;
//        }
    }

    public void update(float time) {
        handleInput(time);

        camera.update();
        renderer.setView(camera);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        player.getTexture().dispose();
    }
}
