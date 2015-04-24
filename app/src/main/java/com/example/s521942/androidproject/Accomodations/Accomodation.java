package com.example.s521942.androidproject.Accomodations;

import com.example.s521942.androidproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Accomodation {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("Horizons West Apartment", R.drawable.horizon ,"http://maryvillerentalfinder.com/classifieds/index.cfm?redir=listings&requesttimeout=500&srchwhere=4&state=&country=&fromdate=&todate=&sweeks=0&attach=&numberofads=10&srchorder=vchprice&srchway=DESC&srchby=A&Submit=Start%2BSearch&clientID=29&srchfor=horizons&search.x=29&search.y=22&search=search"));
        addItem(new DummyItem("parkway apartments", R.drawable.a,"http://maryvillerentalfinder.com/classifieds/index.cfm?redir=listings&requesttimeout=500&srchwhere=4&state=&country=&fromdate=&todate=&sweeks=0&attach=&numberofads=10&srchorder=vchprice&srchway=DESC&srchby=A&Submit=Start%2BSearch&clientID=29&srchfor=parkway&search.x=29&search.y=22&search=search"));
        addItem(new DummyItem("mulberry apartments",R.drawable.b,"http://maryvillerentalfinder.com/classifieds/index.cfm?redir=listings&requesttimeout=500&srchwhere=4&state=&country=&fromdate=&todate=&sweeks=0&attach=&numberofads=10&srchorder=vchprice&srchway=DESC&srchby=A&Submit=Start%2BSearch&clientID=29&srchfor=mulberry&search.x=33&search.y=27&search=search"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public int imageID;
       public String url;

        public DummyItem(String id, int imageID,String url) {
            this.id = id;
            this.imageID=imageID;
            this.url=url;
        }

        @Override
        public String toString() {
            return id;
        }
    }
}
