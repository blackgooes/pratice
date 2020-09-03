package test.xml;

import java.util.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import utils.StringUtils;

public class xpath {
    public static void main(String[] args) {
        String resXmp = "<Response><anyType xmlns:q1=\"http://www.w3.org/2001/XMLSchema\" d1p1:type=\"q1:string\" xmlns:d1p1=\"http://www.w3.org/2001/XMLSchema-instance\">{\"patientName\":\"陈付宁\",\"idCardNo\":\"371121199501204216\",\"ResultMsg\":\"成功\",\"Data\":\"23004161579\",\"ResultCode\":\"0\"}</anyType></Response>";
        List<Map<String, Object>> dataMapList = responseXml2Map(resXmp,"","","/Response");

    }
    private static List<Map<String, Object>> responseXml2Map(String responseXml, String resultCodeNode, String resultMsgNode, String dataNode){
        List<Map<String, Object>> dataMapList = new ArrayList<Map<String,Object>>();
        try {
            Document doc = DocumentHelper.parseText(responseXml); //将字符串转为XML
            if (StringUtils.isNotBlank(resultCodeNode)) {
                String resultCode = doc.selectSingleNode(resultCodeNode).getText();
                if(!"0".equalsIgnoreCase(resultCode)) {
                    String resultMsg = doc.selectSingleNode(resultMsgNode).getText();
                    System.out.println("responseXml2Map resultMsg=" + resultMsg);
                    return dataMapList;
                }
            }
            if (StringUtils.isBlank(dataNode)) {
                System.out.println("responseXml2Map resultDataNode is empty!");
                return dataMapList;
            }
            List dataList = doc.selectNodes(dataNode);
            for(Iterator iter = dataList.iterator(); iter.hasNext();) {
                Map<String, Object> itemMap = new HashMap<String, Object>();
                Element element = (Element)iter.next();
                //递归遍历当前节点所有的子节点
                List<Element> listElement = element.elements();//所有一级子节点的list
                for(Element childEle:listElement){//遍历所有一级子节点
                    String text = childEle.getText();
                    if (text != null) {
                        text = text.trim();
                    }
                    itemMap.put(childEle.getName(), text);
                }
                dataMapList.add(itemMap);
            }
        } catch(Exception e) {
            System.out.println("responseXml2Map error=" + e);
        }
        return dataMapList;
    }
}
