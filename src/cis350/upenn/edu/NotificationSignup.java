package cis350.upenn.edu;

import java.util.Set;

import android.content.Context;

import com.parse.PushService;

public class NotificationSignup{
	
	public static void signupAllRC(Context context){
		addChannel("OCP",context);
		addChannel("CJC",context);
		addChannel("RJC",context);
		addChannel("SC",context);
		addChannel("SYQ",context);
	}
	public static void signupAllIO(Context context){
		addChannel("PIPAC",context);
		addChannel("JS",context);
		addChannel("ICC",context);
		addChannel("PA",context);
		addChannel("PFOI",context);
		addChannel("TAMID",context);
	}
	public static void signupAllSJ(Context context){
		addChannel("BBBS",context);
		addChannel("OCPC",context);
		addChannel("SK",context);
		addChannel("ATID",context);
		addChannel("HE",context);
		addChannel("PrS",context);
	}
	public static void signupAllED(Context context){
		addChannel("JLIC",context);
		addChannel("SNL",context);
		addChannel("HEC",context);
		addChannel("JSSC",context);
		addChannel("DBH",context);
		addChannel("TPHP",context);
		addChannel("J101",context);
	}
	public static void signupAllJC(Context context){
		addChannel("JB",context);
		addChannel("PS",context);
		addChannel("ShC",context);
		addChannel("PT",context);
		addChannel("MC",context);
	}
	public static Set<String> getChannels(Context context){
		return PushService.getSubscriptions(context);
	}
	public static void removeChannel(String s, Context context){
		PushService.unsubscribe(context, s);
	}
	public static void addChannel(String s,Context context){
		PushService.subscribe(context, s, MenuActivity.class);
	}
	public static boolean signedUpForChannel(String s, Context context){
		return PushService.getSubscriptions(context).contains(s);
	}
	public static boolean signedUpForAllRC(Context context){
		Set<String> channels = getChannels(context);
		return 	channels.contains("OCP") && 
				channels.contains("CJC") && 
				channels.contains("RJC") &&
				channels.contains("SC") &&
				channels.contains("SYQ");
	}
	public static boolean signedUpForAllIO(Context context){
		Set<String> channels = getChannels(context);
		return 	channels.contains("PIPAC") && 
				channels.contains("JS") && 
				channels.contains("ICC") &&
				channels.contains("PA") &&
				channels.contains("PFOI") &&
				channels.contains("TAMID");	
	}
	public static boolean signedUpForAllSJ(Context context){
		Set<String> channels = getChannels(context);
		return 	channels.contains("BBBS") && 
				channels.contains("OCPC") && 
				channels.contains("SK") &&
				channels.contains("ATID") &&
				channels.contains("HE") &&
				channels.contains("PrS");	
	}
	public static boolean signedUpForAllED(Context context){
		Set<String> channels = getChannels(context);
		return 	channels.contains("JLIC") && 
				channels.contains("SNL") && 
				channels.contains("HEC") &&
				channels.contains("JSSC") &&
				channels.contains("DBH") &&
				channels.contains("TPHP") &&
				channels.contains("J101");	
	}
	public static boolean signedUpForAllJC(Context context){
		Set<String> channels = getChannels(context);
		return 	channels.contains("JB") && 
				channels.contains("PS") && 
				channels.contains("PT") &&
				channels.contains("MC") &&
				channels.contains("ShC");
	}

}