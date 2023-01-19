package model;

import java.util.Vector;

public class UserModel {

	public static boolean logstate;

	public static int u_no = -1;
	public static Vector<String> u_name;
	public static String u_id;
	public static String u_pw;

	public static void setUserNull() {
		u_no = -1;
		u_name = null;
		u_id = null;
		u_pw = null;
	}

}
