package com.hit.hackgame.sprite;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import static com.hit.hackgame.handle.Constant.*;

public class GameSprite {
	// ��������
	protected Body body;
	// �������鶯��
	protected Animation animation;
	// ����������
	protected float width;
	// ��������߶�
	protected float height;

	public GameSprite(Body body) {
		// ���帳ֵ
		this.body = body;
	}

	public void setAnimation(TextureRegion[] reg, float delay) {
		// ʵ��������
		animation = new Animation(delay, reg);
		// ��ȡ������
		width = reg[0].getRegionWidth();
		// ��ȡ����߶�
		height = reg[0].getRegionHeight();
	}

	public void update(float delta) {

	}

	public void render(SpriteBatch batch, float delta) {
		// ��ʼ����
		batch.begin();
		// ���ƶ���
		batch.draw(animation.getKeyFrame(delta, true), 
				body.getPosition().x * RATE - width / 2, 
				body.getPosition().y * RATE - height / 2);
		// ��������
		batch.end();
	}

	public Body getBody() {
		return body;
	}

	public Vector2 getPosition() {
		return body.getPosition();
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
}
