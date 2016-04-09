package com.hit.hackgame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.hit.hackgame.main.Yelling;

import static com.hit.hackgame.main.Yelling.ViewPort_HEIGHT;
import static com.hit.hackgame.main.Yelling.ViewPort_WIDTH;
import static com.hit.hackgame.main.Yelling.assetManager;

public class MainScreen extends YellScreen {
	// ������̨
	private Stage stage;
	// �����Ӿ�
	private StretchViewport viewport;
	// ����ͼ��
	private TextureAtlas atlas;
	// ����ͼƬ����
	private Image[] images;
	// ������ʼ����ͼƬ
	private Image image;
	// ��������ͼƬ
	private Image imageBg;
	// ���������뿪ʼ��������
	private Texture bg, startTexture;
	// ������ͬ�����л�����
	public static boolean Debug = true;

	public MainScreen(Yelling game) {
		super(game);
		init();
	}

	public void init() {
		// ʵ�����Ӿ�
		viewport = new StretchViewport(ViewPort_WIDTH, ViewPort_HEIGHT);
		// ʵ������̨
		stage = new Stage(viewport);
		// ��ȡͼ��
		atlas = assetManager.get("images/select.atlas");
		// ��ȡ��������
		bg = assetManager.get("images/bg.png");
		// ��ȡ��ʼ��������
		startTexture = assetManager.get("images/start.png");
		// ʵ������ʼ����ͼƬ�ؼ�
		image = new Image(startTexture);
		// ʵ���������ؼ�
		imageBg = new Image(bg);
		// �趨����ͼƬ��С
		image.setSize(ViewPort_WIDTH, ViewPort_HEIGHT);
		// ʵ����ͼƬ�ؼ�����
		images = new Image[4];
		// ���������ȡͼƬ
		for (int i = 0; i < images.length; i++) {
			// ʵ���������е���ͼƬ
			images[i] = new Image(atlas.findRegion("" + i));
			// ����ͼƬ
			images[i].setScale(0.50f);
		}
		// ����ͼƬλ��
		images[0].setPosition(20, 140);
		// ����ͼƬλ��
		images[1].setPosition(170, 140);
		// ����ͼƬλ��
		images[2].setPosition(20, 20);
		// ����ͼƬλ��
		images[3].setPosition(170, 20);
		// ��ʼ��������
		initListener();
		// ע����̨����
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		// ����
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// ���³����߼�
		update(delta);
		// ������̨�߼�
		stage.act();
		// ������̨
		stage.draw();

	}

	private void initListener() {
		// ��ʼ����ͼƬ�������ȡ�����Ƶ�ǰ��������Debug��ֵΪ�١�
		image.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {

				Debug = false;

				return true;
			}
		});
		images[0].addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// ��ȡ��Ч
				Sound s = assetManager.get("audio/select.wav");
				// ������Ч
				s.play();
				// ���õ�ǰͼƬΪ�����һ��
				GameScreen.level = 0;
				// ʵ������һ����Ϸ����
				GameScreen g = new GameScreen(game);
				// ����ǰ��������ջ��
				game.setScreen(g);
				return true;
			}
		});
		images[1].addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Sound s = assetManager.get("audio/select.wav");
				s.play();
				GameScreen.level = 1;
				GameScreen g = new GameScreen(game);
				game.setScreen(g);
				return true;
			}
		});
		images[2].addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Sound s = assetManager.get("audio/select.wav");
				s.play();
				GameScreen.level = 2;
				GameScreen g = new GameScreen(game);
				game.setScreen(g);
				return true;
			}
		});
		images[3].addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Sound s = assetManager.get("audio/select.wav");
				s.play();
				GameScreen.level = 3;
				GameScreen g = new GameScreen(game);
				game.setScreen(g);
				return true;
			}
		});
	}

	@Override
	public void hide() {
		// ��ǰ��������ʱ�������̨��Ա
		stage.clear();
		// ������̨
		stage.dispose();
	}

	@Override
	public void handleInput() {
	}

	@Override
	public void update(float dt) {
		// ���DebugΪ��Ļ�����յ�ǰ��̨������Ա������ʼͼƬ������̨
		if (Debug) {
			// �����̨
			stage.getActors().clear();
			// ��ӿ�ʼͼƬ����̨
			stage.addActor(image);
		} else {
			// �����̨
			stage.getActors().clear();
			// �����Ϸ����
			stage.addActor(imageBg);
			// ����ͼƬ�ؼ����飬��ӵ���̨
			for (int i = 0; i < images.length; i++) {
				stage.addActor(images[i]);
			}
		}
	}

}
