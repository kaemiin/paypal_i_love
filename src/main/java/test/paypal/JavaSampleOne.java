package test.paypal;

import java.util.*;

import com.paypal.api.openidconnect.*;
import com.paypal.base.ClientCredentials;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class JavaSampleOne {

	// Replace these values with your clientId and secret. You can use these to get started right now.
 	private static final String clientId = "";
 	private static final String clientSecret = "";


	public void getUserConsent() {

		System.out.println("Do getUserConsent...");
		
		List<String> scopelist = new ArrayList<String>();
		//scopelist.add("openid");
		//scopelist.add("profile");
		scopelist.add("email");

		//TODO
		String redirectURI = "https://localhost:8181/s1/PaypalCallBack";
		
		ClientCredentials clientCredentials = new ClientCredentials();
		clientCredentials.setClientID(clientId);
		clientCredentials.setClientSecret(clientSecret);

        APIContext context = new APIContext(clientId, clientSecret, "sandbox");

        String redirectUrl = Session.getRedirectURL(redirectURI, scopelist, context, clientCredentials);

		System.out.println(redirectUrl);		

	}

	public void getAccessToken() {	
		
		String code = "";	//	From getUserConsent() get
		
		APIContext context = new APIContext(clientId, clientSecret, "sandbox");
		
		try {
			
			Tokeninfo info = Tokeninfo.createFromAuthorizationCode(context, code);
			
			String accessToken = info.getAccessToken();
			
			System.out.println(accessToken);

	     }
	     catch (PayPalRESTException e) {
	         System.err.println(e.getDetails());
	     }
		
	}

}
