package com.hit.hackgame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hit.hackgame.main.Yelling;

public class Tree {
	// ������������
	private Texture texture;

	public Tree() {
		// ʵ������������
		texture = Yelling.assetManager.get("images/tree.png");
	}

	public void render(SpriteBatch batch) {
		// ��ʼ����
		batch.begin();
		// ���Ʊ���
		batch.draw(texture, 0, 0);
		// ��������
		batch.end();
	}
}
