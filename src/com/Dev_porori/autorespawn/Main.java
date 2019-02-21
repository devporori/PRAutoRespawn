package com.Dev_porori.autorespawn;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;
	public Server bukkit;
	private NMS nms;
	private final String PREFIX = "��c[ ��fPRAutoRespawn ��c] ��f";

	public void onEnable() {
		instance = this;
		bukkit = getServer();
		String pName = bukkit.getClass().getPackage().getName();
		String[] pSpilt = pName.split("\\.");
		String ver = pSpilt[(pSpilt.length - 1)];
		try {
			Class<?> nmsClass = Class.forName("com.Dev_porori.autorespawn.MCVersion." + ver);
			if (NMS.class.isAssignableFrom(nmsClass))
				nms = ((NMS) nmsClass.getConstructor(new Class[0]).newInstance(new Object[0]));
			else {
				log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.");
				setEnabled(false);
			}
		} catch (ClassNotFoundException e) {
			log(ver + "(��)��� ������ �� �� �����ϴ�.");
			setEnabled(false);
		} catch (InstantiationException e) {
			log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.\n����: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (IllegalAccessException e) {
			log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.\n����: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (IllegalArgumentException e) {
			log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.\n����: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (InvocationTargetException e) {
			log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.\n����: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (NoSuchMethodException e) {
			log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.\n����: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (SecurityException e) {
			log("������ �߰ߵǾ� �÷������� ��Ȱ��ȭ �˴ϴ�.\n����: ");
			e.printStackTrace();
			setEnabled(false);
		}
		if (isEnabled()) {
			nms.registerDeathListener(this);
			log("�÷������� Ȱ��ȭ �Ǿ����ϴ�!");
			log("Ȯ�ε� ���� : " + ver);
		}
	}

	private void log(String text) {
		Bukkit.getConsoleSender().sendMessage(PREFIX + text);
	}
}
