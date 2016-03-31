package com.guestbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.guestbook.model.Entry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GuestbookPortlet
 */
public class GuestbookPortlet extends MVCPortlet {
 
	public void addEntry(ActionRequest req, ActionResponse res ){
		try {
			
			String userName = ParamUtil.getString(req, "name");
			String message = ParamUtil.getString(req, "message");
			
			String newEntry = userName + "^" + message;

		
			System.out.println("newEntry mvn: "+newEntry);
			
			PortletPreferences prefs =  req.getPreferences();
			
			String[] guestbookEntries = prefs.getValues("guestbook-entries",
			          new String[1]);

	       List<String> entries = new ArrayList<String>();

	       if (guestbookEntries != null) {

	         entries = new ArrayList<String>(Arrays.asList(prefs.getValues(
	              "guestbook-entries", new String[1])));

	       }
	       
	       entries.add(newEntry);
	       
	       String[] array = entries.toArray(new String[entries.size()]);
		    
//	       System.out.println("AddEntry : guestbookEntries :"+array);
	       System.out.println("AddEntry mvn : entries :"+entries);

			prefs.setValues("guestbook-entries", array);
			
			
			try {
				prefs.store();
			} catch (ValidatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ReadOnlyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		}

		@Override
		public void render(RenderRequest renderRequest, RenderResponse response) throws PortletException, IOException {
			
			System.out.println("GuestbookPortlet mvn: render() called...!");
			
			PortletPreferences prefs = renderRequest.getPreferences();
		    String[] guestbookEntries = prefs.getValues("guestbook-entries",
		            new String[1]);

		    
		    System.out.println("Render : guestbookEntries mvn:"+guestbookEntries);
		    
		    if (guestbookEntries != null) {

		        List<Entry> entries = parseEntries(guestbookEntries);

		        renderRequest.setAttribute("entries", entries);

		    }
			
			super.render(renderRequest, response);
		}
		
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			System.out.println("GuestbookPortlet mvn: doView() called...!");
			
			super.doView(renderRequest, renderResponse);
		}

		private List<Entry> parseEntries (String[] guestbookEntries) {

		    ArrayList<Entry> entries = new ArrayList();

		    for (String entry : guestbookEntries) {

		        String[] parts = entry.split("\\^", 2);
		        Entry gbEntry = new Entry(parts[0], parts[1]);
		        entries.add(gbEntry);

		    }

		    return entries;

		}

		public void publicTestMethod(String testStr){
			System.out.println("GuestbookPortlet :: testMethod() ::"+testStr);
		}
		
	 

}
