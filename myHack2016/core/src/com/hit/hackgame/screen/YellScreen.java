package com.hit.hackgame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.hit.hackgame.main.Yelling;

public abstract class YellScreen implements Screen {
	// �������黭��
	protected SpriteBatch batch;
	// �����������
	protected OrthographicCamera camera;
	// �����ؼ����
	protected OrthographicCamera uiCam;
	// ������Ϸ����������
	Yelling game;

	public YellScreen(Yelling game) {
		// ��������ֵ
		this.game = game;
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		Gdx.input.setCatchBackKey(true);
		batch = game.getBatch();
		camera = game.getCamera();
		uiCam = game.getUiCam();
	}

	public abstract void handleInput();
	public abstract void update(float dt);

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
