/**
 * 
 */
package no.hvl.dat152.obl4.blog;


public class Constants {

	public static final String WEB_CONTEXT = "/DAT152BlogAppOblig4";
	
	// IdP parameters
	public static String CLIENT_ID = "dat152BlogOblig4";						// this is defined by the client during registration at the Identity Provider
	public static String CLIENT_SECRET = "HZRQPCVPK6wXbQahwPXmLYAdtuWLhAdz";	// this is issued to the client by the identity Provider during registration
	
	public static final String STATE = "abcdef";								// this should be a secure random number (not used in this example)
	
	public static final int IDP_PORT = 8080;
	public static final String IDP_AUTH_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/DAT152/protocol/openid-connect/auth";
	public static final String IDP_LOGOUT_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/DAT152/protocol/openid-connect/logout";
	public static final String IDP_TOKEN_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/DAT152/protocol/openid-connect/token";
	public static final String IDP_USERCLAIMS_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/DAT152/protocol/openid-connect/userinfo";
	public static final String IDP_REGISTER_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/DAT152/protocol/openid-connect/register";
	
	public static final String IDP_PATH = "/realms/DAT152";
	
	// SP parameters
	public static final int SP_CALLBACK_PORT = 9090;
	public static final String SP_ADDRESS = "http://localhost:"+ SP_CALLBACK_PORT + WEB_CONTEXT;
	public static final String SP_CALLBACK_ADDRESS = "http://localhost:"+SP_CALLBACK_PORT + WEB_CONTEXT + "/callback";
	public static final String SP_LOGOUT_ADDRESS = "http://localhost:"+SP_CALLBACK_PORT + WEB_CONTEXT + "/logout";
	

}


