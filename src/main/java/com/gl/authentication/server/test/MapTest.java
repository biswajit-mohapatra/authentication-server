package com.gl.authentication.server.test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
  private static final String ZAPPOS_6PM_DEFAULT = "Zappos/6pm";
  private static final String VRSNL_DEFAULT = "vrsnl";
  private static final String ZAPPOS_6PM = ZAPPOS_6PM_DEFAULT;
  private static final String ZAPPOS = "ZAPPOS";
  private static final String SIXPM = "6PM";
  private static final String VRSNL = "VRSNL" ;
  private static final String VZS = "VZS";
  private static final String UNKNOWN = "unknown";
  
  /*
   * report parameters
   */
  private static final String REPORT_SUBJECT = "subject";
  private static final String REPORT_SITE = "site";
  private static final String REPORT_CONTACT1 = "contact1";
  private static final String REPORT_CONTACT2 = "contact2";
  private static final String REPORT_SIGNATURE = "signature";
  
  private static final String REPORT_CONF1 = "conf1";
  private static final String REPORT_CONF2 = "conf2";
  private static final String REPORT_NOTIFY_AT = "notifyAt";
  
  public static void main(String[] args) throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("supplierInfoForClosedPos", "ABC ABC");
    map.putAll(setMap("zappos".toUpperCase()));
    
  System.out.println("FOUND UNKNWN >>>"+map.containsKey(UNKNOWN));
    
    System.out.println("map>>>>>>>>>"+map);
   
}

  private Map<String, Object> setMap(String siteName) {
    Map<String, Object> map = new HashMap<String, Object>();
    switch (siteName) {
      case VRSNL:
        map.put(REPORT_SUBJECT, VRSNL);
        map.put(REPORT_SITE, VRSNL_DEFAULT);
        map.put(REPORT_CONTACT1, VRSNL_DEFAULT);
        map.put(REPORT_CONTACT2, VRSNL_DEFAULT + ".com");
        map.put(REPORT_SIGNATURE, VRSNL);
        map.put(REPORT_CONF1, VZS + " LLC");
        map.put(REPORT_CONF2, VRSNL);
        map.put(REPORT_NOTIFY_AT, VRSNL);
        break;
      case ZAPPOS:
      case SIXPM:
        map.put(REPORT_SUBJECT, ZAPPOS_6PM.toUpperCase());
        map.put(REPORT_SITE, ZAPPOS_6PM);
        map.put(REPORT_CONTACT1, ZAPPOS_6PM);
        map.put(REPORT_CONTACT2, ZAPPOS_6PM);
        map.put(REPORT_SIGNATURE, ZAPPOS + ".com LLC");
        map.put(REPORT_CONF1, ZAPPOS + ".com");
        map.put(REPORT_CONF2, ZAPPOS);
        map.put(REPORT_NOTIFY_AT, ZAPPOS);
        break;
      default:
        map.put(UNKNOWN, UNKNOWN);
        break;

    }
    return map;
  }
}
