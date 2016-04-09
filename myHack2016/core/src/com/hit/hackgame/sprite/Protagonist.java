package com.hit.hackgame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.hit.hackgame.main.Yelling;

public class Protagonist extends GameSprite {
	// ����������Ŀ
	private int starsCoumt;
	// ������������
	private int allStarsCoumt;
	// Ů������
	private Texture tex;

	public Protagonist(Body body) {
		super(body);
		// �����ʼ��
		tex = Yelling.assetManager.get("images/girl.png", Texture.class);
		// ��ʼ����������
		TextureRegion[] region = TextureRegion.split(tex, 48, 48)[0];
		// ��ʼ�����Ƕ���
		setAnimation(region, 1 / 12f);

	}

	// �ռ�����
	public void collectStars() {
		starsCoumt++;
	}

	// �����ռ�������Ŀ
	public int getStarsCoumt() {
		return starsCoumt;
	}

	// ��ȡ��������
	public int getAllStarsCoumt() {
		return allStarsCoumt;
	}

	// ����������Ŀ
	public void setStarsCoumt(int starsCoumt) {
		this.starsCoumt = starsCoumt;
	}

	// ������������
	public void setAllStarsCoumt(int allStarsCoumt) {
		this.allStarsCoumt = allStarsCoumt;
	}
}
