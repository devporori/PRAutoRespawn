package com.Dev_porori.autorespawn;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;
	public Server bukkit;
	private NMS nms;
	private final String PREFIX = "§c[ §fPRAutoRespawn §c] §f";

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
				log("오류가 발견되어 플러그인이 비활성화 됩니다.");
				setEnabled(false);
			}
		} catch (ClassNotFoundException e) {
			log(ver + "(이)라는 버전은 알 수 없습니다.");
			setEnabled(false);
		} catch (InstantiationException e) {
			log("오류가 발견되어 플러그인이 비활성화 됩니다.\n내용: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (IllegalAccessException e) {
			log("오류가 발견되어 플러그인이 비활성화 됩니다.\n내용: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (IllegalArgumentException e) {
			log("오류가 발견되어 플러그인이 비활성화 됩니다.\n내용: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (InvocationTargetException e) {
			log("오류가 발견되어 플러그인이 비활성화 됩니다.\n내용: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (NoSuchMethodException e) {
			log("오류가 발견되어 플러그인이 비활성화 됩니다.\n내용: ");
			e.printStackTrace();
			setEnabled(false);
		} catch (SecurityException e) {
			log("오류가 발견되어 플러그인이 비활성화 됩니다.\n내용: ");
			e.printStackTrace();
			setEnabled(false);
		}
		if (isEnabled()) {
			nms.registerDeathListener(this);
			log("플러그인이 활성화 되었습니다!");
			log("확인된 버전 : " + ver);
		}
	}

	private void log(String text) {
		Bukkit.getConsoleSender().sendMessage(PREFIX + text);
	}
}
